public class Edmund extends NPC{

    public Edmund(){
        super("Edmund", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("It feels like an ordinary night so far.");
        n1.addDialogue("Good evening. I am Edmund, head butler of Ravenwood Mansion.\n" + "I ensure order is maintained, even under… unusual circumstances.");
        n1.addDialogue("Shortly after dinner, Mr. Arthur was reported missing.\n" + "Per standing protocol, all external doors were secured to preserve safety.");
        n1.addDialogue("There was a verbal dispute in the living room earlier.\n" + "Raised voices are regrettably not uncommon in this household.");
        n1.addDialogue("To be clear: no one has entered or exited the mansion since the doors were sealed.\n" + "If Mr. Arthur has been harmed, it was done by someone inside.");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("The house seems quieter than usual tonight.");
        n2.addDialogue("The house is quieter tonight, but not calmer.\n" + "Silence often indicates restraint, not peace.");
        n2.addDialogue("I observe routines, not intentions.\n" + "Several residents retired later than they claim.");
        n2.addDialogue("It would be improper for me to speculate.\n" + "However, consistency or lack thereof has been noted.");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("Something feels different, even if it cannot be named.");
        n3.addDialogue("At this point, concealment is no longer possible.\n" + "The truth requires access.");
        n3.addDialogue("This key opens the garden door.\n" + "I had restricted the area earlier to prevent unnecessary disturbance.");
        n3.addDialogue("And this key grants access to the basement stairs.\n" + "It was sealed at Mr. Arthur’s explicit request.");
        n3.addDialogue("Proceed carefully.\n" + "The basement holds more than storage.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("There is a feeling that this night matters.");
        n4.addDialogue("This night will resolve matters.\n" + "Order cannot be restored until truth is acknowledged.");
        n4.addDialogue("Based on my observations, Mr. Arthur did not leave the house alive.\n" + "No staff or guest departed during the relevant window.");
        n4.addDialogue("Only those Mr. Arthur trusted had unrestricted movement.\n" + "That distinction now carries weight.");
        n4.addDialogue("When you are ready to speak your accusation,\n" + "ensure it is supported by fact—not assumption.");
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
        description = "The composed and professional head butler of Ravenwood Mansion. He values order and routine above all else and closely observes the movements of everyone in the house.";
    }

    @Override
    public void executionDay(){
        System.out.println("execution day");
    }
}
