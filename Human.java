public class Human extends Actor {
    
    Human(String name){
        super(name);
    }
    @Override
    String getName() {
        return super.name;
    }

    // ActorBehaviour 
    @Override
    public void setTookItem(boolean tookItem){
        super.tookItem = tookItem;
    }
    @Override
    public void setMadeOrder(boolean madeOrder){
        super.madeOrder = madeOrder;
    }
    @Override
    public boolean tookItem(){
        return super.tookItem;
    }
    @Override
    public boolean madeOrder(){
        return super.madeOrder;
    }
}
