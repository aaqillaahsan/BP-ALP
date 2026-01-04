public class Garden extends Room{

    public Garden(){
        name = "Garden";
        requiredItem = "Garden Door Key";
        keyFrom = "Perhaps I should ask Edmund about this";

        addNPCS(new Thomas());

        addInteract(new GardenShed());
        addInteract(new FootPrint());
    }

    @Override
    protected String roomDesc(){
        return "A garden filled with greenery and flowers. It's apparent that it is maintained well.";
    }
}
