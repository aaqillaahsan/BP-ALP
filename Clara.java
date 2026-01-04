public class Clara extends NPC{

    public Clara(){
        super("Clara", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("Default Dialogue (night 1)");
        n1.addDialogue("Oh… I didn’t expect anyone else wandering the kitchen this late. I’m Clara. I’ve kept this house clean for yearslong before tonight’s mess.");
        n1.addDialogue("Mr. Arthur was in a dreadful mood after dinner. Voices were raised nothing unusual for this family, sadly.\n" + "Then suddenly… he was gone. Doors locked, tempers flared, and now we’re all prisoners in this mansion.");
        n1.addDialogue("I heard shouting from the living room earlier. Arthur and Charles again, I think. Charles stormed off afterward red faced, gripping something in his hand. A glass, maybe… or worse.");
        n1.addDialogue("That knife? It belongs in the kitchen, but I found it missing after dinner. Charles was helping himself to wine earlier… wouldn’t surprise me if he grabbed it in a rage.");
        n1.addDialogue("Here take this key. It opens the cabinet beneath the counter. If we’re trapped here, we may as well uncover the truth… even if it makes people uncomfortable.");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("Default Dialogue (night 2");
        n2.addDialogue("This house feels heavier tonight… like it’s holding its breath.\n" + "Arthur may have been difficult, but no one deserves to vanish like that.");
        n2.addDialogue("Mr. Arthur was in a dreadful mood after dinner. Voices were raised nothing unusual for this family, sadly.\n" + "Then suddenly… he was gone. Doors locked, tempers flared, and now we’re all prisoners in this mansion.");
        n2.addDialogue("I heard shouting from the living room earlier. Arthur and Charles again, I think. Charles stormed off afterward red faced, gripping something in his hand. A glass, maybe… or worse.");
        n2.addDialogue("That knife? It belongs in the kitchen, but I found it missing after dinner. Charles was helping himself to wine earlier… wouldn’t surprise me if he grabbed it in a rage.");
        n2.addDialogue("Here take this key. It opens the cabinet beneath the counter. If we’re trapped here, we may as well uncover the truth… even if it makes people uncomfortable.");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("Default Dialogue (night 3)");
        n3.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("Default Dialogue (night 4)");
        n4.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n4);

        //Clues logic
        conditionClues.add(new ConditionClue(new DialogClue("Knife Findings", getName(), "Last night Charles use this knife for something", false), 1, 0, "Kitchen Knife", null));
        conditionClues.add(new ConditionClue(new DialogClue("Arthur and Lucian's Argument", getName(), "I accidentally overheard Arthur and Lucia in the middle of a heated argument. The tension in their voices made it impossible to ignore how serious the situation was.", true), 4, 0, null, "Arthur's Bloodied Body"));

        //Item logic
        conditionItem.add(new ConditionItem(new CabinetKey(), 1, 0, null, null, "Take this key to open the cabinet"));
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
