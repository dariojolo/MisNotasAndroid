package ar.com.dariojolo.misnotas.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import ar.com.dariojolo.misnotas.R;
import ar.com.dariojolo.misnotas.db.entity.NotaEntity;

public class EditarNotaActivity extends AppCompatActivity {

    EditText txtTitulo,txtContenido;
    Button btnAceptar, btnCancelar;
    Switch favorita;
    boolean esFavorita;
    RadioButton radioAzul, radioRojo, radioVerde;
    String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_nota);

        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        esFavorita = intent.getBooleanExtra("favorita",false);
        color = intent.getStringExtra("color");

        Toast.makeText(this, "Color: " + color, Toast.LENGTH_SHORT).show();


        txtTitulo = findViewById(R.id.txtTituloEditar);
        txtContenido = findViewById(R.id.txtContenidoEditar);
        favorita = findViewById(R.id.btnFavEditar);

        btnAceptar = findViewById(R.id.btnEditar);
        btnCancelar = findViewById(R.id.btnCancelarEditar);

        radioAzul = findViewById(R.id.radioButtonAzulEditar);
        radioRojo = findViewById(R.id.radioButtonRojoEditar);
        radioVerde = findViewById(R.id.radioButtonVerdeEditar);

        txtTitulo.setText(titulo);
        txtContenido.setText(intent.getStringExtra("desc"));

        if (esFavorita){
            favorita.setChecked(true);
        }else{
            favorita.setChecked(false);
        }



        if (color.equalsIgnoreCase("rojo")){
            radioRojo.setChecked(true);
        }else if (color.equalsIgnoreCase("verde")){
            radioVerde.setChecked(true);
        }else if (color.equalsIgnoreCase("azul")){
            radioAzul.setChecked(true);
        }
        Toast.makeText(this, "Llego: " + intent.getStringExtra("titulo"), Toast.LENGTH_SHORT).show();

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NuevaNotaDialogViewModel mViewModel = ViewModelProviders.of(EditarNotaActivity.this).get(NuevaNotaDialogViewModel.class);
                mViewModel.updateNota(new NotaEntity(txtTitulo.getText().toString(),txtContenido.getText().toString(),R.drawable.ic_gear,esFavorita,color));
                Toast.makeText(getApplicationContext(), "Nota actualizada", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
