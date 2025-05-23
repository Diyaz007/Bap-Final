import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int x, y, z;
    private List<Item> items;

    public Cell(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.items = new ArrayList<>();
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getZ() { return z; }

    public List<Item> getItems() {
        return items;
    }

    public boolean isAvailable(Item item) {
        int itemSize = switch (item.getSize()) {
            case SMALL -> 1;
            case MEDIUM -> 4;
            case LARGE -> 8;
        };

        int used = 0;
        for (Item i : items) {
            used += switch (i.getSize()) {
                case SMALL -> 1;
                case MEDIUM -> 4;
                case LARGE -> 8;
            };
        }

        return used + itemSize <= 8;
    }

    public void addItem(Item item) {
        if (isAvailable(item)) {
            items.add(item);
        } else {
            throw new IllegalStateException("Недостаточно места в ячейке");
        }
    }

    public boolean removeItemById(String itemId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(itemId)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Cell(" + x + "," + y + "," + z + ") [" + items.size() + " items]";
    }
}

