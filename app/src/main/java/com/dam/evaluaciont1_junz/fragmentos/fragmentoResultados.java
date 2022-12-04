package com.dam.evaluaciont1_junz.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.dam.evaluaciont1_junz.R;
import com.dam.evaluaciont1_junz.datos.ListadoResultados;
import com.dam.evaluaciont1_junz.datos.Resultado;


public class fragmentoResultados extends Fragment {

    TextView textViewFaseFrag;
    TextView txtViewFecha;
    TextView textViewEq1;
    TextView textViewEq2;
    TextView textViewGol1;
    TextView textViewGol2;
    String resPais;
    int resNum;


    public fragmentoResultados(String pais, int res) {
        // Required empty public constructor
        resPais = pais;
        resNum = res;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_fragmento_resultados, container, false);
        textViewFaseFrag = vista.findViewById(R.id.textViewFaseFrag);
        txtViewFecha = vista.findViewById(R.id.txtViewFecha);
        textViewEq1 = vista.findViewById(R.id.textViewEq1);
        textViewEq2 = vista.findViewById(R.id.textViewEq2);
        textViewGol1 = vista.findViewById(R.id.textViewGol1);
        textViewGol2 = vista.findViewById(R.id.textViewGol2);

        ArrayList<Resultado> res = ListadoResultados.getResultado(resPais);

        textViewFaseFrag.setText(res.get(resNum).getFase());
        txtViewFecha.setText(res.get(resNum).getFecha());
        textViewEq1.setText(res.get(resNum).getEquipo1());
        textViewGol1.setText(String.valueOf(res.get(resNum).getGol1()));
        textViewEq2.setText(res.get(resNum).getEquipo2());
        textViewGol2.setText(String.valueOf(res.get(resNum).getGol2()));


        return vista;


    }
}