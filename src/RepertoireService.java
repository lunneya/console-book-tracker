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

            RepertoireItem item = items.get(i);

            if (item.getId() == id) {
                items.remove(i);

                found = true;

                break;
            }
        }
        if (!found) {
            System.out.println("ID не найден");
        }
    }

    public boolean updateItem(int id, String title, String composer, String instrument, String type, int rating) {
        for (RepertoireItem item : items) {

            if (item.getId() == id) {
                item.setTitle(title);
                item.setComposer(composer);
                item.setInstrument(instrument);
                item.setType(type);
                item.setRating(rating);

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

    public void setItems(List<RepertoireItem> items) {
        this.items = items;

        int maxId = 0;

        for (RepertoireItem item : items) {
            if (item.getId() > maxId) {
                maxId = item.getId();
            }
        }

        this.nextId = maxId + 1;
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

    public List<RepertoireItem> findByInstrument(String searchInstrument) {
        List<RepertoireItem> foundItems = new ArrayList<>();
        for (RepertoireItem item : items) {
            if (item.getInstrument().toLowerCase().contains(searchInstrument.toLowerCase())) {
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
