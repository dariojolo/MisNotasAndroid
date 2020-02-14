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

import java.util.List;

import ar.com.dariojolo.misnotas.ui.DetailActivity;
import ar.com.dariojolo.misnotas.Listeners.ItemClickListener;
import ar.com.dariojolo.misnotas.db.entity.NotaEntity;
import ar.com.dariojolo.misnotas.ui.NuevaNotaDialogViewModel;
import ar.com.dariojolo.misnotas.R;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context context;
    List<NotaEntity>listado; //Lista donde se va a guardar la info para mostrar en el RecyclerView
    Boolean isFavorita;
    String color;
    private NuevaNotaDialogViewModel viewModel;

    public MyAdapter(List<NotaEntity> listado, Context context) {
        this.context = context;
        this.listado = listado;
        viewModel = ViewModelProviders.of((AppCompatActivity)context).get(NuevaNotaDialogViewModel.class);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_element,parent, false); //Infla el elemento del recyclerview a cargar
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {
        holder.mItem = listado.get(position);
        holder.mTitle.setText(listado.get(position).getTitle());
        holder.mDescription.setText(listado.get(position).getDescription());
        color = holder.mItem.getColor();


       /* if (color.equalsIgnoreCase("azul")){
            holder.card.setBackgroundColor(context.getResources().getColor(R.color.cardAzul));
        }
        if (color.equalsIgnoreCase("verde")){
            holder.card.setBackgroundColor(context.getResources().getColor(R.color.cardVerde));
        }
        if (color.equalsIgnoreCase("rojo")){
            holder.card.setBackgroundColor(context.getResources().getColor(R.color.cardRojo));
        }*/
        if (color.equalsIgnoreCase("azul")){
            holder.mcolorBar.setBackgroundColor(context.getResources().getColor(R.color.cardAzul));
        //    holder.mcolorBar2.setBackgroundColor(context.getResources().getColor(R.color.cardAzul));
        }
        if (color.equalsIgnoreCase("verde")){
            holder.mcolorBar.setBackgroundColor(context.getResources().getColor(R.color.cardVerde));
         //    holder.mcolorBar2.setBackgroundColor(context.getResources().getColor(R.color.cardVerde));
        }
        if (color.equalsIgnoreCase("rojo")){
            holder.mcolorBar.setBackgroundColor(context.getResources().getColor(R.color.cardRojo));
         //   holder.mcolorBar2.setBackgroundColor(context.getResources().getColor(R.color.cardRojo));
        }

    //    holder.mImage.setImageResource(listado.get(position).getImg());
        isFavorita = listado.get(position).isFavorita();
        holder.mfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "presiono una estrella " + holder.mTitle.getText(), Toast.LENGTH_SHORT).show();
                //listado.get(position).setFavorita(!listado.get(position).isFavorita());
                //  swapItems(listado);

                if (holder.mItem.isFavorita()){
                    holder.mItem.setFavorita(false);
                    holder.mfav.setImageResource(R.drawable.ic_favorite_off);
                }else{
                    holder.mItem.setFavorita(true);
                    holder.mfav.setImageResource(R.drawable.ic_favorite_on);
                }
                viewModel.updateNota(holder.mItem);

            }
        });
        if (isFavorita){
            holder.mfav.setImageResource(R.drawable.ic_favorite_on);
        }else{
            holder.mfav.setImageResource(R.drawable.ic_favorite_off);
        }


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

                if (view.getId() == R.id.imageView2){
                    Toast.makeText(context, "presiono una estrella", Toast.LENGTH_SHORT).show();
                }else{


                String gTitle = listado.get(position).getTitle();
                String gDesc = listado.get(position).getDescription();

                Boolean isFav = listado.get(position).isFavorita();

           /*     BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.mImage.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

                byte[]bytes = stream.toByteArray(); */

                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("iTitle", gTitle);
                intent.putExtra("iDesc", gDesc);
                //intent.putExtra("iImage", bytes);
                intent.putExtra("iFav", isFav);

                context.startActivity(intent);
                }
            }
        });
    }
    public void swapItems(List<NotaEntity> lista){
        this.listado = lista;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listado.size();
    }

    public void setNuevasNotas(List<NotaEntity> nuevasNotas){
        this.listado = nuevasNotas;
        notifyDataSetChanged();
    }
}
