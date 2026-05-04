import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private List<Item> items = new ArrayList<>();

    void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }
}
