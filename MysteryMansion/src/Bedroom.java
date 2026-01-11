
public class Bedroom extends Room{

    public Bedroom(){
        name = "Arthur's Bedroom";
        requiredItem = "Arthur's Bedroom Key";
        keyFrom = "Lucian might have the key. I should ask him";

        addItems(new JuviaLetter());
        addItems(new ArthurJournal());
    }

    @Override
    protected String roomDesc(){
        return "A room full of folder stacked everywhere yet surprisingly tidy";
    }
}