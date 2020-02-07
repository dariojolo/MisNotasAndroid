package ar.com.dariojolo.misnotas.Adapters;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import ar.com.dariojolo.misnotas.db.entity.NotaEntity;
import ar.com.dariojolo.misnotas.Listeners.ItemClickListener;
import ar.com.dariojolo.misnotas.R;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView mfav;
    TextView mTitle, mDescription, mcolorBar, mcolorBar2;
    ItemClickListener itemClickListener;
    ImageButton imgButton;
    NotaEntity mItem;
    CardView card;

    MyHolder(@NonNull View itemView) {
        super(itemView);
     //   this.mImage = itemView.findViewById(R.id.imageIv);
        this.mTitle = itemView.findViewById(R.id.titleIv);
        this.mDescription = itemView.findViewById(R.id.descriptionIv);
        this.mfav = itemView.findViewById(R.id.imageView2);
       // this.imgButton = itemView.findViewById(R.id.imageButton);
        //this.card = itemView.findViewById(R.id.cardView);
        this.mcolorBar = itemView.findViewById(R.id.colorBar3);
      //  this.mcolorBar2 = itemView.findViewById(R.id.colorBar4);
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
