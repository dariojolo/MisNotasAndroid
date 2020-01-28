package ar.com.dariojolo.misnotas;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import ar.com.dariojolo.misnotas.Entities.NotaEntity;

public class NuevaNotaDialogFragment extends DialogFragment {

    private View view;

    private EditText txtTitulo, txtContenido;
    private RadioGroup rgColor;
    private Switch swFavorita;



    public static NuevaNotaDialogFragment newInstance() {
        return new NuevaNotaDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nueva_nota_dialog_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.nueva_nota);
        builder.setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String titulo = txtTitulo.getText().toString();
                        String contenido = txtContenido.getText().toString();
                        String color = "azul";
                        switch (rgColor.getCheckedRadioButtonId()){
                            case R.id.radioButtonRojo:
                                color = "rojo";
                                break;
                            case R.id.radioButtonVerde:
                                color = "verde";
                                break;
                            case R.id.radioButtonAzul:
                                color = "azul";
                                break;
                        }
                        boolean isFavorita = swFavorita.isChecked();
                        NuevaNotaDialogViewModel mViewModel = ViewModelProviders.of(getActivity()).get(NuevaNotaDialogViewModel.class);
                        mViewModel.insertNota(new NotaEntity(titulo,contenido,R.drawable.ic_gear,isFavorita,color));
                        dialog.dismiss();

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.nueva_nota_dialog_fragment, null);

        txtTitulo = view.findViewById(R.id.txtTituloAlta);
        txtContenido = view.findViewById(R.id.txtContenido);
        swFavorita = view.findViewById(R.id.btnFav);
        rgColor = view.findViewById(R.id.radioGroupColor);

        builder.setView(view);

        // Create the AlertDialog object and return it
        return builder.create();
    }


}
