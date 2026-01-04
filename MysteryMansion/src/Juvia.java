public class Juvia extends NPC{

    public Juvia(){
        super("Juvia", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("The night passes without incident.");
        n1.addDialogue("I’m Juvia… Arthur’s wife.\n" + "Please understand, this house has never felt so unfamiliar to me.");
        n1.addDialogue("Arthur and I spoke after dinner. He was distant, distracted.\n" + "He said he needed time alone to think.");
        n1.addDialogue("I heard raised voices earlier—Arthur and Charles, I believe.\n" + "Their arguments were becoming unbearable.");
        n1.addDialogue("Whatever you’re thinking… I loved my husband.\n" + "Disagreements don’t equal murder.");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("Nothing obvious happens, yet the mood has shifted.");
        n2.addDialogue("The mood has changed. I can feel it.\n" + "Arthur kept secrets, even from me.");
        n2.addDialogue("He spent many nights in the library, rewriting documents.\n" + "Things he didn’t want anyone to see.");
        n2.addDialogue("If you’re searching for answers… you may enter the library.\n" + "Perhaps what he left behind will speak for him.");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("The night brings a noticeable change in tone.");
        n3.addDialogue("This no longer feels like a disappearance.\n" + "It feels like a tragedy waiting to be confirmed.");
        n3.addDialogue("Lucian was always calm with Arthur. Too calm.\n" + "They spoke in whispers when they argued.");
        n3.addDialogue("I keep replaying that night in my mind.\n" + "Wondering if I missed something important.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("This night feels more serious than all the others.");
        n4.addDialogue("I’ve prepared myself for the truth, whatever it is.\n" + "Denial only prolongs the pain.");
        n4.addDialogue("Whoever did this didn’t need force.\n" + "Arthur would have listened to them.");
        n4.addDialogue("Please… bring this to an end.\n" + "For Arthur’s sake.");
        nightDialogue.add(n4);

        //Item Logic
        conditionItem.add(new ConditionItem(new LibraryPermission(), 2, 0, null, null, "The library is restricted, but I’ll allow you in."));
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "Arthur’s wife, struggling with grief and uncertainty. Emotionally strained yet composed, she knows her husband kept secrets even from those closest to him.";
    }

    @Override
    public void executionDay(){
        System.out.println("execution day");
    }
}
