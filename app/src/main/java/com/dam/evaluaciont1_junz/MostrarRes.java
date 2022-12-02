package com.dam.evaluaciont1_junz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MostrarRes extends AppCompatActivity {

    Button btnSelect;
    EditText editTextTextPersonName2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btnSelect = findViewById(R.id.btnSelect);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);


    }
}