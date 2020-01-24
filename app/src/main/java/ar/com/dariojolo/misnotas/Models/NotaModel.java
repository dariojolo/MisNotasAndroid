package ar.com.dariojolo.misnotas.Models;

public class NotaModel {
    private String title, description;
    private int img;
    private boolean favorita;
    private int color;

    public NotaModel() {
    }

    public NotaModel(String title, String description, int img, boolean favorita, int color) {
        this.title = title;
        this.description = description;
        this.img = img;
        this.favorita = favorita;
        this.color = color;
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

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
