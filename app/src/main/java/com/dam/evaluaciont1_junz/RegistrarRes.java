package com.dam.evaluaciont1_junz;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class RegistrarRes extends AppCompatActivity {
// Pantalla de Registro de Resultado
    final Calendar calendario = Calendar.getInstance();
    static final int MAX_GOLES = 15;
    Button btnFase1,btnFase2,btnGuardarRes,btnLimpiarDatos;
    Spinner spn1;
    EditText editTextHora,editTextDate,editTextEq1,editTextEq2,editTextGol1,editTextGol2, inforEq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initElementos();
        bloquearEdit();

        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int anio, int mes, int dia) {
                calendario.set(Calendar.YEAR, anio);
                calendario.set(Calendar.MONTH,mes);
                calendario.set(Calendar.DAY_OF_MONTH,dia);
                updateLabel();
            }
        };

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(RegistrarRes.this,date,calendario.get(Calendar.YEAR),calendario.get(Calendar.MONTH),calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        editTextHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(RegistrarRes.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        editTextHora.setText(hourOfDay+":"+minute);
                    }
                },0,0,true);
                timePickerDialog.show();
            }
        });

        btnGuardarRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO implementar metodo para comprobar que el input del usuario en el campo editTextFase tenga el formato de fecha correcta
                if (editTextDate.getText().toString().isEmpty() || editTextHora.getText().toString().isEmpty() || editTextEq1.getText().toString().isEmpty()
                        || editTextEq2.getText().toString().isEmpty() || editTextGol1.getText().toString().isEmpty() || editTextGol2.getText().toString().isEmpty()) {

                    Toast.makeText(RegistrarRes.this, "Por favor, rellene todos los campos", Toast.LENGTH_SHORT).show();

                } else if (Integer.parseInt(editTextGol1.getText().toString()) > MAX_GOLES ||
                        Integer.parseInt(editTextGol2.getText().toString()) > MAX_GOLES) {

                    Toast.makeText(RegistrarRes.this, "El número de goles no puede ser mayor que " + MAX_GOLES, Toast.LENGTH_SHORT).show();

                }
                else {
                    // Supuesto Guardado de datos
                    String fase = spn1.getSelectedItem().toString();
                    String hora = editTextHora.getText().toString();
                    String fecha = editTextDate.getText().toString();
                    String eq1 = editTextEq1.getText().toString();
                    String eq2 = editTextEq2.getText().toString();
                    String gol1 = editTextGol1.getText().toString();
                    String gol2 = editTextGol2.getText().toString();


                    Toast.makeText(RegistrarRes.this, "Los datos se han guardado correctamente", Toast.LENGTH_SHORT).show();

                    limpiarDatos();
                }
            }
        });



        ActivityResultLauncher<Intent> aRLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        String equipo = result.getData().getStringExtra(SelectEquipo.CLAVE_PAIS);
                        inforEq.setText(equipo);
                    }
                }
            }
        );


        btnLimpiarDatos.setOnClickListener(v -> limpiarDatos());



        btnFase1.setOnClickListener(v -> {
            inforEq = editTextEq1;
            selectEquipo(aRLauncher);
        });


        btnFase2.setOnClickListener(v -> {
            inforEq = editTextEq2;
            selectEquipo(aRLauncher);

        });

    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat= null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dateFormat = new SimpleDateFormat(myFormat, Locale.forLanguageTag("es"));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            editTextDate.setText(dateFormat.format(calendario.getTime()));
        }
    }

    private void selectEquipo(ActivityResultLauncher<Intent> aRLauncher) {
        Intent intent = new Intent(this, SelectEquipo.class);
        aRLauncher.launch(intent);
    }


    private void initElementos() {
        btnFase1 = findViewById(R.id.btnFase1);
        btnFase2 = findViewById(R.id.btnFase2);
        btnGuardarRes = findViewById(R.id.btnGuardarRes);
        btnLimpiarDatos = findViewById(R.id.btnLimpiarDatos);
        spn1 = findViewById(R.id.spn1);
        editTextHora = findViewById(R.id.editTextHora);
        editTextDate = findViewById(R.id.editTextDate);
        editTextEq1 = findViewById(R.id.editTextEq1);
        editTextEq2 = findViewById(R.id.editTextEq2);
        editTextGol1 = findViewById(R.id.editTextGol1);
        editTextGol2 = findViewById(R.id.editTextGol2);
    }

    public void limpiarDatos(){
        spn1.setSelection(0);
        editTextHora.setText(null);
        editTextDate.setText(null);
        editTextEq1.setText(null);
        editTextEq2.setText(null);
        editTextGol1.setText(null);
        editTextGol2.setText(null);
    }

    public void bloquearEdit(){
        int gris = Color.parseColor("#ebe8e8");

        editTextEq1.setFocusable(false);
        editTextEq1.setBackgroundColor(gris);
        editTextEq2.setFocusable(false);
        editTextEq2.setBackgroundColor(gris);
    }



}