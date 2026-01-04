public class Edmund extends NPC{

    public Edmund(){
        super("Edmund", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("It feels like an ordinary night so far.");
        n1.addDialogue("Dialogue 1 (Introductionn)");
        n1.addDialogue("Dialogue 2 (Explains what happened)");
        n1.addDialogue("Dialogue 3 (Mention fighting in living room");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("The house seems quieter than usual tonight.");
        n2.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("Something feels different, even if it cannot be named.");
        n3.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("There is a feeling that this night matters.");
        n4.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n4);

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

    @Override
    public void executionDay(){
        System.out.println("execution day");
    }
}
