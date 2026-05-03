class Item {
    private String title;
    private String type;
    private int rating;

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
    public Item(String title, String type, int rating) {
        this.title = title;
        this.type = type;
        this.rating = rating;
    }
}
