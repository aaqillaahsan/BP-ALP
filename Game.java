
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
        player.getInventory().addItem(new BrokenWineGlass());
        player.getInventory().addItem(new BloodstainedWeight());
        player.getJournal().addEClue(new BloodyMark());
        player.getJournal().addEClue(new ArthurCon());
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
                    } else if(night >= 2 && i.getName().equalsIgnoreCase("Arthur's Bedroom") || i.getName().equalsIgnoreCase("Library")){
                        System.out.println(i.keyFrom);
                        return;
                    } else if(night >= 3 && i.getName().equalsIgnoreCase("Basement") || i.getName().equalsIgnoreCase("Garden")){
                        System.out.println(i.keyFrom);
                        return;
                    } else {
                        System.out.println("That room is inaccessible. For now. . . ");
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
        while (true) { 
            System.out.println("\nITEMS =============================");
            player.getInventory().evidenceDisplay();
            System.out.println();
            player.getJournal().evidenceDisplay();
            System.out.println("\n~ ITEM (item name)");
            System.out.println("~ CLUE (clue name)");
            System.out.println("~ END CONVICTION");
            System.out.print("> ");
            try {
                command = sc.nextLine();
                command = command.toUpperCase();
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
                if(player.getInventory().hasItem(evidence) && !player.getInventory().isItemClue(evidence)){
                    System.out.println("That is not an evidence");
                    continue;
                }

                accused.explainEvidence(evidence);
                System.out.println(accused.getName()+ ":");
                System.out.printf("\" %s \"\n",accused.respondEvid(evidence));

                if(!accused.isRelevant(evidence)){
                    System.out.println("He's right, this doesn't make sense at all");
                    sc.nextLine();
                    continue;
                }

                accepted.add(evidence);
                System.out.println("You feel your resolve grows stronger");
                if(accepted.size() >= 3){
                    System.out.println("You feel like you have enough evidence to sentence them");
                }
            } else{
                System.out.println("Unknown Command");
                continue;
            }
            sc.nextLine();
        }

        return accepted;
    }

    public void ending(NPC accused, ArrayList<String> Evidence){
        System.out.println("\n\n\n\n\n\n");
        boolean hasBody = false;
        for(String i: Evidence){
            if(i.equalsIgnoreCase("Arthur's Bloodied Body")) hasBody = true;
        }
        //Ending 1
        if(Evidence.size() < 3){
            String[] ending1 = {
                "Unfortunately, you failed as a Detective",
                "You did not present enough evidence.",
                "As a result, you can't convict anybody.",
                "The mystery behind Ravenwood Mansion remains unsolved.",
                "And it probably will for eons to come.",
                "Did Arthur die? was He murdered? or did He ran away from the Manse?",
                "Worst thing is if He indeed was murdered.",
                ". . .",
                ". . .",
                "The killer still roams free.",
                "Living like a normal citizen.",
                "All because of your incompetence. . .",
                "=== BAD ENDING ==="
            };
            for(String i: ending1){
                System.out.println(i);
                sc.nextLine();
            }
            GameOver = true;
            return;
        }

        //Ending 2
        if(!accused.isCulprit() && hasBody){
            String[] ending2p1 = {
                "Great job detective",
                "You've uncovered the dark secrets of the Ravenwood Mansion",
                "Arthur's dead, and there's nothing can be done",
                "One can only pray and hope peace can come upon the family",
            };
            String[] ending2p2= {
                "The judge has deemed their crime worthy of death",
                "Because of how heinous and sinister the actions that happened",
                "On the execution day, You are ordered to be present as a witness. . .",
            };
            String[] ending2p3 = {
                "You see at the corner of your eye. . .",
                "Someone's grinning. Laughing even. But you can't make their face. . .",
                "After witnessing their execution. . .",
                "You felt doubt. . .",
                "Have you really done a great job?",
                "Have you. . .",
                "Made the right choice?",
                "You've recieved a letter a few days later. . .",
            };
            
            for(String i: ending2p1){
                System.out.println(i);
                sc.nextLine();
            }
            System.out.printf("You've accused %s of being the culprit\n", accused.getName());
            sc.nextLine();

            for(String i: ending2p2){
                System.out.println(i);
                sc.nextLine();
            }
    
            accused.executionDay();

            for(String i: ending2p3){
                System.out.println(i);
                sc.nextLine();
            }
            
            System.out.printf("You've collected %d of real evidence\n", player.realEvidenceCount(Evidence));
            sc.nextLine();
            System.out.println("=== BAD ENDING ===");
            sc.nextLine();
            GameOver = true;
            return;
        }

        //Ending 3 
        if(!accused.isCulprit() && !hasBody){
            String[] ending3p1 = {
                "You've. . .",
                "What have you done really?",
                "What have you solved?",
                "Where is Arthur?",
                "That's not important I guess",
                "The mystery behind Ravenwood Mansion seems to be left unsolved",
                "Because of you.",
                "One can only speculate what really happened to Arthur.",
            };
            String[] ending3p2 = {
                "The judge is. . .",
                "Confused by what crime that the culprit accused of",
                "Murder? well there isn't exactly a body presented",
                "The judge deemed the ruling as Invalid",
                "You felt ashamed. Your pride as a Detective is hurt"
            };
            for(String i: ending3p1){
                System.out.println(i);
                sc.nextLine();
            }

            System.out.printf("You've accused %s of being the culprit\n", accused.getName());
            sc.nextLine();

            for(String i: ending3p2){
                System.out.println(i);
                sc.nextLine();
            }

            System.out.printf("%s glares at you\n",accused.getName());
            sc.nextLine();
            System.out.println("Even you know apology is not enough. . .");
            sc.nextLine();
            System.out.println("You've recieved a letter a few days later. . .");
            sc.nextLine();
            System.out.printf("You've collected %d of real evidence\n", player.realEvidenceCount(Evidence));
            sc.nextLine();
            System.out.println("=== BAD ENDING ===");
            sc.nextLine();
            GameOver = true;
            return;
        }

        //Ending 4
        if(accused.isCulprit() && !hasBody){
            String[] ending4 = {
                "You've. . .",
                "What have you done really?",
                "What have you solved?",
                "Where is Arthur?",
                "That's not important I guess",
                "The mystery behind Ravenwood Mansion seems to be left unsolved",
                "Because of you.",
                "One can only speculate what really happened to Arthur.",
            };
            String[] ending4p2 = {
                "The judge is. . .",
                "Confused by what crime that the culprit accused of",
                "Murder? well there isn't exactly a body presented",
                "The judge deemed the ruling as Invalid",
                "You felt ashamed. Your pride as a Detective is hurt"
            };
            String[] ending4p3 = {
                "Almost looked like He walked with. . . confidence? fear? confusion?",
                "You cannot make sense of what You're feeling currently",
                "Something's wrong. But. . . there's nothing can be done",
                "You've recieved a letter a few days later. . .",
            };

            for(String i: ending4){
                System.out.println(i);
                sc.nextLine();
            }
            System.out.printf("You've accused %s of being the culprit\n", accused.getName());
            sc.nextLine();

            for(String i: ending4p2){
                System.out.println(i);
                sc.nextLine();
            }
            System.out.printf("%s left the room silently. . .\n", accused.getName());
            sc.nextLine();
           
            for(String i: ending4p3){
                System.out.println(i);
                sc.nextLine();
            }
            System.out.printf("You've collected %d of real evidence\n", player.realEvidenceCount(Evidence));
            sc.nextLine();
            System.out.println("=== BAD ENDING ===");
            sc.nextLine();
            GameOver = true;
            return;
        }

        //Ending 5
        if(accused.isCulprit() && Evidence.size() == accused.requiredEvidence.size()){
            String[] ending5 = {
                "The deed is done",
                "The family and the staff are shocked",
                "Well You were too",
                "Great job Detective.",
                "Amazingly done"
            };
            String[] ending5p2 = {
                "Who would've thought that Lucian would be the culprit",
                "His sick narrow minded decision which ended Arthur's life. . .",
                "You calmed yourself down. . .",
                "You've managed to collect all possible evidence and connections to the murder",
                "Your reputation echoes throughout the continent",
                "'The Legendary Detective'",
                "'Guardian of Peace'",
                "'Truthfinder of Ravenwood Manse'",
                "You felt proud in your achievements",
                "The judge has deemed their crime worthy of death",
                "On the execution day, You are ordered to be present as a witness. . ."
            };
            String[] ending5p3 = {
                "You've felt accomplished",
                "The family seemed to have come terms with their death",
                "Arthur's and Lucian's. . .",
                "The Mansion seemed to be back to normal",
                "With Juvia being the current Head of the Family",
                "While Charles goes to rehab about his gambling addiction. . .",
                "It seems, the family will heal. . .",
                "Another day comes. . .",
                "=== TRUE ENDING ==="
            };

            for(String i: ending5){
                System.out.println(i);
                sc.nextLine();
            }
            System.out.printf("You've accused %s of being the culprit\n", accused.getName());
            sc.nextLine();
            
            for(String i: ending5p2){
                System.out.println(i);
                sc.nextLine();
            }

            accused.executionDay();

            for(String i: ending5p3){
                System.out.println(i);
                sc.nextLine();
            }
            GameOver = true;
            return;
        }

        //Ending 6
        if(accused.isCulprit() && hasBody){
            String[] ending6 = {
                "Great job detective",
                "The mystery behind the Ravenwood Mansion has been uncovered",
                "The family looked shocked",
                "But still, you felt like you could've done more"
            };
            String[] ending6p2 = {
                "Who would've thought that Lucian would be the culprit",
                "His sick narrow minded decision which ended Arthur's life. . .",
                "You wonder, what's happening in his mind to cause all this",
                "The judge has deemed their crime worthy of death",
                "On the execution day, You are ordered to be present as a witness. . ."
            };
            String[] ending6p3 = {
                "You felt glad that this is all over",
                "The family. . .",
                "They seem to be doing just well enough. . .",
                "Another job finished. . .",
                "You've recieved a letter a few days later. . .",
            };

            for(String i: ending6){
                System.out.println(i);
                sc.nextLine();
            }

            System.out.printf("You've accused %s of being the culprit\n", accused.getName());
            sc.nextLine();

            for(String i: ending6p2){
                System.out.println(i);
                sc.nextLine();
            }
            accused.executionDay();

            for(String i: ending6p3){
                System.out.println(i);
                sc.nextLine();
            }
            System.out.printf("You've collected %d of real evidence\n", player.realEvidenceCount(Evidence));
            sc.nextLine();
            System.out.println("=== GOOD ENDING ===");
            sc.nextLine();
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
            return;
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
        String[] intro = {
            "Welcome to The Ravenwood Mansion",
            "A grand and isolated estate owned by a wealthy family.",
            "During a formal evening gathering, the family's heir, Arthur Ravenwood, mysteriously disappears.",
            "All exits are sealed, and no one is allowed to leave until the truth is uncovered.",
            "Over the course of four nights, uncover the hidden secrets that will unfold and give a peaceful resolution to the family.",
            "Goodluck, detective. . ."
        };
        String[] commandlist = {"GO (room name)", "LOOK", "TAKE (item name)", "TALK (npc name)", "INTERACT (objec name)", "INVENTORY", "JOURNAL", "END NIGHT"};

        for(String i: intro){
            System.out.print(i);
            sc.nextLine();
        }

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
                    continue;
                }
                commands(command);
            }
        }
    }
}
