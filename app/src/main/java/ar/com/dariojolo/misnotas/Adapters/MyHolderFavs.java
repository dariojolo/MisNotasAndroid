package ar.com.dariojolo.misnotas.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ar.com.dariojolo.misnotas.Listeners.ItemClickListener;
import ar.com.dariojolo.misnotas.R;
import ar.com.dariojolo.misnotas.db.NotaRoomDatabase;
import ar.com.dariojolo.misnotas.db.entity.NotaEntity;

public class MyHolderFavs extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView mFav;
        TextView mTitle, mDescription, mcolorBar,mcolorBar2;
        ItemClickListener itemClickListener;
        NotaEntity mItem;

        MyHolderFavs(@NonNull View itemView) {
            super(itemView);

           // this.mImage = itemView.findViewById(R.id.imagefav);
            this.mTitle = itemView.findViewById(R.id.titleFav);
            this.mDescription = itemView.findViewById(R.id.descriptionFav);
            this.mFav = itemView.findViewById(R.id.imageView3);
            this.mcolorBar = itemView.findViewById(R.id.colorBar);
            this.mcolorBar2 = itemView.findViewById(R.id.colorBar2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClickListener(v, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener item){
            this.itemClickListener = item;
        }
    }

