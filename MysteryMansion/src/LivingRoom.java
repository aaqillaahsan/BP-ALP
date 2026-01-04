public class LivingRoom extends Room{

    public LivingRoom(){
        name = "Living Room";

        addNPCS(new Charles());
        addNPCS(new Lucian());
    }

    @Override
    protected String roomDesc(){
        return "A room with welcoming feel. A contrast with what's happening in the mansion";
    }
}
