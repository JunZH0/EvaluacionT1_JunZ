package com.dam.evaluaciont1_junz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
// Pantalla de Registro de Resultado
    Button fase1;
    Button fase2;
    Button btnGuardarRes;
    Button btnLimpiarDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fase1 = findViewById(R.id.btnFase1);
        fase2 = findViewById(R.id.btnFase2);
        btnGuardarRes = findViewById(R.id.btnGuardarRes);
        btnLimpiarDatos = findViewById(R.id.btnGuardarRes);

        btnGuardarRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        btnLimpiarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /*
        private void limpiarDatos() {
            ViewGroup group = (ViewGroup)findViewById(R.id.your_group);
            for (int i = 0, count = group.getChildCount(); i < count; ++i) {
                View view = group.getChildAt(i);
                if (view instanceof EditText) {
                    ((EditText)view).setText("");
                }
            }
        }
        */
    }
}