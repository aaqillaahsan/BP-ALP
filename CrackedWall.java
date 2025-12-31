public class CrackedWall extends Interactable{

    public CrackedWall(Room Uroom){
        name = "Slightly Cracked Wall.";

        conditionUnlock.add(new ConditionRoomUnlock(Uroom, "Hammer", 4, "The walls has been broken and flood out a foul stench."));
    }

    @Override
    protected String hasInteracted(){
        return "You've broken this wall down.";
    }

    @Override
    protected String needsomething(Player player){
        player.getJournal().addEClue(new CrackedWallClue());
        return "You need a tool to break this wall. Perhaps ask the Groundskeeper.";
    }
}
