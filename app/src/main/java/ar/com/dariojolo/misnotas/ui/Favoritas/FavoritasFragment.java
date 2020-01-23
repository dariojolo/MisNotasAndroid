package ar.com.dariojolo.misnotas.ui.Favoritas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
<<<<<<< master
<<<<<<< master
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
=======
>>>>>>> develop~1
=======
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview

import java.util.ArrayList;

import ar.com.dariojolo.misnotas.CardModel;
import ar.com.dariojolo.misnotas.MyAdapter;
<<<<<<< master
<<<<<<< master
import ar.com.dariojolo.misnotas.MyAdapterFavs;
=======
>>>>>>> develop~1
=======
import ar.com.dariojolo.misnotas.MyAdapterFavs;
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview
import ar.com.dariojolo.misnotas.R;

public class FavoritasFragment extends Fragment {

    private FavoritasViewModel favoritasViewModel;
    RecyclerView mRecyclerView;
<<<<<<< master
<<<<<<< master
    MyAdapterFavs myAdapter;
=======
    MyAdapter myAdapter;
>>>>>>> develop~1
=======
    MyAdapterFavs myAdapter;
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoritasViewModel =
                ViewModelProviders.of(this).get(FavoritasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favoritas, container, false);
       /* final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        }); */

        mRecyclerView = root.findViewById(R.id.recyclerViewFavs);
<<<<<<< master
<<<<<<< master
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        myAdapter = new MyAdapterFavs(getContext(), getMyList());
=======
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        myAdapter = new MyAdapter(getContext(), getMyList());
>>>>>>> develop~1
=======
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        myAdapter = new MyAdapterFavs(getContext(), getMyList());
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview

        mRecyclerView.setAdapter(myAdapter);


        return root;
    }

    private ArrayList<CardModel> getMyList(){
        ArrayList<CardModel> listado = new ArrayList<>();

        CardModel card = new CardModel();
        card.setTitle("News Feed");
        card.setDescription("This is newsfeed description....");
<<<<<<< master
<<<<<<< master
        card.setImg(R.drawable.girl);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
=======
        card.setImg(R.drawable.ic_notifications_black_24dp);
>>>>>>> develop~1
=======
        card.setImg(R.drawable.girl);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview
        listado.add(card);

        card = new CardModel();
        card.setTitle("Business");
        card.setDescription("This is business description....");
<<<<<<< master
<<<<<<< master
        card.setImg(R.drawable.businesswoman);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
=======
        card.setImg(R.drawable.ic_notifications_black_24dp);
>>>>>>> develop~1
=======
        card.setImg(R.drawable.businesswoman);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview
        listado.add(card);

        card = new CardModel();
        card.setTitle("People");
        card.setDescription("This is people description....");
<<<<<<< master
<<<<<<< master
        card.setImg(R.drawable.calendar);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
=======
        card.setImg(R.drawable.ic_notifications_black_24dp);
>>>>>>> develop~1
=======
        card.setImg(R.drawable.calendar);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview
        listado.add(card);

        card = new CardModel();
        card.setTitle("Notes");
        card.setDescription("This is notes description....");
<<<<<<< master
<<<<<<< master
        card.setImg(R.drawable.hours);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
=======
        card.setImg(R.drawable.ic_notifications_black_24dp);
>>>>>>> develop~1
=======
        card.setImg(R.drawable.hours);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview
        listado.add(card);

        card = new CardModel();
        card.setTitle("Feedback");
        card.setDescription("This is feedback description....");
<<<<<<< master
<<<<<<< master
        card.setImg(R.drawable.television);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
=======
        card.setImg(R.drawable.ic_notifications_black_24dp);
>>>>>>> develop~1
=======
        card.setImg(R.drawable.television);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview
        listado.add(card);


        return listado;
    }
}