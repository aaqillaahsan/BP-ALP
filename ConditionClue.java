public class ConditionClue {

    private DialogClue clue;
    private int requiredNight;
    private int requiredIndex;
    private String requiredItem;
    private String requiredClue;
    private boolean isgiven = false;

    public ConditionClue(DialogClue clue, int requiredNight, int requiredIndex, String requiredItem, String requiredClue) {
        this.clue = clue;
        this.requiredNight = requiredNight;
        this.requiredIndex = requiredIndex;
        this.requiredItem = requiredItem;
        this.requiredClue = requiredClue;
    }

    public boolean canGive(int night, int index, Inventory inventory, Journal journal){
        if(isgiven)return false;
        if(night < requiredNight) return false;
        if(index < requiredIndex) return false;

        if(requiredItem == null && requiredClue == null) return true;
        if(requiredItem != null && inventory.hasItem(requiredItem)) return true;
        if(requiredClue != null && journal.hasClue(requiredClue)) return true;

        return false;
    }

    public DialogClue giveClue(){
        isgiven = true;
        return clue;
    }
}
