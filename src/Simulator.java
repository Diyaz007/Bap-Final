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

        System.out.println("📦 Обработано заказов: " + orders.size());
        System.out.println("⏱ Общее время сбора: " + totalTime + " сек");
        System.out.println("⏱ Среднее время на заказ: " + (totalTime / orders.size()) + " сек");
        System.out.println(warehouse.getCell(0,0,1).toString());

        Warehouse warehouse1 = new Warehouse();
        engine = new PlacementEngine(warehouse1);
        picker = new Picker(warehouse1);

        engine.greedyPlacement(items);
    }
}
