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
<<<<<<< master
<<<<<<< master
            this.mImage = itemView.findViewById(R.id.imagefav);
            this.mTitle = itemView.findViewById(R.id.titleFav);
            this.mDescription = itemView.findViewById(R.id.descriptionFav);
=======
            this.mImage = itemView.findViewById(R.id.imageIv);
            this.mTitle = itemView.findViewById(R.id.titleIv);
            this.mDescription = itemView.findViewById(R.id.descriptionIv);
>>>>>>> develop~1
=======
            this.mImage = itemView.findViewById(R.id.imagefav);
            this.mTitle = itemView.findViewById(R.id.titleFav);
            this.mDescription = itemView.findViewById(R.id.descriptionFav);
>>>>>>> Se modificaron los layout de los recyclerview - se agrego el icono de favoritos en los recyclerview

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

