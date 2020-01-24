package ar.com.dariojolo.misnotas.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notas")
public class NotaEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;

    public String description;

    public int img;

    public boolean favorita;

    public int color;

    public NotaEntity() {
    }

    public NotaEntity(String title, String description, int img, boolean favorita, int color) {
        this.title = title;
        this.description = description;
        this.img = img;
        this.favorita = favorita;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
