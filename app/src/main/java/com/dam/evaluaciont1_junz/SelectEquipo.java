package com.dam.evaluaciont1_junz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;

public class SelectEquipo extends AppCompatActivity {
// Pantalla de seleccion de equipos
    public static final String CLAVE_PAIS = "pais";
    TableLayout tabLayout1;
    Button btnAceptar,btnCancelar;
    EditText editTextIntroPais;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
        editTextIntroPais = findViewById(R.id.editTextIntroPais);
        tabLayout1 = findViewById(R.id.tabLayout1);

        for (int i = 0; i < ((ViewGroup) tabLayout1).getChildCount(); i++) {
            TableRow row = (TableRow) ((ViewGroup) tabLayout1).getChildAt(i);
            for (int j = 0; j < ((ViewGroup) row).getChildCount(); j++) {
                Button button = (Button) ((ViewGroup) row).getChildAt(j);
                button.setOnClickListener(view -> editTextIntroPais.setText(button.getText()));
            }
        }



        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, getIntent());
                getIntent().putExtra(CLAVE_PAIS, editTextIntroPais.getText().toString());

                finish();


            }
        });

    }
}