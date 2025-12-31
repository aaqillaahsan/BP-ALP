public class Thomas extends NPC{

    public Thomas(){
        super("Thomas", false);

        //Item Logic
        conditionItem.add(new ConditionItem(new GardenShedKey(), 3, 0, null, null, "Dialog give key"));
        conditionItem.add(new ConditionItem(new Hammer(), 4, 0, null, "Slightly Cracked Wall", "Dialog give hammer"));
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "description";
    }
}
