public class Edmund extends NPC{

    public Edmund(){
        super("Edmund", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("It feels like an ordinary night so far.");
        n1.addDialogue("Good evening. I am Edmund, head butler of Ravenwood Mansion.\n" + "I ensure order is maintained, even under… unusual circumstances.");
        n1.addDialogue("Shortly after dinner, Mr. Arthur was reported missing.\n" + "Per standing protocol, all external doors were secured to preserve safety.");
        n1.addDialogue("There was a verbal dispute in the living room earlier.\n" + "Raised voices are regrettably not uncommon in this household.");
        n1.addDialogue("To be clear: no one has entered or exited the mansion since the doors were sealed.\n" + "If Mr. Arthur has been harmed, it was done by someone inside.");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("The house seems quieter than usual tonight.");
        n2.addDialogue("The house is quieter tonight, but not calmer.\n" + "Silence often indicates restraint, not peace.");
        n2.addDialogue("I observe routines, not intentions.\n" + "Several residents retired later than they claim.");
        n2.addDialogue("It would be improper for me to speculate.\n" + "However, consistency or lack thereof has been noted.");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("Something feels different, even if it cannot be named.");
        n3.addDialogue("At this point, concealment is no longer possible.\n" + "The truth requires access.");
        n3.addDialogue("This key opens the garden door.\n" + "I had restricted the area earlier to prevent unnecessary disturbance.");
        n3.addDialogue("And this key grants access to the basement stairs.\n" + "It was sealed at Mr. Arthur's explicit request.");
        n3.addDialogue("Proceed carefully.\n" + "The basement holds more than storage.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("There is a feeling that this night matters.");
        n4.addDialogue("This night will resolve matters.\n" + "Order cannot be restored until truth is acknowledged.");
        n4.addDialogue("Based on my observations, Mr. Arthur did not leave the house alive.\n" + "No staff or guest departed during the relevant window.");
        n4.addDialogue("Only those Mr. Arthur trusted had unrestricted movement.\n" + "That distinction now carries weight.");
        n4.addDialogue("When you are ready to speak your accusation,\n" + "ensure it is supported by fact—not assumption.");
        nightDialogue.add(n4);

        //Req/Connected evidence
        requiredEvidence.add("Locked Mansion");
        requiredEvidence.add("Arthur's Journal");
        requiredEvidence.add("Footprints near basement window");
        requiredEvidence.add("Bloody Drag Marks");
        requiredEvidence.add("Arthur's Bloodied Body");

        //default response
        denialReactions.add("I understand why suspicion falls on me.\nBut duty and guilt are not the same.");

        //Evidence responses
        evidenceResponses.add(new EvidenceResponse("Locked Mansion","The mansion was sealed to preserve safety and truth.\nI did not benefit from locking anyone inside."));
        evidenceResponses.add(new EvidenceResponse("Arthur's Journal","Mr. Arthur wrote many things in private.\nNone of them accuse me of harm."));
        evidenceResponses.add(new EvidenceResponse("Footprints near basement window","The garden and basement were accessed by multiple residents.\nObservation does not equal responsibility."));
        evidenceResponses.add(new EvidenceResponse("Bloody Drag Marks","Those marks indicate concealment, not service.\nI maintain the house—I do not defile it."));
        evidenceResponses.add(new EvidenceResponse("Arthur's Bloodied Body","The manner of death was personal.\nStaff do not receive that level of trust."));

        //Evidence reasons
        accuseReason.add(new EvidenceReason("Locked Mansion","You sealed the mansion and controlled all exits.\nThat gave you authority over the crime scene."));
        accuseReason.add(new EvidenceReason("Arthur's Journal","Arthur wrote about fear and secrecy.\nAs his closest staff member, you were privy to private matters."));
        accuseReason.add(new EvidenceReason("Footprints near basement window","You had routine access to the garden and basement.\nYou could move without drawing attention."));
        accuseReason.add(new EvidenceReason("Bloody Drag Marks","The body was moved deliberately through service paths.\nYou know the mansion's hidden routes."));
        accuseReason.add(new EvidenceReason("Arthur's Bloodied Body","Arthur was killed quietly without resistance.\nSomeone he trusted enough not to question could have done this."));


        //Clue Logic
        conditionClues.add(new ConditionClue(new DialogClue("Locked Mansion",getName(), "Ever since Arthur went missing, the mansion has been kept locked", true), 1, 0, null,null));

        //Item Logic
        conditionItem.add(new ConditionItem(new GardenKey(), 3, 0, null, null, "Take this key to open the garden"));
        conditionItem.add(new ConditionItem(new BasementKey(), 3, 0, null, null, "Take this key to open the basement"));
        
        //Shocked dialog
        extraDialog.add(new extraDialog("Edmund closes his eyes briefly.\nThen it is confirmed.\nHe straightens his posture.\nI regret that order failed him.\nThis house will not hide the truth."));

        setDesc();
    }

    @Override
    public void setDesc(){
        description = "The composed and professional head butler of Ravenwood Mansion. He values order and routine above all else and closely observes the movements of everyone in the house.";
    }

    @Override
    public void executionDay(){
        String [] dialog = {
            "The mansion stands perfectly orderly, as it always has. Edmund straightens his gloves, posture immaculate, even now.",
            "So. Disorder has finally reached its conclusion.",
            "I have served this family for decades.\n I have seen anger, greed, betrayal—and I have cleaned up after all of it.\n But I did not commit murder.",
            "You accuse me because I hold keys.\n Because I understand routines.\n Because I move unseen.\n These are tools of service—not guilt.",
            "I locked the mansion to preserve truth.\n Not to conceal it.\n A locked house does not create a killer—it reveals one.",
            "Mr. Arthur trusted structure.\n He trusted predictability.\n And above all, he trusted certain people without question.",
            "There were no signs of struggle.\n No desperation.\n That alone should have narrowed your focus.",
            "A man like Arthur does not lower his guard for staff.\n He does so for family."
        };
        for(String i: dialog){
            System.out.println(i);
            sc.nextLine();
        }
    }
}