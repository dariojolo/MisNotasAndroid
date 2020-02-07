package ar.com.dariojolo.misnotas.ui.Favoritas;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.List;

import ar.com.dariojolo.misnotas.db.entity.NotaEntity;
import ar.com.dariojolo.misnotas.Adapters.MyAdapterFavs;
import ar.com.dariojolo.misnotas.R;
import ar.com.dariojolo.misnotas.ui.NuevaNotaDialogViewModel;

public class FavoritasFragment extends Fragment {

    private FavoritasViewModel favoritasViewModel;
    RecyclerView mRecyclerView;
    MyAdapterFavs myAdapter;

    private NuevaNotaDialogViewModel nuevaNotaDialogViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoritasViewModel =
                ViewModelProviders.of(this).get(FavoritasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favoritas, container, false);

        mRecyclerView = root.findViewById(R.id.recyclerViewFavs);

        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int numeroColumnas = (int) (dpWidth / 180 );

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(numeroColumnas, StaggeredGridLayoutManager.VERTICAL));

        myAdapter = new MyAdapterFavs(getMyList(),getContext() );
        mRecyclerView.setAdapter(myAdapter);

        lanzarViewModel();

        return root;
    }

    private void lanzarViewModel() {
        nuevaNotaDialogViewModel = ViewModelProviders.of(getActivity()).get(NuevaNotaDialogViewModel.class);
        nuevaNotaDialogViewModel.getFavNotas().observe(getActivity(), new Observer<List<NotaEntity>>() {
            @Override
            public void onChanged(List<NotaEntity> notaEntities) {
                myAdapter.setNuevasNotas(notaEntities);
            }
        });
    }

    private ArrayList<NotaEntity> getMyList(){
        ArrayList<NotaEntity> listado = new ArrayList<>();
        return listado;
    }
}