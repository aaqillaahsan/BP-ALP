public class FootPrint extends Interactable{

    public FootPrint(){
        name = "Footprints near basement window";

        conditionEClues.add(new ConditionEClue(new FootprintClue(), 3, null));
    }

    @Override
    protected String hasInteracted(){
        return "You've checked this footprints before.";
    }

    @Override
    protected String needsomething(){
        return "You need something";
    }
}
