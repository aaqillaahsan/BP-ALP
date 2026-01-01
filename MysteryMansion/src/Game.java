
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
        player.getInventory().addItem(new BasementKey());
        player.getInventory().addItem(new BedroomKey());
        player.getInventory().addItem(new LibraryPermission());
        player.getInventory().addItem(new Hammer());
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
                i.describe(player);
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

    public ArrayList<String> collectEvid(NPC accused){
        ArrayList<String> accepted = new ArrayList<>();
        String command ="";
        player.getInventory().evidenceDisplay();
        player.getJournal().evidenceDisplay();
        while (true) { 
            System.out.println("\n~ ITEM (item name)");
            System.out.println("~ CLUE (clue name)");
            System.out.println("~ END CONVICTION");
            System.out.println("> ");
            try {
                command = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
            if(command.equalsIgnoreCase("END CONVICTION")) break;
            if(command.startsWith("CLUE ") || command.startsWith("ITEM ")){
                String evidence = command.substring(5);
                if(!player.hasEvidence(evidence)){
                    System.out.println("You do not possess that evidence.");
                    continue;
                }

                accused.explainEvidence(evidence);
                System.out.println(accused.getName()+ ":");
                System.out.printf("\" %s \"",accused.respondEvid(evidence));

                if(!accused.isRelevant(evidence)){
                    System.out.println("He's right, this doesn't make sense at all");
                    continue;
                }

                accepted.add(evidence);
                System.out.println("Your feel your resolve grows stronger");
                if(accepted.size() >= 3){
                    System.out.println("You feel like you have enough evidence to sentence them");
                }
            }
        }

        return accepted;
    }

    public void ending(NPC accused, ArrayList<String> Evidence){
        //Ending 1
        if(Evidence.size() < 3){
            System.out.println("Unfortunately, you failed as a Detective");
            System.out.println("You did not present enough evidence.");
            System.out.println("As a result, you can't convict anybody.");
            System.out.println("The mystery behind Ravenwood Mansion remains unsolved.");
            System.out.println("And it probably will for eons to come.");
            System.out.println("Did Arthur die? was He murdered? or did He ran away from the Manse?");
            System.out.println("Worst thing if He indeed was murdered.");
            System.out.println(". . .");
            System.out.println(". . .");
            System.out.println("The killer still roams free.");
            System.out.println("Living like a normal citizen.");
            System.out.println("All because of your incompetence. . .");
            System.out.println("=== BAD ENDING ===");
            GameOver = true;
            return;
        }

        //Ending 2
        if(!accused.isCulprit() && player.getJournal().hasClue("Arthur's Bloodied Body")){
            System.out.println("Great job detective");
            System.out.println("You've discovered the dark secrets of the Ravenwood Mansion");
            System.out.println("Arthur's dead, and there's nothing can be done");
            System.out.println("One can only pray and hope peace can come upon the family");
            System.out.printf("You've accused %s of being the culprit\n", accused.getName());
            System.out.println("The judge has deemed their crime worthy of death");
            System.out.println("Because of how heinous and sinister the actions that happened");
            System.out.println("On the execution day, You are ordered to be present as a witness. . .");
            accused.executionDay();

            System.out.println("You see at the corner of your eye. . .");
            System.out.println("Someone's grinning. Laughing even. But you can't make their face. . .");
            System.out.println("After witnessing their execution. . .");
            System.out.println("You felt doubt. . .");
            System.out.println("Have you really done a great job?");
            System.out.println("Have you. . .");
            System.out.println("Made the right choice?");
            System.out.println("=== BAD ENDING ===");
            GameOver = true;
            return;
        }

        //Ending 3 
        if(!accused.isCulprit() && !player.getJournal().hasClue("Arthur's Bloodied Body")){
            System.out.println("You've. . .");
            System.out.println("What have you done really?");
            System.out.println("What have you solved?");
            System.out.println("Where is Arthur?");
            System.out.println("That's not important I guess");
            System.out.println("The mystery behind Ravenwood Mansion seems to be left unsolved");
            System.out.println("By you.");
            System.out.println("Anyway. . .");
            System.out.printf("You've accused %s of being the culprit\n", accused.getName());
            System.out.println("The judge is. . .");
            System.out.println("Confused by what crime that the culprit accused of");
            System.out.println("Murder? well there isn't exactly a body presented");
            System.out.println("The judge deemed the ruling as Invalid");
            System.out.println("You felt ashamed. Your pride as a Detective is hurt");
            System.out.printf("%s glares at you\n",accused.getName());
            System.out.println("Even you know apology is not enough. . .");
            System.out.println("=== BAD ENDING ===");
            GameOver = true;
            return;
        }

        //Ending 4
        if(accused.isCulprit() && !player.getJournal().hasClue("Arthur's Bloodied Body")){
            System.out.println("You've. . .");
            System.out.println("What have you done really?");
            System.out.println("What have you solved?");
            System.out.println("Where is Arthur?");
            System.out.println("That's not important I guess");
            System.out.println("The mystery behind Ravenwood Mansion seems to be left unsolved");
            System.out.println("By you.");
            System.out.println("Anyway. . .");
            System.out.printf("You've accused %s of being the culprit\n", accused.getName());
            System.out.println("The judge is. . .");
            System.out.println("Confused by what crime that the culprit accused of");
            System.out.println("Murder? well there isn't exactly a body presented");
            System.out.println("The judge deemed the ruling as Invalid");
            System.out.println("You felt ashamed. Your pride as a Detective is hurt");
            System.out.printf("%s left the room silently. . .\n", accused.getName());
            System.out.println("Almost looked like He walked with. . . confidence? fear? confusion?");
            System.out.println("You cannot make sense of what You're feeling currently");
            System.out.println("Something's wrong. But. . . there's nothing can be done");
            GameOver = true;
            return;
        }

        //Ending 5
        if(accused.isCulprit() && Evidence.size() == accused.requiredEvidence.size()){
            System.out.println("The deed is done");
            System.out.println("The family and the staff are shocked");
            System.out.println("Well You were too");
            System.out.println("Great job Detective.");
            System.out.println("Amazingly done");
            System.out.printf("You've accused %s of being the culprit\n", accused.getName());
            System.out.println("Who would've thought that Lucian would be the culprit");
            System.out.println("His sick narrow minded decision which ended Arthur's life. . .");
            System.out.println("You calmed yourself down. . .");
            System.out.println("You've managed to collect all possible evidence and connections to the murder");
            System.out.println("Your reputation echoes throughout the continent");
            System.out.println("'The Legendary Detective'");
            System.out.println("'Guardian of Peace'");
            System.out.println("'Truthfinder of Ravenwood Manse'");
            System.out.println("You felt proud in your achievements");
            System.out.println("The judge has deemed their crime worthy of death");
            System.out.println("On the execution day, You are ordered to be present as a witness. . .");
            accused.executionDay();
            System.out.println("You've felt accomplished");
            System.out.println("The family seemed to have come terms with their death");
            System.out.println("Arthur's and Lucian's. . .");
            System.out.println("The Mansion seemed to be back to normal");
            System.out.println("With Juvia being the current Head of the Family");
            System.out.println("While Charles goes to rehab about his gambling addiction. . .");
            System.out.println("It seems, the family will heal. . .");
            System.out.println("Another day comes. . .");
            System.out.println("=== TRUE ENDING ===");
            GameOver = true;
            return;
        }

        if(accused.isCulprit()){
            System.out.println("Great job detective");
            System.out.println("The mystery behind the Ravenwood Mansion has been uncovered");
            System.out.println("The family looked shocked");
            System.out.println("But still, you felt like you could've done more");
            System.out.printf("You've accused %s of being the culprit\n", accused.getName());
            System.out.println("Who would've thought that Lucian would be the culprit");
            System.out.println("His sick narrow minded decision which ended Arthur's life. . .");
            System.out.println("You wonder, what's happening in his mind to cause all this");
            System.out.println("The judge has deemed their crime worthy of death");
            System.out.println("On the execution day, You are ordered to be present as a witness. . .");
            accused.executionDay();

            System.out.println("You felt glad that this is all over");
            System.out.println("The family. . .");
            System.out.println("They seem to be doing just well enough. . .");
            System.out.println("Another job finished. . .");
            System.out.println("=== GOOD ENDING ===");
            GameOver = true;
        }
    }

    public void Accuse(){
        System.out.println("\n========== FINAL NIGHT ==========\n");
        System.out.println("It is the final night, you must give a conclusion to the family.");
        System.out.println("After 4 nights of exploring the residence, you must finally present");
        System.out.println("Who is the culprit ?");
        ArrayList<NPC> list = new ArrayList<>();
        boolean sure = false;
        String accusedname;
        NPC accused = new Edmund();
        for(Room i: rooms){
            list.addAll(i.getNPCS());
        }
        while(!sure){
            NPC tempaccused = new Edmund();
            boolean exist = false;
            for(NPC i: list){
                System.out.printf("~ %s\n", i.getName());
            }
            System.out.println("Who do you accuse?");
            System.out.print("> ");
            try {
                accusedname = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid Input");
                continue;
            }
            for(NPC i: list){
                if(accusedname.equalsIgnoreCase(i.getName())){ 
                    exist = true;
                    tempaccused = i;
                    break;
                }
            }
            if(!exist){
                System.out.println("Person doesn't exist");
                continue;
            }


            System.out.println("Are you sure you want to accuse this person? (y/n)");
            System.out.print("> ");
            String confirm;
            try {
                confirm = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid Input");
                continue;
            }
            if(confirm.equalsIgnoreCase("y")){
                sure = true;
                accused = tempaccused;
            }
        }
        System.out.println("Very well. Now you must present a minimum of 3 relevant pieces of evidence.");
        System.out.println("Goodluck Detective. . .");

        ArrayList<String> Evidence = collectEvid(accused);
        
        ending(accused, Evidence);
    }

    public void endNight(){
        if(night == 4){
            System.out.println("It is the final night. You must resolve this problem. . .");
            Accuse();
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
            player.getCurrentRoom().describe(player);
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
