
import java.util.ArrayList;

public abstract class Room {
    protected String name;
    protected ArrayList<Item> items = new ArrayList<>();
    protected ArrayList<NPC> npcs = new ArrayList<>();
    protected ArrayList<Room> connections = new ArrayList<>();
    protected ArrayList<Interactable> interactables = new ArrayList<>();

    protected boolean locked = true;
    protected String requiredItem = null;

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

    //Interactables
    public void addInteract(Interactable interactable){
        interactables.add(interactable);
    }

    public Interactable getInteract(String name){
        for(Interactable i: interactables){
            if(i.getName().equalsIgnoreCase(name)){
                return i;
            }
        }

        return null;
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

    protected abstract String roomDesc();

    public void describe(){
        System.out.printf("Room: %s\n", name);
        System.out.println(roomDesc());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        int count = 1;
        if(!npcs.isEmpty()){
            if(npcs.size() == 1){
                System.out.println("You see a person. . .");
            } else {
                System.out.printf("You see %d people. . .\n", npcs.size());
            }
            for(NPC i: npcs){
                System.out.printf("%d. %s, %s\n", count++, i.getName(), i.getDesc());
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

        if(!interactables.isEmpty()){
            if(interactables.size() == 1){
                System.out.println("You see something to interact with");
            } else {
                System.out.println("You see a few things to interact with");
            }
            for(Interactable i: interactables){
                System.out.println("- " + i.getName());
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}
