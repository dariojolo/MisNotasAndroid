package ar.com.dariojolo.misnotas.ui.home;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import ar.com.dariojolo.misnotas.Adapters.MyAdapter;
import ar.com.dariojolo.misnotas.Entities.NotaEntity;

import ar.com.dariojolo.misnotas.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

      //  mRecyclerView = root.findViewById(R.id.recyclerView_landscape);

        mRecyclerView = (RecyclerView)root;

        if (mRecyclerView.getId() == R.id.recyclerView_portrait){
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }else{
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
            int numeroColumnas = (int) (dpWidth / 180 );

            mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(numeroColumnas, StaggeredGridLayoutManager.VERTICAL));
        }




        myAdapter = new MyAdapter(getContext(), getMyList());

        mRecyclerView.setAdapter(myAdapter);


        return root;
    }


    private ArrayList<NotaEntity>getMyList(){
        ArrayList<NotaEntity> listado = new ArrayList<>();

        NotaEntity card = new NotaEntity();
        card.setTitle("News Feed");
        card.setDescription("This is newsfeed description....");
        card.setImg(R.drawable.girl);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
        listado.add(card);

        card = new NotaEntity();
        card.setTitle("Business");
        card.setDescription("This is business description....");
        card.setImg(R.drawable.businesswoman);
        card.setFavorita(true);
        card.setColor(android.R.color.holo_green_dark);
        listado.add(card);

        card = new NotaEntity();
        card.setTitle("People");
        card.setDescription("This is people description....");
        card.setImg(R.drawable.calendar);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);
        listado.add(card);

        card = new NotaEntity();
        card.setTitle("Notes");
        card.setDescription("This is notes description....");
        card.setImg(R.drawable.hours);
        card.setFavorita(true);
        card.setColor(android.R.color.holo_green_dark);
        listado.add(card);

        card = new NotaEntity();
        card.setTitle("Feedback");
        card.setDescription("This is feedback description....");
        card.setImg(R.drawable.television);
        card.setFavorita(false);
        card.setColor(android.R.color.holo_green_dark);

        listado.add(card);


        return listado;
    }
}