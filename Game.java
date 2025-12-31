
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Room> rooms;
    private Player player;
    private int night;
    private boolean GameOver;
    private static final Scanner sc = new Scanner(System.in);

    public Game(){
        rooms = new ArrayList<>();
        player = new Player();
        night = 1;
        GameOver = false;
        setup();
    }

    public void setup(){
        //Room declaration
        Room mainHall = new MainHall();
        Room livingRoom = new LivingRoom();
        Room diningRoom = new DiningRoom();
        Room kitchen = new Kitchen();
        Room library = new Library();
        Room bedroom = new Bedroom();
        Room garden = new Garden();
        Room basement = new Basement();
        Room hiddenRoom = new HiddenRoom();

        //Add connections
        mainHall.connectRoom(livingRoom);
        mainHall.connectRoom(diningRoom);
        mainHall.connectRoom(bedroom);
        mainHall.connectRoom(basement);

        livingRoom.connectRoom(mainHall);

        diningRoom.connectRoom(mainHall);
        diningRoom.connectRoom(kitchen);

        kitchen.connectRoom(diningRoom);
        kitchen.connectRoom(garden);

        library.connectRoom(bedroom);

        bedroom.connectRoom(library);
        bedroom.connectRoom(mainHall);

        garden.connectRoom(kitchen);

        basement.connectRoom(mainHall);
        basement.connectRoom(hiddenRoom);

        //------------------
        mainHall.unlock();
        livingRoom.unlock();
        diningRoom.unlock();
        kitchen.unlock();

        rooms.add(mainHall);
        rooms.add(livingRoom);
        rooms.add(diningRoom);
        rooms.add(kitchen);
        rooms.add(library);
        rooms.add(bedroom);
        rooms.add(garden);
        rooms.add(basement);
        rooms.add(hiddenRoom);

        player.setCurrentRoom(mainHall);
    }

    public void goRoom(String name){
        Room current = player.getCurrentRoom();

        for(Room i: current.getConnections()){
            if(i.getName().equalsIgnoreCase(name)){
                if(i.islocked()){
                    String Key = i.getRequiredItem();
                    if(Key != null && player.getInventory().hasItem(Key)){
                        i.unlock();
                        System.out.printf("You used %s . . .\n", Key);
                    } else {
                        System.out.println("That room is inaccessible. For now. . .");
                        return;
                    }
                }

                player.setCurrentRoom(i);
                i.describe();
                return;
            }
        }

        System.out.println("You can't reach that room from here");
    }

    public void takeItem(String name){
        Room current = player.getCurrentRoom();
        Item item = current.getItem(name);

        if(item == null){
            System.out.println("No such item found here. . . ");
            return;
        }

        player.getInventory().addItem(item);
        current.removeItem(item);
    }

    public void talkNPC(String name){
        Room current = player.getCurrentRoom();
        for(NPC i: current.getNPCS()){
            if(i.getName().equalsIgnoreCase(name)){
                DialogClue clue = i.giveClue(night, player.getInventory(), player.getJournal());
                if(clue != null){
                    System.out.println(i.getName() + ": ");
                    System.out.printf("\" %s \"\n", clue.getText());
                    player.getJournal().addDClue(clue);
                    return;
                }

                ConditionItem citem = i.checkItem(night, player.getInventory(), player.getJournal());
                if(citem != null){
                    System.out.println(i.getName() + ": ");
                    System.out.printf("\" %s \"\n", citem.giveDialog());

                    Item item = citem.give();
                    player.getInventory().addItem(item);
                    return;
                }

                System.out.println(i.getName() + ": ");
                System.out.printf("\" %s \"\n",i.Talk(night));
                return;
            }    
        }

        System.out.println("No such person in this room. . .");
    }

    public void endNight(){
        if(night == 4){
            System.out.println("It is the final night. You must resolve this problem. . .");
        }

        night++;
        System.out.println("Another night begins. . .");
        if(night == 2){
            System.out.println("You may now access Arthur's Bedroom and the Library");
        }
        if(night == 3){
            System.out.println("You may now access Garden and Basement");
        }
        if(night == 4){
            Room Uroom = player.getCurrentRoom();
            for(Room i: rooms){
                if(i.getName().equalsIgnoreCase("Hidden Basement Room")){
                    Uroom = i;
                }
            }
            System.out.println("There is an ominous feeling in the basement. . .");
            for(Room i: rooms){
                if(i.getName().equalsIgnoreCase("Basement")){
                    i.addInteract(new CrackedWall(Uroom));
                }
            }
        }
    }

    public void interact(String name){
        Room current = player.getCurrentRoom();
        Interactable inter = current.getInteract(name);

        if(inter == null){
            System.out.println("There no such thing to interact with.");
            System.out.println();
            return;
        }

        String action = inter.interact(night, player);

        if(action != null && !action.isEmpty()){
            System.out.println(action);
        }
        System.out.println();
    }

    public void commands(String command){
        command = command.toUpperCase();
        if(command.startsWith("GO ")){
            for(Room i: rooms){
                if(command.substring(3).equalsIgnoreCase(i.getName())){
                    goRoom(command.substring(3));
                    System.out.println();
                    return;
                }
             }
            System.out.println("Unknown room");
            System.out.println();

        } else if(command.equalsIgnoreCase("LOOK")){
            System.out.println("You looked around the room. . .");
            player.getCurrentRoom().describe();
            System.out.println();

        } else if(command.startsWith("TAKE ")) {
            takeItem(command.substring(5));
            System.out.println();

        } else if(command.startsWith("TALK ")){
            talkNPC(command.substring(5));
            System.out.println();

        }else if(command.equalsIgnoreCase("INVENTORY")){
            player.getInventory().showInventory();
            System.out.println();

        }else if(command.equalsIgnoreCase("JOURNAL")){
            player.getJournal().showClues();
            System.out.println();

        }else if(command.equalsIgnoreCase("END NIGHT")){
            endNight();
            System.out.println();

        }else if (command.startsWith("INTERACT ")){
            interact(command.substring(9));

        }else {
            System.out.println("Unknown Command");
            System.out.println();
        }
    }

    public void Start(){
        System.out.println("Welcome to The Ravenwood Mansion");
        System.out.println("A grand and isolated estate owned by a wealthy family. During a formal evening gathering, the family's heir, Arthur Ravenwood, mysteriously disappears. All exits are sealed, and no one is allowed to leave until the truth is uncovered.");
        System.out.println("Over the course of four nights, uncover the hidden secrets that will unfold and give a peaceful resolution to the family.");
        System.out.println("Goodluck, detective. . .");
        String[] commandlist = {"GO (room name)", "LOOK", "TAKE (item name)", "TALK (npc name)", "INTERACT (objec name)", "INVENTORY", "JOURNAL", "END NIGHT"};

        while(!GameOver){
            System.out.printf("\nNight %d\n", night);
            System.out.printf("You are in: %s\n", player.getCurrentRoom().getName());
            String command = "";
            while(!command.equalsIgnoreCase("END NIGHT")){
                for(int i = 0;i < commandlist.length; i++){
                    System.out.printf("~ %s\n", commandlist[i]);
                }
                System.out.print("> ");
                try {
                    command = sc.nextLine();
                } catch (Exception e) {
                    System.out.println("Invalid input");
                }
                commands(command);
            }
        }
    }
}
