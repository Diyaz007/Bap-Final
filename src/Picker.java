import java.util.*;

public class Picker {
    private Warehouse warehouse;

    public Picker(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public double collectOrder(Order order) {
        long start = System.currentTimeMillis();

        List<Cell> neededCells = new ArrayList<>();
        for (String itemId : order.getItemIds()) {
            outer:
            for (int x = 0; x < warehouse.getSize(); x++) {
                for (int y = 0; y < warehouse.getSize(); y++) {
                    for (int z = 0; z < warehouse.getSize(); z++) {
                        Cell cell = warehouse.getCell(x, y, z);
                        for (Item item : cell.getItems()) {
                            if (item.getId().equals(itemId)) {
                                neededCells.add(cell);
                                cell.removeItemById(itemId);
                                break outer;
                            }
                        }
                    }
                }
            }
        }

        double totalDistance = 0;
        Position exit = warehouse.getExitPosition();
        for (Cell cell : neededCells) {
            Position pos = new Position(cell.getX(), cell.getY(), cell.getZ());
            totalDistance += pos.distanceTo(exit);
        }

        long end = System.currentTimeMillis();
        return (end - start) / 1000.0;
    }
}
