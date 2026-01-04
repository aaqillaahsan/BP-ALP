public class DiningRoom extends Room{

    public DiningRoom(){
        name = "Dining Room";

        addItems(new BrokenWineGlass());
    }

    @Override
    protected String roomDesc(){
        return "A quiet and grand hall where once a family used to gather";
    }
}
