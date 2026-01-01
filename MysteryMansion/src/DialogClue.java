public class DialogClue {
    private String name;
    private String speaker;
    private String text;
    private boolean isReal;

    public DialogClue(String name, String speaker, String text, boolean isReal){
        this.name = name;
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

    public String getText(){
        return text;
    }

    public String getName(){
        return name;
    }
}
