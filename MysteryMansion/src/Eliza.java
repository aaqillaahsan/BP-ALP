public class Eliza extends NPC{

    public Eliza(){
        super("Eliza", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("The atmosphere remains still and uneventful.");
        n1.addDialogue("Dialogue 1 (Introductionn)");
        n1.addDialogue("Dialogue 2 (Explains what happened)");
        n1.addDialogue("Dialogue 3 (Mention fighting in living room");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("The hours pass with a growing sense of unease.");
        n2.addDialogue("I'm Eliza... Arthur's daughter.\n" + "I usually keep to the library. It's the only place that still feels calm.");
        n2.addDialogue("Father left the table upset after dinner.\n He said he needed time to think. He never came back.");
        n2.addDialogue("Arguments were becoming more frequent.\n Especially whenever inheritance was mentioned.");
        n2.addDialogue("Lucian never raised his voice.\n When he was angry, he became very quiet.");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("The silence feels deeper than before.");
        n3.addDialogue("The silence tonight feels heavier than before.\n" + "As if something is being deliberately hidden.");
        n3.addDialogue("Father trusted very few people.\n" + "Family was one of them... even when it hurt him.");
        n3.addDialogue("If someone harmed him,\n" + "it wasn't a stranger and it wasn't impulsive.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("The silence carries a sense of finality");
        n4.addDialogue("I don't want to believe any of this.\n" + "But denial won't bring Father back.");
        n4.addDialogue("Whoever did this didn't need force.\n" + "Father would have listened to them.");
        n4.addDialogue("Please... when you make your accusation,\n" + "make sure it's based on truth, not fear.");
        nightDialogue.add(n4);

        //req/Connected evidence
        requiredEvidence.add("Locked Mansion");
        requiredEvidence.add("Arthur's Journal");
        requiredEvidence.add("Bloody Drag Marks");
        requiredEvidence.add("Arthur's Bloodied Body");
        requiredEvidence.add("No Defensive Wound");

        //default response
        denialReactions.add("I don't understand what you're suggesting.");

        //Evidence responses
        evidenceResponses.add(new EvidenceResponse("Locked Mansion","The house being locked doesn't change who I am.\nI stayed in the library that night."));
        evidenceResponses.add(new EvidenceResponse("Arthur's Journal","Father wrote his fears down.\nThat doesn't mean I was the cause of them."));
        evidenceResponses.add(new EvidenceResponse("Bloody Drag Marks","I never went near the basement.\nI couldn't even bring myself to search for him."));
        evidenceResponses.add(new EvidenceResponse("Arthur's Bloodied Body","Seeing him like that was unbearable.\nI loved my father.\nI would never harm him."));
        evidenceResponses.add(new EvidenceResponse("No Defensive Wound","Father trusted many people.\nTrust alone doesn't make someone a murderer."));

        //evidence reason
        accuseReason.add(new EvidenceReason("Locked Mansion","The mansion was sealed.\nYou were inside with Arthur and cannot be ruled out."));
        accuseReason.add(new EvidenceReason("Arthur's Journal","Arthur wrote about fear and family tension.\nYou were aware of these conflicts."));
        accuseReason.add(new EvidenceReason("Bloody Drag Marks","The body was moved deliberately.\nYou know the mansion well enough to avoid attention."));
        accuseReason.add(new EvidenceReason("Arthur's Bloodied Body","Arthur was killed quietly.\nSomeone close to him could have approached without resistance."));
        accuseReason.add(new EvidenceReason("No Defensive Wound","Arthur did not defend himself.\nHe may not have expected harm from his own daughter."));

        //Shocked
        extraDialog.add(new extraDialog("Eliza goes very still.\n…Father.\nHer voice is barely audible.\nI knew something was wrong.\nHe trusted someone.\nThat's what hurts the most."));

        setDesc();
    }

    @Override
    public void setDesc(){
        description = "Arthur's quiet and introspective daughter. She spends most of her time in the library, watching and listening more than speaking. Her insights are subtle but meaningful.";
    }

    @Override
    public void executionDay(){
                String [] dialog = {
            "The library is silent. Dust hangs in the lamplight as Eliza stands near the shelves, fingers pressed into the spine of an unread book.",
            "I always thought the library was the safest place in the house.\n Quiet. Ordered. Away from arguments.",
            "Father believed words mattered.\n That if people spoke honestly, things could be fixed.\n I think that belief is what killed him.",
            "You look at me and see someone harmless.\n Someone who stayed away from the fighting.\n But listening teaches you things shouting never will.",
            "The person who hurt him didn't lose control.\n They didn't need to.\n Father would have listened until it was too late.",
            "He trusted family… even when they disappointed him.\n Especially then.",
            "If you condemn the wrong person today,\n you won't just lose the truth—\n you'll lose whatever Father believed this family could still be."
        };
        for(String i: dialog){
            System.out.println(i);
            sc.nextLine();
        }
    }
}