package com.dam.evaluaciont1_junz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
// Pantalla de Registro de Resultado
    Button btnFase1,btnFase2,btnGuardarRes,btnLimpiarDatos;
    EditText editTextFase, editTextDate,editTextEq1,editTextEq2,editTextGol1,editTextGol2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initElementos();
        ocultarCampos();

        btnGuardarRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO implementar metodo para comprobar que el input del usuario en el campo editTextFase tenga el formato de fecha correcta
                if (editTextFase.getText().toString().isEmpty() || editTextDate.getText().toString().isEmpty() || editTextEq1.getText().toString().isEmpty()
                        || editTextEq2.getText().toString().isEmpty() || editTextGol1.getText().toString().isEmpty() || editTextGol2.getText().toString().isEmpty()) {
                    /*TODO Muestra todos los campos como vacio aunque solo uno lo este, Arreglar
                    editTextFase.setError("Campo Obligatorio");
                    editTextDate.setError("Campo Obligatorio");
                    editTextEq1.setError("Campo Obligatorio");
                    editTextEq2.setError("Campo Obligatorio");
                    editTextGol1.setError("Campo Obligatorio");
                    editTextGol2.setError("Campo Obligatorio");
                    */
                    // Usar un Toast por el momento
                    Toast.makeText(MainActivity2.this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();

                } else {

                    String fase = editTextFase.getText().toString();
                    String date = editTextDate.getText().toString();
                    String eq1 = editTextEq1.getText().toString();
                    String eq2 = editTextEq2.getText().toString();
                    String gol1 = editTextGol1.getText().toString();
                    String gol2 = editTextGol2.getText().toString();


                    Toast.makeText(MainActivity2.this, "Los datos se han guardado correctamente", Toast.LENGTH_SHORT).show();

                    limpiarDatos();
                }
            }
        });




        btnLimpiarDatos.setOnClickListener(v -> limpiarDatos());



        btnFase1.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("eqSelect", "eq1");
            startActivity(intent);
            // TODO implementar metodo para mostrar el equipo de MainActiviy3 en el campo editTextEq1


        });


        btnFase2.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity2.this, MainActivity3.class);
            intent2.putExtra("eqSelect", "eq2");
            startActivity(intent2);

        });

    }






    private void initElementos() {
        btnFase1 = findViewById(R.id.btnFase1);
        btnFase2 = findViewById(R.id.btnFase2);
        btnGuardarRes = findViewById(R.id.btnGuardarRes);
        btnLimpiarDatos = findViewById(R.id.btnLimpiarDatos);
        editTextFase = findViewById(R.id.editTextFase);
        editTextDate = findViewById(R.id.editTextDate);
        editTextEq1 = findViewById(R.id.editTextEq1);
        editTextEq2 = findViewById(R.id.editTextEq2);
        editTextGol1 = findViewById(R.id.editTextGol1);
        editTextGol2 = findViewById(R.id.editTextGol2);
    }

    public void limpiarDatos(){
        editTextFase.setText("");
        editTextDate.setText("");
        editTextEq1.setText("");
        editTextEq2.setText("");
        editTextGol1.setText("");
        editTextGol2.setText("");
    }

    public void ocultarCampos(){
        int gris = Color.parseColor("#ebe8e8");

        editTextEq1.setFocusable(false);
        editTextEq1.setBackgroundColor(gris);
        editTextEq2.setFocusable(false);
        editTextEq2.setBackgroundColor(gris);
    }



}