package ar.com.dariojolo.misnotas.ui;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ar.com.dariojolo.misnotas.db.entity.NotaEntity;
import ar.com.dariojolo.misnotas.Repositories.NotaRepository;

public class NuevaNotaDialogViewModel extends AndroidViewModel {

    private LiveData<List<NotaEntity>>allNotas;
    private LiveData<List<NotaEntity>>allFavNotas;
    private NotaRepository notaRepository;

    public NuevaNotaDialogViewModel(Application application){
        super(application);

        notaRepository = new NotaRepository(application);
        allNotas = notaRepository.getAll();
        allFavNotas = notaRepository.getFavoritas();
    }

    public LiveData<List<NotaEntity>>getAllNotas(){
        return allNotas;
    }
    public LiveData<List<NotaEntity>>getFavNotas(){
        return allFavNotas;
    }

    public void insertNota(NotaEntity nuevaNotaEntity){
        notaRepository.insert(nuevaNotaEntity);
    }

    public void updateNota(NotaEntity nuevaNotaEntity){
        notaRepository.update(nuevaNotaEntity);
    }
}
