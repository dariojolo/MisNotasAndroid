package ar.com.dariojolo.misnotas.ui.home;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import ar.com.dariojolo.misnotas.Adapters.MyAdapter;
import ar.com.dariojolo.misnotas.Entities.NotaEntity;

import ar.com.dariojolo.misnotas.NuevaNotaDialogFragment;
import ar.com.dariojolo.misnotas.NuevaNotaDialogViewModel;
import ar.com.dariojolo.misnotas.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    private NuevaNotaDialogViewModel nuevaNotaDialogViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        setHasOptionsMenu(true);

      //  mRecyclerView = root.findViewById(R.id.recyclerView_landscape);

        mRecyclerView = (RecyclerView)root;

       // if (mRecyclerView.getId() == R.id.recyclerView_portrait){
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       // }else{
       //     DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
       //     float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
       //     int numeroColumnas = (int) (dpWidth / 180 );

       //     mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(numeroColumnas, StaggeredGridLayoutManager.VERTICAL));
        //}

        myAdapter = new MyAdapter(this.getMyList(), getActivity());
        mRecyclerView.setAdapter(myAdapter);

        lanzerViewModel();


        return root;
    }

    private void lanzerViewModel() {
        nuevaNotaDialogViewModel = ViewModelProviders.of(getActivity()).get(NuevaNotaDialogViewModel.class);
        nuevaNotaDialogViewModel.getAllNotas().observe(getActivity(), new Observer<List<NotaEntity>>() {
            @Override
            public void onChanged(List<NotaEntity> notaEntities) {
                myAdapter.setNuevasNotas(notaEntities);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.options_menu_nota_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_nota:
                mostrarDialogoNuevaNota();
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    private void mostrarDialogoNuevaNota() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        NuevaNotaDialogFragment dialogNuevaNota = new NuevaNotaDialogFragment();
        dialogNuevaNota.show(fm, "NuevaNotaDialogFragment");
    }

    private List<NotaEntity>getMyList(){
        List<NotaEntity> listado = new ArrayList<>();


        return listado;
    }
}