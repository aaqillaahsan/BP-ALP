public class ConditionEClue {

    private EnviroClue clue;
    private int requiredNight;
    private String requiredItem;
    private boolean given = false;

    public ConditionEClue(EnviroClue clue, int requiredNight, String requiredItem){
        this.clue = clue;
        this.requiredNight = requiredNight;
        this.requiredItem = requiredItem;
    }

    public boolean canGive(int night, Inventory inventory){
        if(given) return false;
        if(night < requiredNight) return false;
        if(requiredItem != null && !inventory.hasItem(requiredItem)) return false;

        return true;
    }

    public EnviroClue give(){
        given = true;
        return clue;
    }
}
