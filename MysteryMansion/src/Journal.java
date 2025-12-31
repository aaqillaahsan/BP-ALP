
import java.util.ArrayList;

public class Journal {
    private ArrayList<DialogClue> clues;
    private ArrayList<EnviroClue> eclues;

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
        System.out.println("Journal: ");
        if(!clues.isEmpty()){
            System.out.println("Dialogues =========================");
            for(DialogClue i: clues){
                i.displayClue();
                System.out.println("---------------------------------");
            }   
        }
        if(!eclues.isEmpty()){
            System.out.println("Clues =============================");
            for(EnviroClue i: eclues){
                System.out.println(i.getName());
                i.display();
                System.out.println("---------------------------------");
            }
        }
    }
}
