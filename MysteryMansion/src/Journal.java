
import java.util.ArrayList;
import java.util.Scanner;

public class Journal {
    private ArrayList<DialogClue> clues;
    private ArrayList<EnviroClue> eclues;
    private static final Scanner sc = new Scanner(System.in);

    public Journal(){
        clues = new ArrayList<>();
        eclues = new ArrayList<>();
    }

    public void addDClue(DialogClue clue){
        if(clue != null){
            clues.add(clue);
            System.out.printf("[You keep what %s said in mind]\n", clue.getSpeaker());
        }
    }

    public void addEClue(EnviroClue clue){
        if(clue != null){
            eclues.add(clue);
            System.out.println("[You wrote what happened in the Journal]");
        }
    }

    public void showClues(){
        String command ="";
        while(!command.equalsIgnoreCase("EXIT")){
            System.out.println("\nJournal: ");
            if(!clues.isEmpty()){
                System.out.println("Dialogues =========================");
                for(DialogClue i: clues){
                    System.out.println(i.getName());
                    System.out.println("---------------------------------");
                }   
            }
            if(!eclues.isEmpty()){
                System.out.println("Clues =============================");
                for(EnviroClue i: eclues){
                    System.out.println(i.getName());
                    System.out.println("---------------------------------");
                }
            }
            System.out.println("~ RECALL (entry name)");
            System.out.println("~ EXIT");
            System.out.print("> ");
            try {
                command = sc.nextLine();
                command = command.toUpperCase();
            } catch (Exception e) {
                System.out.println("Invalid Input");
                continue;
            }
            if(command.startsWith("RECALL ")){
                String entry = command.substring(7);
                for(DialogClue i: clues){
                    if(entry.equalsIgnoreCase(i.getName())){
                        i.displayClue();
                        break;
                    }
                }
                for(EnviroClue i: eclues){
                    if(entry.equalsIgnoreCase(i.getName())){
                        System.out.println(i.getName());
                        System.out.println(i.display());
                        break;
                    }
                }
            } else if(command.equalsIgnoreCase("EXIT")){
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public boolean hasClue(String clueName){
        for(DialogClue i: clues){
            if(i.getText().equalsIgnoreCase(clueName)){
                return true;
            }
        }
        for(EnviroClue i: eclues){
            if(i.getName().equalsIgnoreCase(clueName)){
                return true;
            }
        }
        
        return false;
    }
}
