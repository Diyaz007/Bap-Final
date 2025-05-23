import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 1500; i++) {
            Item.Size size = switch (random.nextInt(3)) {
                case 0 -> Item.Size.SMALL;
                case 1 -> Item.Size.MEDIUM;
                default -> Item.Size.LARGE;
            };
            int freq = 1 + random.nextInt(10);
            items.add(new Item("item" + i, size, freq));
        }

        OrderGenerator generator = new OrderGenerator(items);
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            orders.add(generator.generateRandomOrder());
        }

        Warehouse warehouse = new Warehouse();
        PlacementEngine engine = new PlacementEngine(warehouse);
        Picker picker = new Picker(warehouse);
        Simulator simulator = new Simulator(engine, picker);

        simulator.runSimulation(items, orders);
    }
}
