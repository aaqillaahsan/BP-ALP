public class ConditionItem {
    private Item item;
    private int requiredNight;
    private int requiredIndex;
    private String requiredItem;
    private boolean isgiven = false;
    private String giveDialog;

    public ConditionItem(Item item, int requiredNight, int requiredIndex, String requiredItem, String giveDialog){
        this.item = item;
        this.requiredNight = requiredNight;
        this.requiredIndex = requiredIndex;
        this.requiredItem = requiredItem;
        this.giveDialog = giveDialog;
    }

    public boolean canGive(int night, int index, Inventory inventory){
        if(isgiven)return false;
        if(night < requiredNight) return false;
        if(index < requiredIndex) return false;

        if(requiredItem != null && !inventory.hasItem(requiredItem)) return false;

        return true;
    }

    public Item give(){
        isgiven = true;
        return item;
    }

    public String giveDialog(){
        return giveDialog;
    }

}
