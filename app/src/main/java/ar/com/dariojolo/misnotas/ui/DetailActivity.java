package ar.com.dariojolo.misnotas.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import ar.com.dariojolo.misnotas.ui.EditarNotaActivity;
import ar.com.dariojolo.misnotas.db.entity.NotaEntity;
import ar.com.dariojolo.misnotas.R;

public class DetailActivity extends AppCompatActivity {

    TextView mTitleTv, mDescTv;
    ImageView mImageView, mImageFav;
    String mTitle;
    String mDesc;
    Boolean isFavorita;


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
        mTitle = intent.getStringExtra("iTitle");
        mDesc = intent.getStringExtra("iDesc");
     //   byte[] mBytes = intent.getByteArrayExtra("iImage");
        isFavorita = intent.getBooleanExtra("iFav",false);

        //Decodificamos la imagen que proviene del Activity anterior en formato bytes

    /*    if (mBytes.length > 0 ){
            Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);
            mImageView.setImageBitmap(bitmap);
        } else{
            mImageView.setImageResource(R.drawable.ic_home_black_24dp);
        } */
        mImageView.setImageResource(R.drawable.ic_home_black_24dp);
        if (isFavorita){
            mImageFav.setImageResource(R.drawable.ic_favorite_on);
            //btnFav.setChecked(true);
        }else{
            mImageFav.setImageResource(R.drawable.ic_favorite_off);
            //btnFav.setChecked(false);
        }


        actionBar.setTitle(mTitle);

        //Seteamos la data en los elementos de la vista
        mTitleTv.setText(mTitle);
        mDescTv.setText(mDesc);
      //  mImageView.setImageResource(R.drawable.ic_home_black_24dp);

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu_nota_detalle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_edit:
                NotaEntity nota = new NotaEntity( mTitle, mDesc, 0, isFavorita, "");
                mostrarDialogoEditarNota(nota);
             case R.id.action_add_delete:
                Toast.makeText(getApplicationContext(), "Ey todavia no se puede eliminar la nota", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void mostrarDialogoEditarNota(NotaEntity nota) {
        Toast.makeText(this, "Editar nota " + nota.getTitle() +" - Es favorita:" + nota.isFavorita(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, EditarNotaActivity.class);
        intent.putExtra("titulo", nota.getTitle());
        intent.putExtra("desc", nota.getDescription());
        intent.putExtra("favorita", nota.isFavorita());
        intent.putExtra("color", nota.getColor());

        startActivity(intent);

        finish();

        /*

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.nueva_nota_dialog_fragment, null))
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "Aceptar", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });



        builder.setMessage("Mensaje")
                .setTitle("Titulo");
        AlertDialog dialog = builder.create();
        dialog.show(); */


//        FragmentManager fm = this.getSupportFragmentManager();
//        NuevaNotaDialogFragment dialogNuevaNota = new NuevaNotaDialogFragment();
//        dialogNuevaNota.show(fm, "EdithNotaDialogFragment");
    }
}
