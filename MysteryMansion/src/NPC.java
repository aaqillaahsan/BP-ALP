
import java.util.ArrayList;

public abstract class NPC {
    private String name;
    private boolean isCulprit;

    protected ArrayList<NightDialogue> nightDialogue = new ArrayList<>();
    protected ArrayList<ConditionClue> conditionClues = new ArrayList<>();
    protected ArrayList<ConditionItem> conditionItem = new ArrayList<>();
    protected String description;

    public NPC (String name, boolean isCulprit){
        this.name = name;
        this.isCulprit = isCulprit;
    }

    public String getName(){
        return name;
    }
    
    public String Talk(int night) {
        return nightDialogue.get(night -1).next();
    }

    public DialogClue giveClue(int night, Inventory inventory, Journal journal){
        int dialogIndex = nightDialogue.get(night - 1).getIndex();
        for(ConditionClue i: conditionClues){
            if(i.canGive(night, dialogIndex, inventory, journal)){
                return i.giveClue();
            }
        }

        return null;
    }

    public ConditionItem checkItem(int night, Inventory inventory, Journal journal){
        int dialogIndex = nightDialogue.get(night - 1).getIndex();
        for(ConditionItem i: conditionItem){
            if(i.canGive(night, dialogIndex, inventory, journal)){
                return i;
            }
        }

        return null;
    }

    public String getDesc(){
        return description;
    }

    public void setDesc(){
    }

    public boolean isCulprit(){
        return isCulprit;
    }
}
