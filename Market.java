import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehaviour{
    private List<Actor> actorsInMarket = new ArrayList<Actor>();
    private List<Actor> actorsInQueue = new ArrayList<Actor>();
    private StringBuilder stringBuilder = new StringBuilder();

    // MarketBehaviour
    @Override
    public void acceptToMarket(Actor actor) {
        actorsInMarket.add(actor);
        stringBuilder.append(actor.getName());
        stringBuilder.append(" has entered the market");
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
        takeInQueue(actor);
    }
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            if (actor.tookItem()){
                actorsInMarket.remove(actor);
                stringBuilder.append(actor.getName());
                stringBuilder.append(" has left the market");
                System.out.println(stringBuilder);
                stringBuilder.setLength(0);
            }
        }
    }
    @Override
    public void update() {
        releaseFromQueue();
        giveOrders();
        takeOrders();
    }

    // QueueBehaviour
    @Override
    public void takeInQueue(Actor actor) {
        actorsInQueue.add(actor);
        stringBuilder.append(actor.getName());
        stringBuilder.append(" has entered the queue");
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }
// actor > take item | give item < market
// actor > make order | take order < market
    @Override
    public void takeOrders() {
        for (Actor actor : actorsInQueue) {
            if (!actor.madeOrder()){
                actor.setMadeOrder(true);
                stringBuilder.append(actor.getName());
                stringBuilder.append(" has made an order");
                System.out.println(stringBuilder);
                stringBuilder.setLength(0);
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Actor actor : actorsInQueue) {
            if (actor.madeOrder()){
                actor.setTookItem(true);
                stringBuilder.append(actor.getName());
                stringBuilder.append(" has received their order");
                System.out.println(stringBuilder);
                stringBuilder.setLength(0);
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> actorsInQueueNew = new ArrayList<Actor>();
        List<Actor> actorsGo = new ArrayList<Actor>();
        for (Actor actor : actorsInQueue) {
            if (actor.tookItem()){
                stringBuilder.append(actor.getName());
                stringBuilder.append(" has left the queue");
                System.out.println(stringBuilder);
                stringBuilder.setLength(0);
                actorsGo.add(actor);
            }
            else{
                actorsInQueueNew.add(actor);
            }
        }
        releaseFromMarket(actorsGo);
        actorsInQueue = actorsInQueueNew;
    }
}
