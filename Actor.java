
public abstract class Actor implements ActorBehaviour{
    protected String name;
    protected boolean madeOrder;
    protected boolean tookItem;

    abstract String getName();

    Actor(String name){
        this.name = name;
    }
}