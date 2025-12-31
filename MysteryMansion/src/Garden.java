public class Garden extends Room{

    public Garden(){
        name = "Garden";
        requiredItem = "Garden Door Key";

        addNPCS(new Thomas());

        addInteract(new GardenShed());
        addInteract(new FootPrint());
    }

    @Override
    protected String roomDesc(){
        return "Garden desc";
    }
}
