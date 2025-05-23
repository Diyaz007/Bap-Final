import java.util.List;

public class Simulator {
    private PlacementEngine engine;
    private Picker picker;

    public Simulator(PlacementEngine engine, Picker picker) {
        this.engine = engine;
        this.picker = picker;
    }

    public void runSimulation(List<Item> items, List<Order> orders) {
        System.out.println("▶ Старт симуляции: жадное размещение");

        Warehouse warehouse = new Warehouse();
        engine = new PlacementEngine(warehouse);
        picker = new Picker(warehouse);

        engine.greedyPlacement(items);

        double totalTime = 0;
        for (Order order : orders) {
            totalTime += picker.collectOrder(order);
        }
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                for (int z = 0; z < 10; z++) {
                    System.out.println(warehouse.getCell(x,y,z).toString());
                }
            }
        }

        System.out.println("📦 Обработано заказов: " + orders.size());
        System.out.printf("⏱ Общее время сбора: %,.7f сек\n", totalTime);
        System.out.printf("⏱ Среднее время на заказ: %,.7f сек\n",(totalTime / orders.size()));


    }
}
