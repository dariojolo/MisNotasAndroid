package ar.com.dariojolo.misnotas.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import ar.com.dariojolo.misnotas.db.dao.NotaDao;
import ar.com.dariojolo.misnotas.db.entity.NotaEntity;
import ar.com.dariojolo.misnotas.db.NotaRoomDatabase;

public class NotaRepository {
    private NotaDao notaDao;

    public NotaRepository(Application application) {
        NotaRoomDatabase db = NotaRoomDatabase.getDataBase(application);
        notaDao = db.getNotaDao();
    }

    private static class insertAsyncTask extends AsyncTask<NotaEntity, Void, Void> {

        private NotaDao notaDaoAsync;

        insertAsyncTask(NotaDao dao) {
            notaDaoAsync = dao;
        }

        @Override
        protected Void doInBackground(NotaEntity... notaEntities) {
            notaDaoAsync.insert(notaEntities[0]);
            return null;
        }
    }

    public void insert(NotaEntity nota) {
        new insertAsyncTask(notaDao).execute(nota);
    }

    private static class updateAsyncTask extends AsyncTask<NotaEntity, Void, Void> {

        private NotaDao notaDaoAsync;

        updateAsyncTask(NotaDao dao) {
            notaDaoAsync = dao;
        }

        @Override
        protected Void doInBackground(NotaEntity... notaEntities) {
            notaDaoAsync.update(notaEntities[0]);
            return null;
        }
    }

    public void update(NotaEntity nota) {
        new updateAsyncTask(notaDao).execute(nota);
    }

    public void delete(NotaEntity nota) {
        notaDao.delete(nota);
    }

    public void deleteAll() {
        notaDao.deleteAll();
    }

    public void deleteById(int idNota) {
        notaDao.deleteById(idNota);
    }

    public LiveData<List<NotaEntity>> getAll() {
        return notaDao.getAll();
    }

    public LiveData<List<NotaEntity>> getFavoritas() {
        return notaDao.getFavoritas();
    }

    public NotaEntity getById(int idNota) {
        return notaDao.getById(idNota);
    }

}
