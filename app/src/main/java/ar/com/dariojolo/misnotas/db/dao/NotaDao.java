package ar.com.dariojolo.misnotas.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ar.com.dariojolo.misnotas.db.entity.NotaEntity;

@Dao
public interface NotaDao {
    @Insert
    void insert(NotaEntity nota);

    @Update
    void update(NotaEntity nota);

    @Delete
    void delete(NotaEntity nota);

    @Query("DELETE FROM notas")
    void deleteAll();

    @Query("DELETE FROM notas WHERE id = :idNota")
    void deleteById(int idNota);

    @Query("SELECT * FROM notas ORDER BY title ASC")
    LiveData<List<NotaEntity>>getAll();

    @Query("SELECT * FROM notas WHERE favorita = 1 ORDER BY title ASC")
    LiveData<List<NotaEntity>> getFavoritas();

    @Query("SELECT * FROM notas WHERE id = :idNota")
    NotaEntity getById(int idNota);

}
