public class Program {
    private static Market market = new Market();
    public static void main(String[] args) {
        market.acceptToMarket(new Human("Alex"));
        market.acceptToMarket(new Human("Lexus"));
        market.acceptToMarket(new Human("Zach"));
        market.update();
        market.update();
        market.update();
        market.update();
        market.update();
    }
}
