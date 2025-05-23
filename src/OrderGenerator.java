import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OrderGenerator {
    private List<Item> catalog;
    private Random random = new Random();

    public OrderGenerator(List<Item> catalog) {
        this.catalog = catalog;
    }

    public Order generateRandomOrder() {
        int count = 1 + random.nextInt(5); // от 1 до 5
        List<Item> shuffled = new ArrayList<>(catalog);
        Collections.shuffle(shuffled, random);
        List<String> orderIds = new ArrayList<>();

        for (int i = 0; i < count && i < shuffled.size(); i++) {
            orderIds.add(shuffled.get(i).getId());

        }

        return new Order(orderIds);
    }
}
