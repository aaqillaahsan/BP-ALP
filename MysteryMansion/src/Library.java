public class Library extends Room{

    public Library(){
        name = "Library";
        requiredItem = "Library Permission";
        keyFrom = "I should ask Juvia for permission.";

        addNPCS(new Eliza());

        addItems(new GamblingLedger());
        addItems(new WillDraft());
    }

    @Override
    protected String roomDesc(){
        return "Books can be seen from left to right. The smell of books is strong here. ";
    }
}
