package ar.com.dariojolo.misnotas.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.dariojolo.misnotas.R;

public class DetailActivity extends AppCompatActivity {

    TextView mTitleTv, mDescTv;
    ImageView mImageView, mImageFav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        mTitleTv = findViewById(R.id.titleDetail);
        mDescTv = findViewById(R.id.descriptionDetail);
        mImageView = findViewById(R.id.imageView);
        mImageFav = findViewById(R.id.imageView4);

        Intent intent = getIntent();
        String mTitle = intent.getStringExtra("iTitle");
        String mDesc = intent.getStringExtra("iDesc");
        byte[] mBytes = intent.getByteArrayExtra("iImage");
        Boolean isFavorita = intent.getBooleanExtra("iFav",false);

        //Decodificamos la imagen que proviene del Activity anterior en formato bytes

        if (mBytes.length > 0 ){
            Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);
            mImageView.setImageBitmap(bitmap);
        } else{
            mImageView.setImageResource(R.drawable.ic_home_black_24dp);
        }

        if (isFavorita){
            mImageFav.setImageResource(R.drawable.ic_favorite_on);
        }else{
            mImageFav.setImageResource(R.drawable.ic_favorite_off);
        }


        actionBar.setTitle(mTitle);

        //Seteamos la data en los elementos de la vista
        mTitleTv.setText(mTitle);
        mDescTv.setText(mDesc);
      //  mImageView.setImageResource(R.drawable.ic_home_black_24dp);

    }
}
