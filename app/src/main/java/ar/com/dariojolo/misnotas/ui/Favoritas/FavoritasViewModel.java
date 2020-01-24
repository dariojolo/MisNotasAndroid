package ar.com.dariojolo.misnotas.ui.Favoritas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavoritasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FavoritasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}