package ar.com.dariojolo.misnotas;

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

public class DetailActivity extends AppCompatActivity {

    TextView mTitleTv, mDescTv;
    ImageView mImageView;

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

        Intent intent = new Intent();
        String mTitle = intent.getStringExtra("iTitle");
        String mDesc = intent.getStringExtra("iDesc");
        byte[] mBytes = intent.getByteArrayExtra("iImage");

        //Decodificamos la imagen que proviene del Activity anterior en formato bytes

        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

        actionBar.setTitle(mTitle);

        //Seteamos la data en los elementos de la vista
        mTitleTv.setText(mTitle);
        mDescTv.setText(mDesc);
        mImageView.setImageBitmap(bitmap);


    }
}
