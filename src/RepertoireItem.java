public class RepertoireItem {
    private int id;
    private String title;
    private String composer;
    private String instrument;
    private String type;
    private int rating;

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getComposer() {
        return composer;
    }
    public String getInstrument() {
        return instrument;
    }
    public String getType() {
        return type;
    }
    public int getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setComposer(String composer) {
        this.composer = composer;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    // Конструктор
    public RepertoireItem(int id, String title, String composer, String instrument, String type, int rating) {
        this.id = id;
        this.title = title;
        this.composer = composer;
        this.instrument = instrument;
        this.type = type;
        this.rating = rating;
    }
}
