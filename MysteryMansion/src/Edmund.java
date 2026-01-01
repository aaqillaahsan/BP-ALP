public class Edmund extends NPC{

    public Edmund(){
        super("Edmund", false);

        //Clue Logic
        conditionClues.add(new ConditionClue(new DialogClue("Locked Mansion",getName(), "Dialog mansion locked", true), 1, 0, null,null));

        //Item Logic
        conditionItem.add(new ConditionItem(new GardenKey(), 3, 0, null, null, "Dialog give key"));
        conditionItem.add(new ConditionItem(new BasementKey(), 3, 0, null, null, "Dialog give key"));
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "description";
    }
}
