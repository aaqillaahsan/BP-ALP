public class Juvia extends NPC{

    public Juvia(){
        super("Juvia", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("The night passes without incident.");
        n1.addDialogue("I'm Juvia… Arthur's wife.\n" + "Please understand, this house has never felt so unfamiliar to me.");
        n1.addDialogue("Arthur and I spoke after dinner. He was distant, distracted.\n" + "He said he needed time alone to think.");
        n1.addDialogue("I heard raised voices earlier—Arthur and Charles, I believe.\n" + "Their arguments were becoming unbearable.");
        n1.addDialogue("Whatever you're thinking… I loved my husband.\n" + "Disagreements don't equal murder.");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("Nothing obvious happens, yet the mood has shifted.");
        n2.addDialogue("The mood has changed. I can feel it.\n" + "Arthur kept secrets, even from me.");
        n2.addDialogue("He spent many nights in the library, rewriting documents.\n" + "Things he didn't want anyone to see.");
        n2.addDialogue("If you're searching for answers… you may enter the library.\n" + "Perhaps what he left behind will speak for him.");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("The night brings a noticeable change in tone.");
        n3.addDialogue("This no longer feels like a disappearance.\n" + "It feels like a tragedy waiting to be confirmed.");
        n3.addDialogue("Lucian was always calm with Arthur. Too calm.\n" + "They spoke in whispers when they argued.");
        n3.addDialogue("I keep replaying that night in my mind.\n" + "Wondering if I missed something important.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("This night feels more serious than all the others.");
        n4.addDialogue("I've prepared myself for the truth, whatever it is.\n" + "Denial only prolongs the pain.");
        n4.addDialogue("Whoever did this didn't need force.\n" + "Arthur would have listened to them.");
        n4.addDialogue("Please… bring this to an end.\n" + "For Arthur's sake.");
        nightDialogue.add(n4);

        //Req/Connected evidence
        requiredEvidence.add("Locked Mansion");
        requiredEvidence.add("Arthur's Journal");
        requiredEvidence.add("Bloody Drag Marks");
        requiredEvidence.add("Arthur's Bloodied Body");
        requiredEvidence.add("No Defensive Wound");
        requiredEvidence.add("Juvia's Letter");

        //default response
        denialReactions.add("I don't understand what you're suggesting.");

        //Evidence responses
        evidenceResponses.add(new EvidenceResponse("Locked Mansion","The doors being locked doesn't make me dangerous.\nI stayed in my rooms after Arthur left."));
        evidenceResponses.add(new EvidenceResponse("Arthur's Journal","Arthur wrote his fears when he was overwhelmed.\nThose words were not accusations against me."));
        evidenceResponses.add(new EvidenceResponse("Bloody Drag Marks","I never went near the basement.\nI couldn't bear to search for him down there."));
        evidenceResponses.add(new EvidenceResponse("Arthur's Bloodied Body","Seeing him like that nearly broke me.\nI loved my husband.\nI would never harm him."));
        evidenceResponses.add(new EvidenceResponse("No Defensive Wound","Arthur trusted many people.\nTrust does not mean guilt."));
        evidenceResponses.add(new EvidenceResponse("Juvia's Letter","That letter was private.\nIt speaks of distance, not murder."));

        //evidence reasons
        accuseReason.add(new EvidenceReason("Locked Mansion","The mansion was sealed.\nYou were inside with Arthur and cannot be excluded."));
        accuseReason.add(new EvidenceReason("Arthur's Journal","Arthur wrote about fear and secrecy.\nYou were closest to him during that time."));
        accuseReason.add(new EvidenceReason("Bloody Drag Marks","The body was deliberately hidden.\nYou knew the house well enough to avoid attention."));
        accuseReason.add(new EvidenceReason("Arthur's Bloodied Body","Arthur was killed quietly without resistance.\nSomeone close to him could have approached safely."));
        accuseReason.add(new EvidenceReason("No Defensive Wound","Arthur did not defend himself.\nHe may not have expected harm from his own wife."));
        accuseReason.add(new EvidenceReason("Arthur and Lucian's Argument","You were aware of the conflict between Arthur and Lucian.\nYou may have acted to prevent its consequences."));
        accuseReason.add(new EvidenceReason("Juvia's Letter","The letter suggests emotional distance and a desire to escape.\nThat creates a possible motive."));


        //Item Logic
        conditionItem.add(new ConditionItem(new LibraryPermission(), 2, 0, null, null, "The library is restricted, but I'll allow you in."));
        
        //Shocked dialog
        extraDialog.add(new extraDialog("Juvia gasps softly, covering her mouth.\nNo… no, no…\nShe looks away, voice trembling.\nHe said he just needed time.\nI should have gone after him."));

        setDesc();
    }

    @Override
    public void setDesc(){
        description = "Arthur's wife, struggling with grief and uncertainty. Emotionally strained yet composed, she knows her husband kept secrets even from those closest to him.";
    }

    @Override
    public void executionDay(){
        String [] dialog = {
            "The mansion feels hollow without Arthur. Juvia stands composed, hands clasped, grief carefully contained.",
            "I never imagined this house would become a courtroom.\n Or that love would be measured against suspicion.",
            "Arthur and I argued, yes.\n Marriage is not silence—it is disagreement followed by forgiveness.",
            "He was afraid near the end.\n Not of strangers.\n Of someone close enough to hurt him without raising his voice.",
            "You may think grief clouds judgment.\n But grief sharpens memory.\n It makes every quiet moment impossible to forget.",
            "Whoever did this didn't fight him.\n They spoke to him.\n And he listened.",
            "If you choose wrongly today,\n then Arthur will die a second time—\n buried beneath fear instead of truth."
        };
        for(String i: dialog){
            System.out.println(i);
            sc.nextLine();
        }
    }
}