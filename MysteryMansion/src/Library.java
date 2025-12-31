public class Library extends Room{

    public Library(){
        name = "Library";
        requiredItem = "Library Permission";

        addNPCS(new Eliza());

        addItems(new GamblingLedger());
        addItems(new WillDraft());
    }

    @Override
    protected String roomDesc(){
        return "Library Desc";
    }
}
