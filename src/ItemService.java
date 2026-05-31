import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private int nextId = 1;
    private List<Item> items = new ArrayList<>();

    void addItem(String title, String type, int rating) {
        Item item = new Item(nextId, title, type, rating);
        items.add(item);
        nextId++;
    }

    void deleteItem(int id) {
        boolean found = false;

        for (int i = 0; i < items.size(); i++) {

            Item currentItem = items.get(i);

            if (currentItem.getId() == id) {
                items.remove(i);

                found = true;

                break;
            }
        }
        if (!found) {
            System.out.println("ID не найден");
        }
    }

    public boolean updateItem(int id, String title, String type, int rating) {
        for (Item currentItem : items) {

            if (currentItem.getId() == id) {
                currentItem.setTitle(title);
                currentItem.setType(type);
                currentItem.setRating(rating);

                return true;
            }
        }
        return false;
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }

    public Item findById(int searchId) {
        for (Item item : items) {
            if (item.getId() == searchId) {
                return item;
            }
        }
        return null;
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
