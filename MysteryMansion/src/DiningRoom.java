public class DiningRoom extends Room{

    public DiningRoom(){
        name = "Dining Room";

        addItems(new BrokenWineGlass());
    }

    @Override
    protected String roomDesc(){
        return "Dining Room Desc";
    }
}
