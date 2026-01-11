public class Thomas extends NPC{

    public Thomas(){
        super("Thomas", false);

        //Builds first night's dialogue
        NightDialogue n1 = new NightDialogue("Everything feels calm as the night begins.");
        n1.addDialogue("Dialogue 1 (Introductionn)");
        n1.addDialogue("Dialogue 2 (Explains what happened)");
        n1.addDialogue("Dialogue 3 (Mention fighting in living room");
        nightDialogue.add(n1);

        //Builds second night's dialogue
        NightDialogue n2 = new NightDialogue("As the night continues, the atmosphere subtly changes.");
        n2.addDialogue("Dialogue 1 ()");
        nightDialogue.add(n2);

        //Builds third night's dialogue
        NightDialogue n3 = new NightDialogue("The atmosphere grows heavier as the night progresses.");
        n3.addDialogue("Name's Thomas. I take care of the grounds and the outer parts of the estate.\n" + "Didn't expect to be questioned like this.");
        n3.addDialogue("I was outside most of the evening.\n" + "Gardens don't tend themselves, even at night.");
        n3.addDialogue("Yeah, I've got tools. Shovels, crowbars... comes with the job.\n" + "Doesn't mean I used them on a person.");
        n3.addDialogue("You might need this key for the garden shed.\n" + "Everything I own is in there.");
        nightDialogue.add(n3);

        //Builds fourth night's dialogue
        NightDialogue n4 = new NightDialogue("Everything feels more intense as the night unfolds.");
        n4.addDialogue("Things have turned serious.\n" + "If there's something hidden, it won't stay that way much longer.");
        n4.addDialogue("I noticed footprints near the basement window.\n" + "Too careful to be someone panicking.");
        n4.addDialogue("This hammer might help.\n" + "There's a wall in the basement that always looked... wrong.");
        n4.addDialogue("I work with my hands, sure.\n" + "But whoever did this wasn't acting on desperation - they had a plan.");
        nightDialogue.add(n4);

        //Req/Connected evidence
        requiredEvidence.add("Locked Mansion");
        requiredEvidence.add("Arthur's Journal");
        requiredEvidence.add("Footprints near basement window");
        requiredEvidence.add("Bloody Drag Marks");
        requiredEvidence.add("Arthur's Bloodied Body");
        requiredEvidence.add("Groundskeeper's Tools");

        //default response
        denialReactions.add("You think dirt on my hands means blood.\nYou're wrong.");

        //Evidence responses
        evidenceResponses.add(new EvidenceResponse("Locked Mansion","The house was locked, sure.\nBut I was outside most of the night, not roaming halls."));
        evidenceResponses.add(new EvidenceResponse("Arthur's Journal","Arthur wrote about fear, not me.\nI was just the man who kept the grounds in order."));
        evidenceResponses.add(new EvidenceResponse("Footprints near basement window","I noticed those prints because they weren't mine.\nToo careful.\nToo clean."));
        evidenceResponses.add(new EvidenceResponse("Bloody Drag Marks","Dragging a body isn't work.\nIt's something someone does when they don't want to be seen."));
        evidenceResponses.add(new EvidenceResponse("Arthur's Bloodied Body","That wasn't a fight.\nThat was someone making sure he stayed down."));
        evidenceResponses.add(new EvidenceResponse("Groundskeeper's Tools","I own tools because it's my job.\nOwning them doesn't mean I used them on Arthur."));

        //evidence reason
        accuseReason.add(new EvidenceReason("Locked Mansion","The mansion was sealed.\nYou were inside the grounds and could not be excluded."));
        accuseReason.add(new EvidenceReason("Arthur's Journal","Arthur wrote about growing fear.\nStaff with access could have been included in that fear."));
        accuseReason.add(new EvidenceReason("Footprints near basement window","The footprints lead from outside toward the basement.\nYou were working near that area."));
        accuseReason.add(new EvidenceReason("Bloody Drag Marks","The body was dragged deliberately.\nYou are accustomed to heavy physical labor."));
        accuseReason.add(new EvidenceReason("Arthur's Bloodied Body","Arthur was killed quietly.\nSomeone strong enough to overpower him could have done this."));
        accuseReason.add(new EvidenceReason("Groundskeeper's Tools","You had access to heavy tools capable of killing.\nThose tools give you opportunity."));


        //Item Logic
        conditionItem.add(new ConditionItem(new GardenShedKey(), 3, 0, null, null, "Take this key to open the garden shed"));
        conditionItem.add(new ConditionItem(new Hammer(), 4, 0, null, "Slightly Cracked Wall", "Oh, You find a cracked wall, this hammer might help you."));
        
        //Shocked dialog
        extraDialog.add(new extraDialog("Thomas clenches his jaw.\nSo that’s what was buried.\nHe looks away.\nThat wasn’t an accident.\nSomeone meant for him to stay down."));
        
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "The mansion's groundskeeper, accustomed to working in isolation. Practical and guarded, he has access to tools and hidden areas, making him an uneasy presence in the investigation.";
    }

    @Override
    public void executionDay(){
        String [] dialog = {
            "Dirt still stains Thomas's hands. He doesn't bother to wipe them clean.",
            "Funny thing about working outside.\n You get used to being blamed for whatever's dug up.",
            "Yeah, I've got tools.\n Heavy ones.\n But tools don't choose when to swing themselves.",
            "I was alone most of that night.\n Not hiding - working.\n There's a difference.",
            "You think murder looks like sweat and mud.\n Like panic.\n Like someone losing control.",
            "But what you found downstairs?\n That wasn't messy.\n That was careful.",
            "Arthur didn't fight back.\n Someone he trusted was standing right in front of him.",
            "If you're ending this on guesses,\n then you've already buried the truth."
        };
        for(String i: dialog){
            System.out.println(i);
            sc.nextLine();
        }
    }
}