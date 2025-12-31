public class KitchenCabinet extends Interactable{

    public KitchenCabinet(){
        name = "Kitchen Cabinet";
        
        conditionItem.add(new ConditionItem(new Knife(), 1, -1, "Cabinet Key", null, "You opened the cabinet and found a Knife in it. You should probably ask the Housekeeper about it."));
    }

    @Override
    protected String hasInteracted(){
        return "You've checked the Cabinet before";
    }

    @Override
    protected String needsomething(Player player){
        return "The cabinet is locked. Perhaps you should ask the Housekeeper";
    }

}
