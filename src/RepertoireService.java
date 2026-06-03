import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepertoireService {
    private int nextId = 1;
    private List<RepertoireItem> items = new ArrayList<>();

    void addItem(String title, String composer, String instrument, String type, int rating) {
        RepertoireItem item = new RepertoireItem(nextId, title, composer, instrument, type, rating);
        items.add(item);
        nextId++;
    }

    void deleteItem(int id) {
        boolean found = false;

        for (int i = 0; i < items.size(); i++) {

            RepertoireItem RepertoireItem = items.get(i);

            if (RepertoireItem.getId() == id) {
                items.remove(i);

                found = true;

                break;
            }
        }
        if (!found) {
            System.out.println("ID не найден");
        }
    }

    public boolean updateItem(int id, String title, String composer, String type, int rating) {
        for (RepertoireItem RepertoireItem : items) {

            if (RepertoireItem.getId() == id) {
                RepertoireItem.setTitle(title);
                RepertoireItem.setComposer(composer);
                RepertoireItem.setType(type);
                RepertoireItem.setRating(rating);

                return true;
            }
        }
        return false;
    }

    public List<RepertoireItem> sortByRating() {
        List<RepertoireItem> sortedList = new ArrayList<>(items);
        sortedList.sort(Comparator.comparing(RepertoireItem::getRating));
        return sortedList;
    }

    public List<RepertoireItem> getAllItems() {
        return new ArrayList<>(items);
    }

    public RepertoireItem findById(int searchId) {
        for (RepertoireItem item : items) {
            if (item.getId() == searchId) {
                return item;
            }
        }
        return null;
    }

    public List<RepertoireItem> findByTitle(String searchTitle) {
        List<RepertoireItem> foundItems = new ArrayList<>();
        for (RepertoireItem item : items) {
            if (item.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public List<RepertoireItem> findByComposer(String searchComposer) {
        List<RepertoireItem> foundItems = new ArrayList<>();
        for (RepertoireItem item : items) {
            if (item.getComposer().toLowerCase().contains(searchComposer.toLowerCase())) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public List<RepertoireItem> findByType(String searchType) {
        List<RepertoireItem> foundItems = new ArrayList<>();
        for (RepertoireItem item : items) {
            if (item.getType().toLowerCase().contains(searchType.toLowerCase())) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public List<RepertoireItem> findByRating(int searchRating) {
        List<RepertoireItem> foundItems = new ArrayList<>();
        for (RepertoireItem item : items) {
            if (item.getRating() == searchRating) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }
}
