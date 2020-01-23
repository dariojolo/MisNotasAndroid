package ar.com.dariojolo.misnotas;

import android.content.Context;
<<<<<<< master
<<<<<<< master

=======
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
>>>>>>> develop~1
=======

>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
<<<<<<< master
<<<<<<< master
import java.util.ArrayList;

=======

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import ar.com.dariojolo.misnotas.CardModel;
import ar.com.dariojolo.misnotas.DetailActivity;
import ar.com.dariojolo.misnotas.ItemClickListener;
import ar.com.dariojolo.misnotas.MyHolderFavs;
import ar.com.dariojolo.misnotas.R;

>>>>>>> develop~1
=======
import java.util.ArrayList;

>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview
public class MyAdapterFavs extends RecyclerView.Adapter<MyHolderFavs> {

        Context context;
        ArrayList<CardModel> listado; //Lista donde se va a guardar la info para mostrar en el RecyclerView

        public MyAdapterFavs(Context context, ArrayList<CardModel> listado) {
            this.context = context;
            this.listado = listado;
        }

        @NonNull
        @Override
        public MyHolderFavs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
<<<<<<< master
<<<<<<< master
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_fav,null); //Infla el elemento del recyclerview a cargar
=======
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_element,null); //Infla el elemento del recyclerview a cargar
>>>>>>> develop~1
=======
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_fav,null); //Infla el elemento del recyclerview a cargar
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview
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
<<<<<<< master
<<<<<<< master
                //    BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImage.getDrawable();

                //    Bitmap bitmap = bitmapDrawable.getBitmap();

                    //   ByteArrayOutputStream stream = new ByteArrayOutputStream();

                //    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

                //    byte[]bytes = stream.toByteArray();
=======
                    BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImage.getDrawable();
=======
                //    BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImage.getDrawable();
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview

                //    Bitmap bitmap = bitmapDrawable.getBitmap();

                    //   ByteArrayOutputStream stream = new ByteArrayOutputStream();

                //    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

<<<<<<< master
                    byte[]bytes = stream.toByteArray();
>>>>>>> develop~1
=======
                //    byte[]bytes = stream.toByteArray();
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview
                    Toast.makeText(context, "Presionado: " + gTitle, Toast.LENGTH_SHORT).show();

                    /*Intent intent = new Intent(context, DetailActivity.class);

                    intent.putExtra("iTitle", gTitle);
                    intent.putExtra("iDesc", gDesc);
                    intent.putExtra("iImage", bytes);

                    context.startActivity(intent); */
                }
            });
        }

        @Override
        public int getItemCount() {
            return listado.size();
        }
    }
