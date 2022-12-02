package com.dam.evaluaciont1_junz;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MostrarRes extends AppCompatActivity {

    Button btnSelect;
    EditText editTextPais2, inforEq2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_res);



        btnSelect = findViewById(R.id.btnSelect);
        editTextPais2 = findViewById(R.id.editTextPais2);



        if (editTextPais2.getText().toString().isEmpty()) {
            btnSelect.setOnClickListener(new View.OnClickListener() {
                ActivityResultLauncher<Intent> aRLauncher = getIntentActivityResultLauncher();


                public void onClick(View v) {
                    inforEq2 = editTextPais2;
                    selectEquipo(aRLauncher);
                }
            });
        } else {
            btnSelect.setText("Limpiar Datos");
            btnSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    limpiarCampo();
                }
            });
        }

    }


    public void limpiarCampo() {
        editTextPais2.setText(null);
    }

    private ActivityResultLauncher<Intent> getIntentActivityResultLauncher() {
        ActivityResultLauncher<Intent> aRLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            String equipo = result.getData().getStringExtra(SelectEquipo.CLAVE_PAIS);
                            inforEq2.setText(equipo);

                        }
                    }
                }
        );
        return aRLauncher;
    }



    private void selectEquipo(ActivityResultLauncher<Intent> aRLauncher) {
        Intent intent = new Intent(this, SelectEquipo.class);
        aRLauncher.launch(intent);
    }
}