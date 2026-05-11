class Item {
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

    // Конструктор
    public Item(int id, String title, String type, int rating) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.rating = rating;
    }
}
