package ar.com.dariojolo.misnotas.Adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import ar.com.dariojolo.misnotas.Listeners.ItemClickListener;
import ar.com.dariojolo.misnotas.Models.NotaModel;
import ar.com.dariojolo.misnotas.R;

public class MyAdapterFavs extends RecyclerView.Adapter<MyHolderFavs> {

        Context context;
        ArrayList<NotaModel> listado; //Lista donde se va a guardar la info para mostrar en el RecyclerView

        public MyAdapterFavs(Context context, ArrayList<NotaModel> listado) {
            this.context = context;
            this.listado = listado;
        }

        @NonNull
        @Override
        public MyHolderFavs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_fav,null); //Infla el elemento del recyclerview a cargar

            return new MyHolderFavs(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyHolderFavs holder, int position) {
            holder.mTitle.setText(listado.get(position).getTitle());
            holder.mDescription.setText(listado.get(position).getDescription());
            holder.mImage.setImageResource(listado.get(position).getImg());

            holder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onItemClickListener(View view, int position) {
                    String gTitle = listado.get(position).getTitle();
                    String gDesc = listado.get(position).getDescription();

                    Toast.makeText(context, "Presionado: " + gTitle, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return listado.size();
        }
    }
