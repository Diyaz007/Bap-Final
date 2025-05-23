import java.util.List;

public class Order {
    private List<String> itemIds;

    public Order(List<String> itemIds) {
        this.itemIds = itemIds;
    }

    public List<String> getItemIds() {
        return itemIds;
    }

    @Override
    public String toString() {
        return "Order: " + itemIds;
    }
}