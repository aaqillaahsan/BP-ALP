public class Juvia extends NPC{

    public Juvia(){
        super("Juvia", false);

        //Item Logic
        conditionItem.add(new ConditionItem(new LibraryPermission(), 2, 0, null, null, "Dialog give permission"));
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "description";
    }

    @Override
    public void executionDay(){
        System.out.println("execution day");
    }
}
