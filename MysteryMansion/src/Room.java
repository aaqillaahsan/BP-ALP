
import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private ArrayList<Item> items;
    private ArrayList<NPC> npcs;
    private ArrayList<Room> connections;

    public Room (String name, String description){
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        npcs = new ArrayList<>();
        connections = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String Describe(){
        return name + "\n" + description;
    }

    public ArrayList<Room> getConnections(){
        return connections;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public ArrayList<NPC> getNPCS(){
        return npcs;
    }
    
    public void connectRoom(Room room){
        connections.add(room);
    }

    public void addItems(Item item){
        items.add(item);
    }

    public void addNPCS(NPC npc){
        npcs.add(npc);
    }
}
