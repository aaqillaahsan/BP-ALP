public class GardenShed extends Interactable{

    public GardenShed(){
        name = "Garden Shed";

        conditionItem.add(new ConditionItem(new GroundskeeperTool(), 3, -1, "Garden Shed Key", "You unlock the shed and find the Groundskeeper's Tool"));
    }

    @Override
    protected String hasInteracted(){
        return "You've checked the Garden Shed";
    }

    @Override
    protected String needsomething(){
        return "The shed is locked. Perhaps you should ask the Groundskeeper";
    }
}
