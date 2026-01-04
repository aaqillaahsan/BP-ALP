public class Clara extends NPC{

    public Clara(){
        super("Clara", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("The night feels calm on the surface, but something about this house feels deeply wrong.");
        n1.addDialogue("Dialogue 1 (Introductionn)");
        n1.addDialogue("Dialogue 2 (Explains what happened)");
        n1.addDialogue("Dialogue 3 (Mention fighting in living room");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("As the house opens up, the atmosphere grows heavier and more unsettling.");
        n2.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("The garden and basement expose clear signs of murder and deliberate concealment, yet multiple suspects remain possible.");
        n3.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("By the final night, everything has been uncovered, and nothing can be ignored anymore.");
        n4.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n4);

        //Clues logic
        conditionClues.add(new ConditionClue(new DialogClue("Knife Findings", getName(), "", false), 1, 0, "Kitchen Knife", null));
        conditionClues.add(new ConditionClue(new DialogClue("Arthur and Lucian's Argument", getName(), "Dialogue (Argument of arthur and lucian)", true), 4, 0, null, "Arthur's Bloodied Body"));

        //Item logic
        conditionItem.add(new ConditionItem(new CabinetKey(), 1, 0, null, null, "Dialog (Give Key)"));
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
