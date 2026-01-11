public class Charles extends NPC{

    public Charles(){
        super("Charles", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("The house rests quietly as the night starts.");
        n1.addDialogue("So… everyone's looking at me now, aren't they?\n If this is about Arthur disappearing, I'm just as shocked as the rest of you.");
        n1.addDialogue("Yes, we argued. I won't deny that.\n Arthur always thought he owned this house and everyone in it.");
        n1.addDialogue("We raised our voices in the living room.\n But arguing doesn't make someone a murderer. If it did, none of us would be standing here.");
        n1.addDialogue("Don't ask me about knives, broken glasses, or rumors.\n I left after the argument. Alive. Angry. That's all.");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("There is a noticeable change in the air this night.");
        n2.addDialogue("This house feels tighter tonight.\n Every step I take, someone's watching.");
        n2.addDialogue("Yes, I have debts. Serious ones.\n Arthur knew—and he enjoyed reminding me of them.");
        n2.addDialogue("I was furious that night. I won't lie.\n But I didn't touch him. If I wanted him dead, I wouldn't be hiding behind excuses.");
        n2.addDialogue("Lucian? He's always calm.\n I've never trusted people who never lose control.");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("Default Dialogue (night 3)");
        n3.addDialogue("This has gone too far.\n" + "Blood, the basement… this isn't a crime of rage anymore.");
        n3.addDialogue("A blunt weapon? Drag marks? That's not me.\n" + "I left empty-handed and furious not calculated.");
        n3.addDialogue("I drank alone after the argument. Stupid, maybe.\n" + "But I never went back to Arthur. Not once.");
        n3.addDialogue("If you're really following the evidence…\n" + "you'll see my anger was too obvious for something this careful.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("Default Dialogue (night 4)");
        n4.addDialogue("I understand now.\n" + "I was the perfect distraction loud, reckless, easy to blame.");
        n4.addDialogue("Arthur trusted me with nothing.\n" + "He wouldn't have dropped his guard around me.");
        n4.addDialogue("Lucian always knew when to stay quiet.\n" + "When to smile. And when to lie.");
        n4.addDialogue("If my reputation helps you find the truth, so be it.\n" + "Just don't accuse the wrong man.");
        nightDialogue.add(n4);

        //Req/Connected evidence
        requiredEvidence.add("Locked Mansion");
        requiredEvidence.add("Charles's Gambling Ledger");
        requiredEvidence.add("Arthur's Journal");
        requiredEvidence.add("Footprints near basement window");
        requiredEvidence.add("Kitchen Knife");
        requiredEvidence.add("Bloody Drag Marks");
        requiredEvidence.add("Arthur's Bloodied Body");
        requiredEvidence.add("No Defensive Wound");
        requiredEvidence.add("Knife Findings");

        //Evidence responses
        evidenceResponses.add(new EvidenceResponse("Locked Mansion","That only proves one thing—none of us could leave.\nIf Arthur died here, the killer was already inside.\nSame as me. Same as everyone."));
        evidenceResponses.add(new EvidenceResponse("Charles's Gambling Ledger","I won't deny the debts.\nArthur loved holding them over my head.\nBut owing money doesn't turn a man into a calculated murderer."));
        evidenceResponses.add(new EvidenceResponse("Arthur's Journal","Read what he actually wrote.\nHe was worried—paranoid, even—but not about me.\nYou don't write about fear when you're planning to confront someone loud."));
        evidenceResponses.add(new EvidenceResponse("Footprints near basement window","Basement footprints?\nI never went near the basement that night."));
        evidenceResponses.add(new EvidenceResponse("Kitchen Knife","I picked up a knife earlier in the evening—everyone saw that.\nBut if Arthur died by a blade, you'd have found stab wounds.\nDid you?"));
        evidenceResponses.add(new EvidenceResponse("Bloody Drag Marks","Dragging a body means the victim was already dead—or unconscious.\nThat takes time.\nI stormed out angry. I didn't stay to rearrange a crime scene."));
        evidenceResponses.add(new EvidenceResponse("Arthur's Bloodied Body","That wasn't a fight that got out of hand.\nThat was someone making sure Arthur wouldn't wake up.\nThat's not rage—that's resolve."));
        evidenceResponses.add(new EvidenceResponse("No Defensive Wound","Arthur didn't defend himself because he didn't expect to need to.\nHe trusted whoever stood in front of him.\nI was never someone he trusted."));
        evidenceResponses.add(new EvidenceResponse("Knife Findings","You believed Clara when she said I used that knife for something?\nShe's a servant—of course, she'd want to point fingers away from the family.\nI didn't even use it to threaten him."));

        //Default response
        denialReactions.add("That is just baseless accusation. That has nothing to do with me");

        //Evidence reasons
        accuseReason.add(new EvidenceReason("Locked Mansion","The mansion was locked from the inside.\nYou were trapped here with Arthur when he disappeared."));
        accuseReason.add(new EvidenceReason("Charles's Gambling Ledger","Your heavy debts give you a financial motive.\nArthur knew about them and used them against you."));
        accuseReason.add(new EvidenceReason("Arthur's Journal","Arthur wrote about frequent arguments with you and his growing frustration.\nThat tension gives you a reason to act out in anger."));
        accuseReason.add(new EvidenceReason("Footprints near basement window","Footprints leading toward the basement suggest someone moved after the argument.\nYou had time and access that night."));
        accuseReason.add(new EvidenceReason("Kitchen Knife","You were seen handling the kitchen knife earlier that evening.\nThat puts a potential weapon in your hands."));
        accuseReason.add(new EvidenceReason("Bloody Drag Marks","The drag marks show the body was moved after death."));
        accuseReason.add(new EvidenceReason("Arthur's Bloodied Body","Arthur was killed with force shortly after dinner.\nYour argument places you closest to the time of death."));
        accuseReason.add(new EvidenceReason("No Defensive Wound","Arthur showed no signs of defending himself.\nHe may not have expected violence from you."));
        accuseReason.add(new EvidenceReason("Knife Findings","The knife findings reinforce suspicion from earlier that night.\nYour temper made the threat believable."));

        //Shocked dialog
        extraDialog.add(new extraDialog("Damn… Arthur.\nHe runs a hand through his hair, shaking.\nI was angry—but not this.\nThis is wrong.\nThis is all wrong."));
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "Arthur's hot-tempered brother. Burdened by debt and known for loud arguments, he appears suspicious at first glance, but his emotions are worn openly rather than hidden.";
    }

    @Override
    public void executionDay(){
        String [] dialog = {
            "The mansion is silent in a way it has never been before. No doors creak. No one argues. All eyes turn toward Charles.",
            "So this is how it ends.\n Funny… all that noise I made, all those fights—and it still ends quietly.",
            "You know, Arthur always said I'd be the death of him.\n Guess he was wrong about that too.",
            "I won't pretend I was a good brother.\n I was angry. I was drowning in debt. I hated him some days.\n But hatred isn't the same as murder.",
            "If you're doing this because it looks right—\n because I was loud, reckless, easy—\n then congratulations.\n I played my part perfectly.",
            "The real killer didn't shout.\n Didn't throw glasses or slam doors.\n He waited until Arthur trusted him enough to turn his back.",
            "That's the difference between rage and intent.\n One leaves bruises.\n The other leaves bodies.",
            "If I die today, remember this—\n you didn't punish the angriest man in the room.\n You punished the most obvious one.",
        };
        for(String i: dialog){
            System.out.println(i);
            sc.nextLine();
        }
    }
}
