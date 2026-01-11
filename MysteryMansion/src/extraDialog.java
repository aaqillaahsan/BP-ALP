public class extraDialog {
    private String text;
    protected String reqItem = "Arthur's Bloodied Body";

    public extraDialog(String text){
        this.text = text;
    }

    public boolean checkBody(Journal journal){
        return journal.hasClue(reqItem);
    }

    public String getText(){
        return text;
    }
}
