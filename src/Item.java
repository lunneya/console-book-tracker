public class Item {
    private int id;
    private String title;
    private String type;
    private int rating;

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getType() {
        return type;
    }
    public int getRating() {
        return rating;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    // Конструктор
    public Item(int id, String title, String type, int rating) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.rating = rating;
    }
}
