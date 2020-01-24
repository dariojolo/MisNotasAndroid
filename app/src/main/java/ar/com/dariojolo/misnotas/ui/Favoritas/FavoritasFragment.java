package ar.com.dariojolo.misnotas.ui.Favoritas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

import ar.com.dariojolo.misnotas.Models.NotaModel;
import ar.com.dariojolo.misnotas.Adapters.MyAdapterFavs;
import ar.com.dariojolo.misnotas.R;

public class FavoritasFragment extends Fragment {

    private FavoritasViewModel favoritasViewModel;
    RecyclerView mRecyclerView;
    MyAdapterFavs myAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoritasViewModel =
                ViewModelProviders.of(this).get(FavoritasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favoritas, container, false);

        mRecyclerView = root.findViewById(R.id.recyclerViewFavs);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        myAdapter = new MyAdapterFavs(getContext(), getMyList());
        mRecyclerView.setAdapter(myAdapter);

        return root;
    }

    private ArrayList<NotaModel> getMyList(){
        ArrayList<NotaModel> listado = new ArrayList<>();

        NotaModel card = new NotaModel();
        card.setTitle("News Feed");
        card.setDescription("This is newsfeed description....");
        card.setImg(R.drawable.girl);
        card.setFavorita(true);
        card.setColor(android.R.color.holo_green_dark);
        if (card.isFavorita()) {
            listado.add(card);
        }

        card = new NotaModel();
        card.setTitle("Business");
        card.setDescription("This is business description....");
        card.setImg(R.drawable.businesswoman);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
        if (card.isFavorita()) {
            listado.add(card);
        }

        card = new NotaModel();
        card.setTitle("People");
        card.setDescription("This is people description....");
        card.setImg(R.drawable.calendar);
        card.setFavorita(true);
        card.setColor(android.R.color.holo_green_dark);
        if (card.isFavorita()) {
            listado.add(card);
        }

        card = new NotaModel();
        card.setTitle("Notes");
        card.setDescription("This is notes description....");
        card.setImg(R.drawable.hours);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
        if (card.isFavorita()) {
            listado.add(card);
        }

        card = new NotaModel();
        card.setTitle("Feedback");
        card.setDescription("This is feedback description....");
        card.setImg(R.drawable.television);
        card.setFavorita(true);
        card.setColor(android.R.color.holo_green_dark);
        if (card.isFavorita()) {
            listado.add(card);
        }


        return listado;
    }
}