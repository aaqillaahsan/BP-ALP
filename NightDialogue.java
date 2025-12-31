
import java.util.ArrayList;

public class NightDialogue {

    private ArrayList<String> dialogues = new ArrayList<>();
    private int index = 0;
    private String defaultdialogue;

    public NightDialogue(String defaultdialogue){
        this.defaultdialogue = defaultdialogue;
    }

    public void addDialogue(String text){
        dialogues.add(text);
    }

    public boolean hasNext(){
        return index < dialogues.size();
    }

    public String next(){
        if(hasNext()){
            return dialogues.get(index++);
        }
        return defaultdialogue;
    }

    public int getIndex(){
        return index -1;
    }
}
