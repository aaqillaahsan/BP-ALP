public class Thomas extends NPC{

    public Thomas(){
        super("Thomas", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("Everything feels calm as the night begins.");
        n1.addDialogue("Dialogue 1 (Introductionn)");
        n1.addDialogue("Dialogue 2 (Explains what happened)");
        n1.addDialogue("Dialogue 3 (Mention fighting in living room");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("As the night continues, the atmosphere subtly changes.");
        n2.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("The atmosphere grows heavier as the night progresses.");
        n3.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("Everything feels more intense as the night unfolds.");
        n4.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n4);

        //Item Logic
        conditionItem.add(new ConditionItem(new GardenShedKey(), 3, 0, null, null, "You might need this key for the Garden Shed"));
        conditionItem.add(new ConditionItem(new Hammer(), 4, 0, null, "Slightly Cracked Wall", "Dialog give hammer"));
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
