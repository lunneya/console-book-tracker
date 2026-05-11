import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ItemService {
    private int nextId = 1;
    private List<Item> items = new ArrayList<>();

    void addItem(String title, String type, int rating) {
        Item item = new Item(nextId, title, type, rating);
        items.add(item);
//        System.out.println(nextId);
        nextId++;
    }

    int targetId = 2;
    void deleteItem(Item item) {

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
