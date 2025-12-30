
import java.util.ArrayList;

public class Journal {
    private ArrayList<DialogueClue> clues;

    public Journal(){
        clues = new ArrayList<>();
    }

    public void addClue(DialogueClue clue){
        if(clue != null){
            clues.add(clue);
            System.out.printf("You keep what %s said in mind", clue.getSpeaker());
        }
    }

    public void showClues(){
        System.out.println("Journal: ");
        for(DialogueClue i: clues){
            i.displayClue();
            System.out.println("---------------------------------");
        }   
    }
}
