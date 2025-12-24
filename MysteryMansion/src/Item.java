public class Item {
    private String name;
    private String description;
    private boolean isClue;

    public Item (String name, String description, boolean isClue){
        this.name = name;
        this.description = description;
        this.isClue = isClue;
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
}
