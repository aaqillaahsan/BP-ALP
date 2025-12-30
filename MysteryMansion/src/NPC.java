public class NPC {
    private String name;
    private String desciption;
    private String dialogue;
    private DialogueClue dialogueClue;
    private boolean isCulprit;

    public NPC (String name, String dialogue, boolean isCulprit, DialogueClue dialogueClue){
        this.name = name;
        this.dialogue = dialogue;
        this.isCulprit = isCulprit;
        this.dialogueClue = dialogueClue;
    }

    public String getName(){
        return name;
    }
    
    public String Talk(){
        return dialogue;
    }

    public boolean getCulprit(){
        return isCulprit;
    }

    public DialogueClue giveClue(){
        return dialogueClue;
    }

    public String getDesc(){
        return desciption;
    }
}
