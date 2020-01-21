package ar.com.dariojolo.misnotas;

public class CardModel {
    private String title, description;
    private int img;

    public CardModel(){}
    public CardModel(String title, String description, int img) {
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
