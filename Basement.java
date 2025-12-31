public class Basement extends Room{

    public Basement(){
        name = "Basement";
        requiredItem = "Basement Stair Key";

        addItems(new BloodstainedWeight());

        addInteract(new DragMark());
    }

    @Override
    protected String roomDesc(){
        return "Basement desc";
    }
}
