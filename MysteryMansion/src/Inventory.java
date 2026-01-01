
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private ArrayList<Item> items;
    private final Scanner sc = new Scanner(System.in);

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
        String command = "";
        while(!command.equalsIgnoreCase("EXIT")){
            System.out.println("\nInventory: ");
            int count = 1;
            for(Item i: items){
                System.out.printf("%d. %s\n", count++, i.getName());
            }
            System.out.println("~ INSPECT (entry number)");
            System.out.println("~ EXIT");
            System.out.print("> ");
            try {
                command = sc.nextLine();
                command = command.toUpperCase();
            } catch (Exception e) {
                System.out.println("Invalid Input");
                System.out.println();
            }
            if(command.startsWith("INSPECT ")){
                count = 1;
                int entry = 0;
                try {
                    entry = Integer.parseInt(command.substring(8));
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number");
                    continue;
                }
                
                if(entry > items.size() || entry < 1){
                    System.out.println("Please enter a valid entry");
                    continue;
                }
                for(Item i: items){
                    if(entry == count){
                        System.out.println(i.getDesc());
                        break;
                    }
                    count++;
                }
            } else if(command.equalsIgnoreCase("EXIT")){
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public void evidenceDisplay(){
        int count = 1;
        for(Item i: items){
            if(i.isClue)
            System.out.printf("%d. %s\n", count++, i.getName());
        }
    }
}
