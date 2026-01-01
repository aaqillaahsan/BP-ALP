public class Wounds extends Interactable{

    public Wounds(){
        name = "Check wounds";

        conditionEClues.add(new ConditionEClue(new NoDef(), 4, null));
    }

    @Override
    protected String hasInteracted(){
        return "You've had enough of his unsightly body. You feel repulsed to check again.";
    }

    @Override
    protected String needsomething(Player player){
        return "You need something.";
    }
}
