public abstract class Item {
    protected  String name;
    protected  String description;
    protected  boolean isClue;
    protected  boolean isReal;
    protected  boolean KeyItem;

    public String getName(){
        return name;
    }

    public String getDesc(){
        return name + ":\n" + description;
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
