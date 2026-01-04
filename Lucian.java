public class Lucian extends NPC{

    public Lucian(){
        super("Lucian", true);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("Nothing seems out of place during the early hours");
        n1.addDialogue("Dialogue 1 (Introductionn)");
        n1.addDialogue("Dialogue 2 (Explains what happened)");
        n1.addDialogue("Dialogue 3 (Mention fighting in living room");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("The night carries a strange but undefined feeling.");
        n2.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("There is a sense that things have shifted tonight.");
        n3.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("The atmosphere is thick and difficult to ignore.");
        n4.addDialogue("Dialogue 1 ()");
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
        accuseReason.add(new EvidenceReason("Footprints near basement window", "The footprints matched your description, so you are a suspect!"));
        accuseReason.add(new EvidenceReason("Blood-Stained Paperweight", "This is the weapon found in the basement. It used to belong in Arthur's Bedroom where you have the key to"));
        accuseReason.add(new EvidenceReason("Bloody Drag Marks", "You dragged his body to wherever you hid him in the basement"));
        accuseReason.add(new EvidenceReason("Arthur's Bloodied Body", "His body was found bloodied hidden in the basement. You did this! "));
        accuseReason.add(new EvidenceReason(" No Defensive Wound", "His wound signify no resistance. Which means you are a suspect"));
        accuseReason.add(new EvidenceReason("Arthur and Lucian's Argument", "The arguments signify your motive of why you might be doing this to Arthur"));

        //Item Logic
        conditionItem.add(new ConditionItem(new BedroomKey(), 2, 0, null, null, "Dialog give key"));
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
