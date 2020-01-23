package ar.com.dariojolo.misnotas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context context;
    ArrayList<CardModel>listado; //Lista donde se va a guardar la info para mostrar en el RecyclerView
    Boolean isFavorita;

    public MyAdapter(Context context, ArrayList<CardModel> listado) {
        this.context = context;
        this.listado = listado;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_element,null); //Infla el elemento del recyclerview a cargar
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int position) {
        holder.mTitle.setText(listado.get(position).getTitle());
        holder.mDescription.setText(listado.get(position).getDescription());
        holder.mImage.setImageResource(listado.get(position).getImg());
        isFavorita = listado.get(position).isFavorita();

        if (isFavorita){
            holder.mfav.setImageResource(R.drawable.ic_favorite_on);
        }else{
            holder.mfav.setImageResource(R.drawable.ic_favorite_off);
        }


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                String gTitle = listado.get(position).getTitle();
                String gDesc = listado.get(position).getDescription();
<<<<<<< master
<<<<<<< master
                Boolean isFav = listado.get(position).isFavorita();
=======
>>>>>>> develop~1
=======
                Boolean isFav = listado.get(position).isFavorita();
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview
                BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.mImage.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

                byte[]bytes = stream.toByteArray();

                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("iTitle", gTitle);
                intent.putExtra("iDesc", gDesc);
                intent.putExtra("iImage", bytes);
                intent.putExtra("iFav", isFav);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listado.size();
    }
}
