
import java.util.ArrayList;

public class Game {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int clues;

    public Game(){
        inventory = new ArrayList<>();
        clues = 0;
    }

    public void Start(){
        System.out.println("Start playing");
    }
}
