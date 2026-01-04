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
        n3.addDialogue("Name’s Thomas. I take care of the grounds and the outer parts of the estate.\n" + "Didn’t expect to be questioned like this.");
        n3.addDialogue("I was outside most of the evening.\n" + "Gardens don’t tend themselves, even at night.");
        n3.addDialogue("Yeah, I’ve got tools. Shovels, crowbars… comes with the job.\n" + "Doesn’t mean I used them on a person.");
        n3.addDialogue("You might need this key for the garden shed.\n" + "Everything I own is in there.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("Everything feels more intense as the night unfolds.");
        n4.addDialogue("Things have turned serious.\n" + "If there’s something hidden, it won’t stay that way much longer.");
        n4.addDialogue("I noticed footprints near the basement window.\n" + "Too careful to be someone panicking.");
        n4.addDialogue("This hammer might help.\n" + "There’s a wall in the basement that always looked… wrong.");
        n4.addDialogue("I work with my hands, sure.\n" + "But whoever did this wasn’t acting on desperation—they had a plan.");
        nightDialogue.add(n4);

        //Item Logic
        conditionItem.add(new ConditionItem(new GardenShedKey(), 3, 0, null, null, "You might need this key for the Garden Shed"));
        conditionItem.add(new ConditionItem(new Hammer(), 4, 0, null, "Slightly Cracked Wall", "Dialog give hammer"));
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "The mansion’s groundskeeper, accustomed to working in isolation. Practical and guarded, he has access to tools and hidden areas, making him an uneasy presence in the investigation.";
    }

    @Override
    public void executionDay(){
        System.out.println("execution day");
    }
}
