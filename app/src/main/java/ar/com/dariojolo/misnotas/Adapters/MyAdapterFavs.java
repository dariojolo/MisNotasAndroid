package ar.com.dariojolo.misnotas.Adapters;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import ar.com.dariojolo.misnotas.Listeners.ItemClickListener;
import ar.com.dariojolo.misnotas.db.entity.NotaEntity;
import ar.com.dariojolo.misnotas.R;
import ar.com.dariojolo.misnotas.ui.DetailActivity;
import ar.com.dariojolo.misnotas.ui.NuevaNotaDialogViewModel;

public class MyAdapterFavs extends RecyclerView.Adapter<MyHolderFavs> {

        Context context;
        List<NotaEntity> listado; //Lista donde se va a guardar la info para mostrar en el RecyclerView
        Boolean isFavorita;
        private NuevaNotaDialogViewModel viewModel;
        String color;

        public MyAdapterFavs(List<NotaEntity> listado, Context context ) {
            this.context = context;
            this.listado = listado;
            viewModel = ViewModelProviders.of((AppCompatActivity)context).get(NuevaNotaDialogViewModel.class);
        }

        @NonNull
        @Override
        public MyHolderFavs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_fav,null); //Infla el elemento del recyclerview a cargar

            return new MyHolderFavs(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyHolderFavs holder, int position) {
            holder.mItem = listado.get(position);
            holder.mTitle.setText(listado.get(position).getTitle());
            holder.mDescription.setText(listado.get(position).getDescription());
          //  holder.mImage.setImageResource(listado.get(position).getImg());
            isFavorita = listado.get(position).isFavorita();
            color = listado.get(position).getColor();
            if (color.equalsIgnoreCase("azul")){
                holder.mcolorBar.setBackgroundColor(context.getResources().getColor(R.color.cardAzul));
                holder.mcolorBar2.setBackgroundColor(context.getResources().getColor(R.color.cardAzul));
            }
            if (color.equalsIgnoreCase("verde")){
                holder.mcolorBar.setBackgroundColor(context.getResources().getColor(R.color.cardVerde));
                holder.mcolorBar2.setBackgroundColor(context.getResources().getColor(R.color.cardVerde));
            }
            if (color.equalsIgnoreCase("rojo")){
                holder.mcolorBar.setBackgroundColor(context.getResources().getColor(R.color.cardRojo));
                holder.mcolorBar2.setBackgroundColor(context.getResources().getColor(R.color.cardRojo));
            }
            holder.mFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(context, "presiono una estrella " + holder.mTitle.getText(), Toast.LENGTH_SHORT).show();
                    //listado.get(position).setFavorita(!listado.get(position).isFavorita());
                    //  swapItems(listado);

                    if (holder.mItem.isFavorita()){
                        holder.mItem.setFavorita(false);
                        holder.mFav.setImageResource(R.drawable.ic_favorite_off);
                    }else{
                        holder.mItem.setFavorita(true);
                        holder.mFav.setImageResource(R.drawable.ic_favorite_on);
                    }
                    viewModel.updateNota(holder.mItem);

                }
            });

            holder.setItemClickListener(new ItemClickListener() {
                @Override
                public void onItemClickListener(View view, int position) {

                    String gTitle = listado.get(position).getTitle();
                    String gDesc = listado.get(position).getDescription();

                    Toast.makeText(context, "Presionado: " + gTitle, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc);


                    context.startActivity(intent);
                }
            });
            if (isFavorita){
                holder.mFav.setImageResource(R.drawable.ic_favorite_on);
            }else{
                holder.mFav.setImageResource(R.drawable.ic_favorite_off);
            }
        }


    public void setNuevasNotas(List<NotaEntity> nuevasNotas){
        this.listado = nuevasNotas;
        notifyDataSetChanged();
    }

        @Override
        public int getItemCount() {
            return listado.size();
        }
    }
