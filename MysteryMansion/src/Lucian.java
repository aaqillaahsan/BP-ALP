public class Lucian extends NPC{

    public Lucian(){
        super("Lucian", true);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("Nothing seems out of place during the early hours");
        n1.addDialogue("Lucian Ravenwood.\n" + "I understand this situation is… unsettling, but panic will not help anyone.");
        n1.addDialogue("Father excused himself after dinner.\n" + "He was upset, yes—but he often was. That doesn’t mean something terrible happened.");
        n1.addDialogue("If you’re referring to the argument, it was between Father and Uncle Charles.\n" + "I stayed out of it. Conflicts like that were beneath me.");
        n1.addDialogue("I retired early that night.\n" + "I prefer rest over pointless confrontation.");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("The night carries a strange but undefined feeling.");
        n2.addDialogue("The mood has shifted.\n" + "People are starting to imagine patterns that don’t exist.");
        n2.addDialogue("Inheritance rumors are exactly that—rumors.\n" + "Father changed his mind often.");
        n2.addDialogue("He spent a lot of time writing lately.\n" + "That doesn’t mean every page is a confession.");
        n2.addDialogue("I find it troubling how easily suspicion replaces logic.");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("There is a sense that things have shifted tonight.");
        n3.addDialogue("This investigation has gone far enough.\n" + "Now you’re talking about blood and basements.");
        n3.addDialogue("A paperweight? Drag marks?\n" + "You’re describing brute force—not calculation.");
        n3.addDialogue("Many people have access to the garden and lower levels.\n" + "Singling me out is convenient, not fair.");
        n3.addDialogue("Father was difficult… but that doesn’t mean I wished him dead.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("The atmosphere is thick and difficult to ignore.");
        n4.addDialogue("This night feels different.\n" + "You’ve already decided, haven’t you?");
        n4.addDialogue("You think you understand my family?\n" + "You think you understand him?");
        n4.addDialogue("I won’t deny that Father and I disagreed.\n But disagreement does not equal murder.");
        n4.addDialogue("Be careful not to confuse suspicion with certainty.\n Once an accusation is made, it cannot be undone.");
        nightDialogue.add(n4);

        //Req/Connected evidence
        requiredEvidence.add("Locked Mansion");
        requiredEvidence.add("Altered Will Draft");
        requiredEvidence.add("Arthur's Journal");
        requiredEvidence.add("Footprints near basement window");
        requiredEvidence.add("Blood-Stained Paperweight");
        requiredEvidence.add("Bloody Drag Marks");
        requiredEvidence.add("Arthur's Bloodied Body");
        requiredEvidence.add("No Defensive Wound");
        requiredEvidence.add("Arthur and Lucian's Argument");

        //Evidence responses
        evidenceResponses.add(new EvidenceResponse("Locked Mansion", "But that could mean anybody else in this mansion!"));
        evidenceResponses.add(new EvidenceResponse("Altered Will Draft", "So what? I dont care!"));
        evidenceResponses.add(new EvidenceResponse("Arthur's Journal", "Father wrote that? no, that's not true"));
        evidenceResponses.add(new EvidenceResponse("Footprints near basement window", "It's not just me you know who goes to the garden"));
        evidenceResponses.add(new EvidenceResponse("Blood-Stained Paperweight", "W-where did you even find that!?"));
        evidenceResponses.add(new EvidenceResponse("Bloody Drag Marks", "For all I know I'm NOT that strong"));
        evidenceResponses.add(new EvidenceResponse("Arthur's Bloodied Body", "There is no way i would do that to father"));
        evidenceResponses.add(new EvidenceResponse("No Defensive Wound", "Y-yeah, but it might be from Uncle. \nFor God's sake! it might even be from Eliza!"));
        evidenceResponses.add(new EvidenceResponse("Arthur and Lucian's Argument", ". . ."));

        //Default response
        denialReactions.add("That is just baseless accusation. That has nothing to do with me");

        //Evidence reasons
        accuseReason.add(new EvidenceReason("Locked Mansion", "There is no way an outsider can do this. So you are a suspect!"));
        accuseReason.add(new EvidenceReason("Altered Will Draft", "Your Father's will says that you were to be removed. Hence you act as a revenge"));
        accuseReason.add(new EvidenceReason("Arthur's Journal", "In this journal, your Father wrote blablablabla"));

        //Item Logic
        conditionItem.add(new ConditionItem(new BedroomKey(), 2, 0, null, null, "This key opens Arthur’s bedroom use it wisely."));
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "Arthur’s eldest son. Calm, intelligent, and carefully controlled, Lucian presents himself as rational and cooperative, rarely revealing his true emotions.";
    }

    @Override
    public void executionDay(){
        String [] dialog = {
            "Lucian stands perfectly still. No restraints are needed. His calm is deliberate—but strained.",
            "So… you’ve decided.",
            "I warned you about certainty.\n About mistaking patterns for truth.\n But here we are.",
            "Do you know how exhausting it is—\n watching everyone stumble toward the answer,\n convinced they’re being clever?",
            "Father loved control.\n He called it order.\n What he really meant was obedience.",
            "He was going to erase me.\n Not just from the will—\n from the family.\n From history.",
            "I didn’t plan to kill him.\n I planned to make him listen.\n Just once.",
            "But he never did.\n He turned his back.\n And in that moment… everything became very simple.",
            "No struggle.\n No fear.\n He trusted me.",
            "You were all so eager to blame the loud ones.\n The desperate ones.\n The ones who couldn’t hide what they felt.",
            "I only needed patience.\n Silence does the rest."
        };
        for(String i: dialog){
            System.out.println(i);
            sc.nextLine();
        }
    }
}