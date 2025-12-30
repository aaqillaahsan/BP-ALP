public class Clara extends NPC{
    private boolean giveKey;

    public Clara(){
        super("Clara", false);
        giveKey = false;

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("Default Dialogue (night 1)");
        n1.addDialogue("Dialogue 1 (Introducction)");
        n1.addDialogue("Dialogue 2 (Explains what happened)");
        n1.addDialogue("Dialogue 3 (Mention fighting in living room");
        nightDialogue.add(n1);


        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("Default Dialogue (night 2");
        n2.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n2);


        conditionClues.add(new ConditionClue(new DialogClue(getName(), "Dialogue (Knife)", false), 0, 1, "Knife"));
        conditionClues.add(new ConditionClue(new DialogClue(getName(), "Dialogue (Argument of arthur and lucian", true), 3, 1, "Arthur's Body"));
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "description";
    }
}
