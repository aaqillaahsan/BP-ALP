
public class Bedroom extends Room{

    public Bedroom(){
        name = "Arthur's Bedroom";
        requiredItem = "Arthur's Bedroom Key";

        addItems(new JuviaLetter());
        addItems(new ArthurJournal());
    }

    @Override
    protected String roomDesc(){
        return "Bedroom Desc";
    }
}
