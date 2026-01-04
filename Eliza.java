public class Eliza extends NPC{

    public Eliza(){
        super("Eliza", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("The atmosphere remains still and uneventful.");
        n1.addDialogue("Dialogue 1 (Introductionn)");
        n1.addDialogue("Dialogue 2 (Explains what happened)");
        n1.addDialogue("Dialogue 3 (Mention fighting in living room");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("The hours pass with a growing sense of unease.");
        n2.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("The silence feels deeper than before.");
        n3.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("The silence carries a sense of finality");
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
