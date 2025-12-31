import java.util.ArrayList;

public abstract class Interactable {

    protected String name;
    protected boolean interacted = false;

    protected ArrayList<ConditionEClue> conditionEClues = new ArrayList<>();
    protected ArrayList<ConditionItem> conditionItem = new ArrayList<>();
    protected ArrayList<ConditionRoomUnlock> conditionUnlock = new ArrayList<>();

    public String getName(){
        return name;
    }

    public String interact(int night, Player player){
        if(interacted){
            return hasInteracted();
        }

        //Give clues
        for(ConditionEClue i: conditionEClues){
            if(i.canGive(night, player.getInventory())){
                EnviroClue clue = i.give();
                interacted = true;
                player.getJournal().addEClue(clue);
                return clue.display();
            }
        }

        //Give items
        for(ConditionItem i: conditionItem){
            if(i.canGive(night, -1, player.getInventory(), player.getJournal())){
                Item item = i.give();
                interacted = true;
                player.getInventory().addItem(item);
                return i.giveDialog();
            }
        }

        //Open places
        for(ConditionRoomUnlock i: conditionUnlock){
            if(i.canUnlock(night, player.getInventory())){
                interacted = true;
                i.unlock();
                return i.getunlockDialog();
            }
        }

        return needsomething(player);
    }

    protected abstract String hasInteracted();
    protected abstract String needsomething(Player player);
}
