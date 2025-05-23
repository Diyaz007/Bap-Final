public class Item {
    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private String id;
    private Size size;
    private int frequency; // Частота заказов

    public Item(String id, Size size, int frequency) {
        this.id = id;
        this.size = size;
        this.frequency = frequency;
    }

    public String getId() {
        return id;
    }

    public Size getSize() {
        return size;
    }

    public int getFrequency() {
        return frequency;
    }

    public void incrementFrequency() {
        frequency++;
    }

    @Override
    public String toString() {
        return "Item{id='" + id + "', size=" + size + ", freq=" + frequency + "}";
    }
}

