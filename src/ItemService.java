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

    public List<Item> findByTitle(String searchTitle) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public List<Item> findByType(String searchType) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getType().toLowerCase().contains(searchType.toLowerCase())) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public List<Item> findByRating(int searchRating) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getRating() == searchRating) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }
}
