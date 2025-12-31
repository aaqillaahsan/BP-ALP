public class Clara extends NPC{

    public Clara(){
        super("Clara", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("Default Dialogue (night 1)");
        n1.addDialogue("Dialogue 1 (Introductionn)");
        n1.addDialogue("Dialogue 2 (Explains what happened)");
        n1.addDialogue("Dialogue 3 (Mention fighting in living room");
        nightDialogue.add(n1);


        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("Default Dialogue (night 2");
        n2.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n2);

        //Clues logic
        conditionClues.add(new ConditionClue(new DialogClue("Knife Findings", getName(), "Dialogue (Knife)", false), 1, 0, "Kitchen Knife", null));
        conditionClues.add(new ConditionClue(new DialogClue("Arthur and Lucian's Argument", getName(), "Dialogue (Argument of arthur and lucian)", true), 4, 0, null, "Arthur's Bloodied Body"));

        //Item logic
        conditionItem.add(new ConditionItem(new CabinetKey(), 1, 0, null, null, "Dialog (Give Key)"));
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "description";
    }
}
