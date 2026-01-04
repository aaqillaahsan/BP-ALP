public class Charles extends NPC{

    public Charles(){
        super("Charles", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("The house rests quietly as the night starts.");
        n1.addDialogue("So… everyone’s looking at me now, aren’t they?\n If this is about Arthur disappearing, I’m just as shocked as the rest of you.");
        n1.addDialogue("Yes, we argued. I won’t deny that.\n Arthur always thought he owned this house and everyone in it.");
        n1.addDialogue("We raised our voices in the living room.\n But arguing doesn’t make someone a murderer. If it did, none of us would be standing here.");
        n1.addDialogue("Don’t ask me about knives, broken glasses, or rumors.\n I left after the argument. Alive. Angry. That’s all.");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("There is a noticeable change in the air this night.");
        n2.addDialogue("This house feels tighter tonight.\n Every step I take, someone’s watching.");
        n2.addDialogue("Yes, I have debts. Serious ones.\n Arthur knew—and he enjoyed reminding me of them.");
        n2.addDialogue("I was furious that night. I won’t lie.\n But I didn’t touch him. If I wanted him dead, I wouldn’t be hiding behind excuses.");
        n2.addDialogue("Lucian? He’s always calm.\n I’ve never trusted people who never lose control.");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("Default Dialogue (night 3)");
        n3.addDialogue("This has gone too far.\n" + "Blood, the basement… this isn’t a crime of rage anymore.");
        n3.addDialogue("A blunt weapon? Drag marks? That’s not me.\n" + "I left empty-handed and furious not calculated.");
        n3.addDialogue("I drank alone after the argument. Stupid, maybe.\n" + "But I never went back to Arthur. Not once.");
        n3.addDialogue("If you’re really following the evidence…\n" + "you’ll see my anger was too obvious for something this careful.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("Default Dialogue (night 4)");
        n4.addDialogue("I understand now.\n" + "I was the perfect distraction loud, reckless, easy to blame.");
        n4.addDialogue("Arthur trusted me with nothing.\n" + "He wouldn’t have dropped his guard around me.");
        n4.addDialogue("Lucian always knew when to stay quiet.\n" + "When to smile. And when to lie.");
        n4.addDialogue("If my reputation helps you find the truth, so be it.\n" + "Just don’t accuse the wrong man.");
        nightDialogue.add(n4);

        setDesc();
    }

    @Override
    public void setDesc(){
        description = "Arthur’s hot-tempered brother. Burdened by debt and known for loud arguments, he appears suspicious at first glance, but his emotions are worn openly rather than hidden.";
    }

    @Override
    public void executionDay(){
        System.out.println("execution day");
    }
}
