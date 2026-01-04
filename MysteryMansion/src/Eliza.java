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
        n2.addDialogue("I’m Eliza… Arthur’s daughter.\n" + "I usually keep to the library. It’s the only place that still feels calm.");
        n2.addDialogue("Father left the table upset after dinner.\n He said he needed time to think. He never came back.");
        n2.addDialogue("Arguments were becoming more frequent.\n Especially whenever inheritance was mentioned.");
        n2.addDialogue("Lucian never raised his voice.\n When he was angry, he became very quiet.");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("The silence feels deeper than before.");
        n3.addDialogue("The silence tonight feels heavier than before.\n" + "As if something is being deliberately hidden.");
        n3.addDialogue("Father trusted very few people.\n" + "Family was one of them… even when it hurt him.");
        n3.addDialogue("If someone harmed him,\n" + "it wasn’t a stranger and it wasn’t impulsive.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("The silence carries a sense of finality");
        n4.addDialogue("I don’t want to believe any of this.\n" + "But denial won’t bring Father back.");
        n4.addDialogue("Whoever did this didn’t need force.\n" + "Father would have listened to them.");
        n4.addDialogue("Please… when you make your accusation,\n" + "make sure it’s based on truth, not fear.");
        nightDialogue.add(n4);

        setDesc();
    }

    @Override
    public void setDesc(){
        description = "Arthur’s quiet and introspective daughter. She spends most of her time in the library, watching and listening more than speaking. Her insights are subtle but meaningful.";
    }

    @Override
    public void executionDay(){
        System.out.println("execution day");
    }
}
