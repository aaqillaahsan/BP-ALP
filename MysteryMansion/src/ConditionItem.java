public class ConditionItem {
    private Item item;
    private int requiredNight;
    private int requiredIndex;
    private String requiredItem;
    private String requiredClue;
    private boolean isgiven = false;
    private String giveDialog;

    public ConditionItem(Item item, int requiredNight, int requiredIndex, String requiredItem, String requiredClue, String giveDialog){
        this.item = item;
        this.requiredNight = requiredNight;
        this.requiredIndex = requiredIndex;
        this.requiredItem = requiredItem;
        this.requiredClue = requiredClue;
        this.giveDialog = giveDialog;
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

    public Item give(){
        isgiven = true;
        return item;
    }

    public String giveDialog(){
        return giveDialog;
    }

}
