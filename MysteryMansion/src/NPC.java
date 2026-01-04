
import java.util.ArrayList;
import java.util.Scanner;

public abstract class NPC {
    private String name;
    private boolean isCulprit;

    protected static final Scanner sc= new Scanner(System.in);
    protected ArrayList<NightDialogue> nightDialogue = new ArrayList<>();
    protected ArrayList<ConditionClue> conditionClues = new ArrayList<>();
    protected ArrayList<ConditionItem> conditionItem = new ArrayList<>();
    protected String description;

    protected ArrayList<String> requiredEvidence = new ArrayList<>();
    protected ArrayList<EvidenceReason> accuseReason = new ArrayList<>();
    protected ArrayList<EvidenceResponse> evidenceResponses = new ArrayList<>();
    protected ArrayList<String> denialReactions = new ArrayList<>();

    protected ArrayList<String> executionLine = new ArrayList<>();

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

    public boolean isRelevant(String evidenceName){
        for(String i: requiredEvidence){
            if(evidenceName.equalsIgnoreCase(i)) return true;
        }
        return false;
    }

    public String respondEvid(String evidenceName){
        for(EvidenceResponse i: evidenceResponses){
            if(i.getName().equalsIgnoreCase(evidenceName)) return i.getResponse();
        }

        if(!denialReactions.isEmpty()) return denialReactions.get(0);

        return "That has nothing to do with me";
    }

    public boolean canConvict(ArrayList<String> Evidences){
        int evicount = 0;

        for(String i: Evidences){
            if(isRelevant(i)){
                evicount++;
            }   
        }
        
        return evicount >= 3;
    }

    public void explainEvidence(String name){
        for(EvidenceReason i: accuseReason){
            if(i.getName().equalsIgnoreCase(name)){
                System.out.println(i.getReason());
            }
        }
    }

    public abstract void executionDay();
}
