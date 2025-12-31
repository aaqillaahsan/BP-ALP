public class DragMark extends Interactable{

    public DragMark(){
        name = "Bloody Drag Marks.";

        conditionEClues.add(new ConditionEClue(new BloodyMark(), 3, null));
    }

    @Override
    protected String hasInteracted(){
        return "You've checked those marks before.";
    }

    @Override
    protected String needsomething(Player player){
        return "You need something";
    }
}
