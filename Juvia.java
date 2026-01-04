public class Juvia extends NPC{

    public Juvia(){
        super("Juvia", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("The night passes without incident.");
        n1.addDialogue("Dialogue 1 (Introductionn)");
        n1.addDialogue("Dialogue 2 (Explains what happened)");
        n1.addDialogue("Dialogue 3 (Mention fighting in living room");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("Nothing obvious happens, yet the mood has shifted.");
        n2.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("The night brings a noticeable change in tone.");
        n3.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("This night feels more serious than all the others.");
        n4.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n4);

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
