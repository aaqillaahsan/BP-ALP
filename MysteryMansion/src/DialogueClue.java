public class DialogueClue {
    private String speaker;
    private String text;
    private boolean isReal;

    public DialogueClue(String speaker, String text, boolean isReal){
        this.speaker = speaker;
        this.text = text;
        this.isReal = isReal;
    }

    public void displayClue(){
        System.out.printf("%s said:\n", speaker);
        System.out.printf("\" %s \"\n", text);
    }

    public boolean isReal(){
        return isReal;
    }

    public String getSpeaker(){
        return speaker;
    }
}
