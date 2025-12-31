public class LivingRoom extends Room{

    public LivingRoom(){
        name = "Living Room";

        addNPCS(new Charles());
        addNPCS(new Lucian());
    }

    @Override
    protected String roomDesc(){
        return "Living Room Desc";
    }
}
