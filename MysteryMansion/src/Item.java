public class Item {
    private String name;
    private String description;
    private boolean isClue;
    private boolean isReal;
    private boolean KeyItem;

    public Item (String name, String description, boolean isClue, boolean isReal ,boolean KeyItem){
        this.name = name;
        this.description = description;
        this.isClue = isClue;
        this.isReal = isReal;
        this.KeyItem = KeyItem;
    }

    public String getName(){
        return name;
    }

    public String getDesc(){
        return name + ": " + description;
    }

    public boolean isClue(){
        return isClue;
    }

    public boolean isReal(){
        return isReal;
    }

    public boolean isKeyItem(){
        return KeyItem;
    }
}
