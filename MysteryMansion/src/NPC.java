public class NPC {
    private String name;
    private String dialogue;
    private boolean isCulprit;
    private boolean giveClue;

    public NPC (String name, String dialogue, boolean isCulprit, boolean giveClue){
        this.name = name;
        this.dialogue = dialogue;
        this.isCulprit = isCulprit;
        this.giveClue = giveClue;
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
}
