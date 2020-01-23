package ar.com.dariojolo.misnotas;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

    public class MyHolderFavs extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView mImage;
        TextView mTitle, mDescription;
        ItemClickListener itemClickListener;

        MyHolderFavs(@NonNull View itemView) {
            super(itemView);
            this.mImage = itemView.findViewById(R.id.imagefav);
            this.mTitle = itemView.findViewById(R.id.titleFav);
            this.mDescription = itemView.findViewById(R.id.descriptionFav);

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

