public class Clara extends NPC{

    public Clara(){
        super("Clara", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("The night feels calm on the surface, but something about this house feels deeply wrong.");
        n1.addDialogue("Oh… I didn’t expect anyone else wandering the kitchen this late.\n" + "I’m Clara. I’ve kept this house clean for years long before tonight’s mess.");
        n1.addDialogue("Mr. Arthur was in a dreadful mood after dinner. Voices were raised—nothing unusual for this family, sadly.\n" + "Then suddenly… he was gone. Doors locked, tempers flared, and now we’re all prisoners in this mansion.");
        n1.addDialogue("I heard shouting from the living room earlier. Arthur and Charles again, I think.\n" + "Charles stormed off afterward red faced, gripping something in his hand. A glass, maybe… or worse.");
        n1.addDialogue("That knife? It belongs in the kitchen, but I found it missing after dinner.\n" + "Charles was helping himself to wine earlier… wouldn’t surprise me if he grabbed it in a rage.");
        n1.addDialogue("Here take this key. It opens the cabinet beneath the counter.\n" + "If we’re trapped here, we may as well uncover the truth… even if it makes people uncomfortable.");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("As the house opens up, the atmosphere grows heavier and more unsettling.");
        n2.addDialogue("This house feels heavier tonight… like it’s holding its breath.\n" + "Arthur may have been difficult, but no one deserves to vanish like that.");
        n2.addDialogue("“Lately, Arthur barely slept. Always writing, locking papers away.\n" + "He feared someone close to him I could see it in his eyes.");
        n2.addDialogue("Lucian? He was always polite with the staff. Quiet. Observant. Too controlled, maybe… but that doesn’t make someone a murderer.");
        n2.addDialogue("Charles never hid his anger. Gambling debts, inheritance fights—he wanted Arthur gone.\n" + "If anyone acted in the heat of the moment… well, I’d look there first.");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("The garden and basement expose clear signs of murder and deliberate concealment, yet multiple suspects remain possible.");
        n3.addDialogue("The basement should have stayed locked. Some things are meant to stay buried.\n" + "When I was younger, Arthur warned me never to go down there at night.");
        n3.addDialogue("I heard footsteps after dinner that night. Not rushing careful.\n" + "Someone who knew the house well… someone who didn’t want to be heard.");
        n3.addDialogue("Lucian said he retired early, but… I saw a light pass the hallway mirror later.\n" + "I assumed it was my imagination. Now I’m not so sure.");
        n3.addDialogue("I should have spoken sooner. But when you work in a house like this,\n" + "you learn that silence keeps you employed.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("By the final night, everything has been uncovered, and nothing can be ignored anymore.");
        n4.addDialogue("I can’t stay silent anymore.\n" + "That night… I heard Arthur and Lucian arguing—furious, desperate whispers from the study.");
        n4.addDialogue("Arthur said Lucian was cut from the will. Said it was final.\n" + "Lucian begged him to reconsider… then his voice changed. Cold. Controlled.");
        n4.addDialogue("Something heavy struck wood. Once.\n" + "Then nothing. No shouting. No struggle.");
        n4.addDialogue("Arthur trusted Lucian. That’s why there were no defensive wounds.\n" + "You don’t raise your guard against your own son.");
        n4.addDialogue("Charles was loud. Obvious. Easy to blame.\n" + "But Lucian? He planned. He waited. And he lied.");
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
        description = "The mansion’s long-serving housekeeper. Quiet, observant, and more aware of family tensions than she lets on. Her access to private rooms makes her a silent witness to many secrets.";
    }

    @Override
    public void executionDay(){
        System.out.println("execution day");
    }
}
