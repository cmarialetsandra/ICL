package com.iprocen.icl;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.iprocen.icl.ui.fuentesAl.FuentesAl;

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

        Map<String, Object> sai = new HashMap<>();
        sai.put("id", 41);
        sai.put("aliment", 3);
        sai.put("entrada", "120 V AC/230 V AC");
        sai.put("salida", "120 V AC/230 V AC-400W/500 V A");
        sai.put("desc", "QUINT-UPS/1AC/1AC/500 V A");
        sai.put("nmro_parte", "2320270");
        sai.put("alm_energia", "No");
        sai.put("t_alm_energia", "");
        mFirestore.collection("SAI_UPS").document("41").set(sai);

        Map<String, Object> sai1 = new HashMap<>();
        sai1.put("id", 42);
        sai1.put("aliment", 3);
        sai1.put("entrada", "");
        sai1.put("salida", "");
        sai1.put("desc", "UPS-BAT/VRLA/24DC/3.4 AH");
        sai1.put("nmro_parte", "2320306");
        sai1.put("alm_energia", "Sí");
        sai1.put("t_alm_energia", "VRLA");
        mFirestore.collection("SAI_UPS").document("42").set(sai1);

        Map<String, Object> sai2 = new HashMap<>();
        sai2.put("id", 43);
        sai2.put("aliment", 3);
        sai2.put("entrada", "");
        sai2.put("salida", "");
        sai2.put("desc", "UPS-BAT/VRLA/24DC/7.2 AH");
        sai2.put("nmro_parte", "2320319");
        sai2.put("alm_energia", "Sí");
        sai2.put("t_alm_energia", "VRLA");
        mFirestore.collection("SAI_UPS").document("43").set(sai2);

        Map<String, Object> sai3 = new HashMap<>();
        sai3.put("id", 44);
        sai3.put("aliment", 3);
        sai3.put("entrada", "");
        sai3.put("salida", "");
        sai3.put("desc", "UPS-BAT/VRLA/24DC/12 AH");
        sai3.put("nmro_parte", "2320322");
        sai3.put("alm_energia", "Sí");
        sai3.put("t_alm_energia", "VRLA");
        mFirestore.collection("SAI_UPS").document("44").set(sai3);

        Map<String, Object> sai4 = new HashMap<>();
        sai4.put("id", 45);
        sai4.put("aliment", 3);
        sai4.put("entrada", "");
        sai4.put("salida", "");
        sai4.put("desc", "UPS-BAT/VRLA/24DC/38 AH");
        sai4.put("nmro_parte", "2320335");
        sai4.put("alm_energia", "Sí");
        sai4.put("t_alm_energia", "VRLA");
        mFirestore.collection("SAI_UPS").document("45").set(sai4);

        Map<String, Object> sai5 = new HashMap<>();
        sai5.put("id", 46);
        sai5.put("aliment", 3);
        sai5.put("entrada", "");
        sai5.put("salida", "");
        sai5.put("desc", "UPS-CAP/24D-C/20A/20KJ");
        sai5.put("nmro_parte", "2320380");
        sai5.put("alm_energia", "Sí");
        sai5.put("t_alm_energia", "CAP");
        mFirestore.collection("SAI_UPS").document("46").set(sai5);

        Map<String, Object> sai6 = new HashMap<>();
        sai6.put("id", 47);
        sai6.put("aliment", 3);
        sai6.put("entrada", "");
        sai6.put("salida", "");
        sai6.put("desc", "UPS-LI-ION/24DC/120WH");
        sai6.put("nmro_parte", "2320351");
        sai6.put("alm_energia", "Sí");
        sai6.put("t_alm_energia", "LI-ION");
        mFirestore.collection("SAI_UPS").document("47").set(sai6);

        Map<String, Object> sai7 = new HashMap<>();
        sai7.put("id", 48);
        sai7.put("aliment", 3);
        sai7.put("entrada", "");
        sai7.put("salida", "");
        sai7.put("desc", "UPS-BAT/VRLA-WTR/24DC/13AH");
        sai7.put("nmro_parte", "2320416");
        sai7.put("alm_energia", "Sí");
        sai7.put("t_alm_energia", "LI-ION");
        mFirestore.collection("SAI_UPS").document("48").set(sai7);

        Map<String, Object> sai8 = new HashMap<>();
        sai8.put("id", 49);
        sai8.put("aliment", 3);
        sai8.put("entrada", "");
        sai8.put("salida", "");
        sai8.put("desc", "UPS-BAT/VRLA-WTR/24DC/13AH");
        sai8.put("nmro_parte", "2320416");
        sai8.put("alm_energia", "Sí");
        sai8.put("t_alm_energia", "VLRA-WTR");
        mFirestore.collection("SAI_UPS").document("49").set(sai8);

        Map<String, Object> sai9 = new HashMap<>();
        sai9.put("id", 50);
        sai9.put("aliment", 3);
        sai9.put("entrada", "");
        sai9.put("salida", "");
        sai9.put("desc", "UPS-BAT/VRLA-WTR/24DC/26AH");
        sai9.put("nmro_parte", "2320429");
        sai9.put("alm_energia", "Sí");
        sai9.put("t_alm_energia", "VLRA-WTR");
        mFirestore.collection("SAI_UPS").document("50").set(sai9);
/*
        Map<String, Object> sai10 = new HashMap<>();
        sai10.put("id", 31);
        sai10.put("aliment", 1);
        sai10.put("entrada", "");
        sai10.put("salida", "");
        sai10.put("desc", "UPS-BAT/VRLA-WTR/24DC/26AH");
        sai10.put("nmro_parte", "2320429");
        sai10.put("alm_energia", "Sí");
        sai10.put("t_alm_energia", "VLRA-WTR");
        mFirestore.collection("SAI_UPS").document("31").set(sai10);*/
    }

}
