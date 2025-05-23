import java.util.Comparator;
import java.util.List;

public class PlacementEngine {
    private Warehouse warehouse;

    public PlacementEngine(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void greedyPlacement(List<Item> items) {
        items.sort((a, b) -> Integer.compare(b.getFrequency(), a.getFrequency()));

        int size = warehouse.getSize();

        for (Item item : items) {
            boolean placed = false;

            outer:
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    for (int z = 0; z < size; z++) {
                        Cell cell = warehouse.getCell(x, y, z);
                        if (cell.isAvailable(item)) {
                            cell.addItem(item);
                            placed = true;
                            System.out.println(x + " " + y + " " + z);
                            break outer;
                        }
                    }
                }
            }

            if (!placed) {
                System.out.println("❌ Не удалось разместить товар: " + item);
            }
        }
    }
}
