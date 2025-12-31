public class ArthurBody extends Interactable{

    public ArthurBody(){
        name = "Arthur's Body";

        conditionEClues.add(new ConditionEClue(new ArthurCon(), 4, null));
    }

    @Override
    protected String hasInteracted(){
        return "You've had enough of his unsightly body. You feel repulsed to check again.";
    }

    @Override
    protected String needsomething(){
        return "You need something.";
    }
}
