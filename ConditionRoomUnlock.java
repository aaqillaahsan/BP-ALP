public class ConditionRoomUnlock {

    private Room Uroom;
    private String requiredItem;
    private int requiredNight;
    private boolean unlocked = false;
    private String unlockDialog;

    public ConditionRoomUnlock(Room Uroom, String requiredItem, int requiredNight, String unlockDialog){
        this.Uroom = Uroom;
        this.requiredItem = requiredItem;
        this.requiredNight = requiredNight;
        this.unlockDialog = unlockDialog;
    }

    public boolean canUnlock(int night, Inventory inventory){
        if(unlocked) return false;
        if(night < requiredNight) return false;
        if(requiredItem != null && !inventory.hasItem(requiredItem)) return false;

        return true;
    }

    public void unlock(){
        unlocked = true;
        Uroom.unlock();
    }

    public String getunlockDialog(){
        return unlockDialog;
    }
}
