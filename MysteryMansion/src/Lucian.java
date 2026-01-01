public class Lucian extends NPC{

    public Lucian(){
        super("Lucian", true);

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
