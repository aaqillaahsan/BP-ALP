public class MainHall extends Room{

    public MainHall(){
        name = "Main Hall";

        addNPCS(new Edmund());
        addNPCS(new Juvia());
    }

    @Override
    protected String roomDesc(){
        return "Main Hall Description";
    }
}