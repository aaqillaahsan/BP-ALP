public class Basement extends Room{

    public Basement(){
        name = "Basement";
        requiredItem = "Basement Stair Key";
        keyFrom = "Perhaps I should ask Edmund about this";

        addItems(new BloodstainedWeight());

        addInteract(new DragMark());
    }

    @Override
    protected String roomDesc(){
        return "Poorly lit basement where you can barely see what's in front of you";
    }
}
