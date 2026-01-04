public class Kitchen extends Room{

    public Kitchen(){
        name = "Kitchen";

        addNPCS(new Clara());

        addInteract(new KitchenCabinet());
    }

    @Override
    protected String roomDesc(){
        return "A surprisingly normal kitchen";
    }
}
