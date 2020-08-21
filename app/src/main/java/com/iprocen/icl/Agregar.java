package com.iprocen.icl;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Agregar extends Fragment {

    FirebaseFirestore mFirestore;

    Button btn_guardar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agregar, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn_guardar = getActivity().findViewById(R.id.btn_guardar);

        mFirestore = FirebaseFirestore.getInstance();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar();
            }
        });
    }

    private void agregar(){
        /*Map<String, Object> sw1 = new HashMap<>();
        sw1.put("id", 4);
        sw1.put("puerto_cobre", "4");
        sw1.put("puerto_especial", "1 fibra, SC SM");
        sw1.put("puerto_total", "4");
        sw1.put("velocidad", "10/100");
        sw1.put("alimentacion", "No");
        sw1.put("area", "Si");
        sw1.put("condicion", false);
        sw1.put("desc", "FL SWITCH SFNB 4TX/FX SM20");
        sw1.put("nmro_parte", "2891029");
        mFirestore.collection("SwitchesEt").document("4").set(sw1);

        Map<String, Object> sw2 = new HashMap<>();
        sw2.put("id", 5);
        sw2.put("puerto_cobre", "8");
        sw2.put("puerto_especial", "Ninguno");
        sw2.put("puerto_total", "8");
        sw2.put("velocidad", "10/100");
        sw2.put("alimentacion", "No");
        sw2.put("area", "Si");
        sw2.put("condicion", false);
        sw2.put("desc", "FL SWITCH SFNB 8TX");
        sw2.put("nmro_parte", "2891002");
        mFirestore.collection("SwitchesEt").document("5").set(sw2);*/
    }
}
