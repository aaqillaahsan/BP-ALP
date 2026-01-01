public class Lucian extends NPC{

    public Lucian(){
        super("Lucian", true);

        //Item Logic
        conditionItem.add(new ConditionItem(new BedroomKey(), 2, 0, null, null, "Dialog give key"));
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "description";
    }
}
