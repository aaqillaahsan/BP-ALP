public class HiddenRoom extends Room{

    public HiddenRoom(){
        name = "Hidden Basement Room";
        
        addInteract(new ArthurBody());
        addInteract(new Wounds());
    }

    @Override
    protected String roomDesc(){
        return "Hiddenroom desc";
    }
}
