
import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Item> items;
    private ArrayList<NPC> npcs;
    private ArrayList<Room> connections;

    private boolean locked;
    private String requiredItem;

    public Room (String name){
        this.name = name;   
        items = new ArrayList<>();
        npcs = new ArrayList<>();
        connections = new ArrayList<>();
        locked = true;
        requiredItem = null;
    }

    public String getName(){
        return name;
    }

    //Connection based
    public ArrayList<Room> getConnections(){
        return connections;
    }

    public void connectRoom(Room room){
        connections.add(room);
    }

    //Lock Mechanic
    public void unlock(){
        locked = false;
    }

    public boolean islocked(){
        return locked;
    }

    public void setRequiredItem(String itemName){
        requiredItem = itemName;
    }

    public String getRequiredItem(){
        return requiredItem;
    }

    //Others

    public ArrayList<Item> getItems(){
        return items;
    }

    public Item getItem(String name){
        for(Item i: items){
            if(i.getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return null;
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public ArrayList<NPC> getNPCS(){
        return npcs;
    }

    public void addItems(Item item){
        items.add(item);
    }

    public void addNPCS(NPC npc){
        npcs.add(npc);
    }

    public void describe(){
        System.out.printf("Room: %s\n", name);
        int count = 0;
        if(!npcs.isEmpty()){
            if(npcs.size() == 1){
                System.out.println("You see a person. . .");
            } else {
                System.out.printf("You see %d people. . .\n", npcs.size());
            }
            for(NPC i: npcs){
                System.out.printf("%d. %s, %s\n", count++, i.getName(), i.getDesc());
            }
        }

        
        if(!items.isEmpty()){
            if(items.size() == 1){
                System.out.println("You see an object somewhere in the room. . .");
            } else {
                System.out.println("You see a few objects in the room. . .");
            } 
            for(Item i: items){
                System.out.println("- " + i.getName());
            }
        }

        if(!connections.isEmpty()){
            System.out.printf("You see %d door(s) in the room\n", connections.size());
            System.out.println("Those doors lead to:");
            for(Room i: connections){
                if(i.getName().equalsIgnoreCase("Hidden Basement Room")){
                    continue;
                }
                System.out.printf("- %s\n", i.getName());
            }
        }
    }
}
