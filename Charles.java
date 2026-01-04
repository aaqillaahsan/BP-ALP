public class Charles extends NPC{

    public Charles(){
        super("Charles", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("The house rests quietly as the night starts.");
        n1.addDialogue("Dialogue 1 (Introductionn)");
        n1.addDialogue("Dialogue 2 (Explains what happened)");
        n1.addDialogue("Dialogue 3 (Mention fighting in living room");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("There is a noticeable change in the air this night.");
        n2.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("This night carries a weight the others did not.");
        n3.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("The house seems to hold its breath tonight.");
        n4.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n4);

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
