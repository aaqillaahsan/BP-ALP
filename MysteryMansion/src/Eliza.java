public class Eliza extends NPC{

    public Eliza(){
        super("Eliza", false);
        setDesc();
    }

    @Override
    public void setDesc(){
        description = "description";
    }

    @Override
    public void executionDay(){
        System.out.println("execution day");
    }
}
