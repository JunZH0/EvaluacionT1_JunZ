package com.dam.evaluaciont1_junz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class fragmentoResultados extends Fragment {

    TextView textViewFaseFrag;
    TextView txtViewFecha;
    TextView textViewEq1;
    TextView textViewEq2;
    TextView textViewGol1;
    TextView textViewGol2;

    private static final String ARG_PARAM = "param";
    private String mParam;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento_resultados, container, false);


    }
}