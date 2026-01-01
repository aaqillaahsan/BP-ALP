public class Player {
    private Room currentRoom;
    private Inventory inventory;
    private Journal journal;

    public Player(){
        inventory = new Inventory();
        journal = new Journal();
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Room room){
        currentRoom = room;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public Journal getJournal(){
        return journal;
    }

    public boolean hasEvidence(String name){
        if(inventory.hasItem(name)){
            return true;
        }
        if(journal.hasClue(name)){
            return true;
        }
        return false;
    }
}
