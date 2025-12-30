public class ConditionClue {

    private DialogClue clue;
    private int requiredNight;
    private int requiredIndex;
    private String requiredItem;
    private boolean isgiven = false;

    public ConditionClue(DialogClue clue, int requiredNight, int requiredIndex, String requiredItem) {
        this.clue = clue;
        this.requiredNight = requiredNight;
        this.requiredIndex = requiredIndex;
        this.requiredItem = requiredItem;
    }

    public boolean canGive(int night, int index, Inventory inventory){
        if(isgiven)return false;
        if(night != requiredNight) return false;
        if(index != requiredIndex) return false;

        if(requiredItem != null && !inventory.hasItem(requiredItem)) return false;

        return true;
    }

    public DialogClue giveClue(){
        isgiven = true;
        return clue;
    }
}
