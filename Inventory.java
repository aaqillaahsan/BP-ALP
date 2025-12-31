
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory(){
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
        System.out.printf("[%s has been added to inventory.]\n", item.getName());
    }

    public boolean hasItem(String name){
        for(Item i: items){
            if(i.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    public void showInventory(){
        System.out.println("Inventory: ");
        int count = 1;
        for(Item i: items){
            System.out.printf("%d. %s\n", count++, i.getName());
        }
    }
}
