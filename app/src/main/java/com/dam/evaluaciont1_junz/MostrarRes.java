package com.dam.evaluaciont1_junz;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.dam.evaluaciont1_junz.datos.ListadoResultados;
import com.dam.evaluaciont1_junz.fragmentos.fragmentoResultados;

public class MostrarRes extends AppCompatActivity implements View.OnClickListener {

    Button btnSelect;
    EditText editTextPais2;
    String pais;
    FrameLayout frameLayout1, frameLayout2, frameLayout3, frameLayout4, frameLayout5, frameLayout6, frameLayout7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_res);


        btnSelect = findViewById(R.id.btnSelect);
        editTextPais2 = findViewById(R.id.editTextPais2);
        frameLayout1 = findViewById(R.id.frameLayout1);
        frameLayout2 = findViewById(R.id.frameLayout2);
        frameLayout3 = findViewById(R.id.frameLayout3);
        frameLayout4 = findViewById(R.id.frameLayout4);
        frameLayout5 = findViewById(R.id.frameLayout5);
        frameLayout6 = findViewById(R.id.frameLayout6);
        frameLayout7 = findViewById(R.id.frameLayout7);

        btnSelect.setOnClickListener(this);


    }


    public void limpiarCampo() {
        btnSelect.setText(R.string.sel_eq);
        editTextPais2.setText("");
        frameLayout1.removeAllViews();
        frameLayout2.removeAllViews();
        frameLayout3.removeAllViews();
        frameLayout4.removeAllViews();
        frameLayout5.removeAllViews();
        frameLayout6.removeAllViews();
        frameLayout7.removeAllViews();
    }

    ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        pais = result.getData().getStringExtra(SelectEquipo.CLAVE_PAIS);
                        editTextPais2.setText(pais);
                        btnSelect.setText(R.string.limpiar);
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();

                        for (int i = 0; i < ListadoResultados.getResultado(pais).size(); i++) {
                            fragmentoResultados rf = new fragmentoResultados(pais, i);
                            switch (i) {
                                case 0:
                                    ft.add(R.id.frameLayout1, rf);
                                    break;
                                case 1:
                                    ft.add(R.id.frameLayout2, rf);
                                    break;
                                case 2:
                                    ft.add(R.id.frameLayout3, rf);
                                    break;
                                case 3:
                                    ft.add(R.id.frameLayout4, rf);
                                    break;
                                case 4:
                                    ft.add(R.id.frameLayout5, rf);
                                    break;
                                case 5:
                                    ft.add(R.id.frameLayout6, rf);
                                    break;
                                case 6:
                                    ft.add(R.id.frameLayout7, rf);
                                    break;
                            }
                        }

                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
            }
    );

    public void onClick(View view) {
        if (view.getId() == R.id.btnSelect) {
            if (!editTextPais2.getText().toString().equals(pais)) {
                Intent i = new Intent(this, SelectEquipo.class);
                startActivityForResult.launch(i);
            }
            else {
                limpiarCampo();
            }
        }
    }



    private void selectEquipo(ActivityResultLauncher<Intent> aRLauncher) {
        Intent intent = new Intent(this, SelectEquipo.class);
        aRLauncher.launch(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}