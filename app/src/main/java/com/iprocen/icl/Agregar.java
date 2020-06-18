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
        /*
        Map<String, Object> fuentes1 = new HashMap<>();
        fuentes1.put("id", 50);
        fuentes1.put("fase", "Monofásico");
        fuentes1.put("s_tension", "");
        fuentes1.put("s_corriente", "");
        fuentes1.put("clasific", false);
        fuentes1.put("desc", "PLT-SEC-T3-120-FM-UT");
        fuentes1.put("nmro_parte", "2907918");
        fuentes1.put("protect_sobre", true);
        fuentes1.put("voltaje", "120 V AC");
        fuentes1.put("corriente", "26 A");
        mFirestore.collection("FuentesAl").document("50").set(fuentes1);

        Map<String, Object> fuentes2 = new HashMap<>();
        fuentes2.put("id", 51);
        fuentes2.put("fase", "Monofásico");
        fuentes2.put("s_tension", "");
        fuentes2.put("s_corriente", "");
        fuentes2.put("clasific", false);
        fuentes2.put("desc", "PLT-SEC-T3-230-FM-UT");
        fuentes2.put("nmro_parte", "2907919");
        fuentes2.put("protect_sobre", true);
        fuentes2.put("voltaje", "240 V AC");
        fuentes2.put("corriente", "26 A");
        mFirestore.collection("FuentesAl").document("51").set(fuentes2);

        Map<String, Object> fuentes3 = new HashMap<>();
        fuentes3.put("id", 52);
        fuentes3.put("fase", "Monofásico");
        fuentes3.put("s_tension", "");
        fuentes3.put("s_corriente", "");
        fuentes3.put("clasific", false);
        fuentes3.put("desc", "PLT-SEC-T3-120-FM-PT");
        fuentes3.put("nmro_parte", "2907927");
        fuentes3.put("protect_sobre", true);
        fuentes3.put("voltaje", "120 V AC");
        fuentes3.put("corriente", "26 A");
        mFirestore.collection("FuentesAl").document("52").set(fuentes3);

        Map<String, Object> fuentes4 = new HashMap<>();
        fuentes4.put("id", 53);
        fuentes4.put("fase", "Monofásico");
        fuentes4.put("s_tension", "");
        fuentes4.put("s_corriente", "");
        fuentes4.put("clasific", false);
        fuentes4.put("desc", "PLT-SEC-T3-230-FM-PT");
        fuentes4.put("nmro_parte", "2907928");
        fuentes4.put("protect_sobre", true);
        fuentes4.put("voltaje", "240 V AC");
        fuentes4.put("corriente", "26 A");
        mFirestore.collection("FuentesAl").document("53").set(fuentes4);

        Map<String, Object> fuentes5 = new HashMap<>();
        fuentes5.put("id", 54);
        fuentes5.put("fase", "Trifásico");
        fuentes5.put("s_tension", "");
        fuentes5.put("s_corriente", "");
        fuentes5.put("clasific", false);
        fuentes5.put("desc", "VAL-US-120/40/3+1-FM");
        fuentes5.put("nmro_parte", "2910354");
        fuentes5.put("protect_sobre", true);
        fuentes5.put("voltaje", "120/208 V AC");
        fuentes5.put("corriente", "n/a");
        mFirestore.collection("FuentesAl").document("54").set(fuentes5);

        Map<String, Object> fuentes6 = new HashMap<>();
        fuentes6.put("id", 55);
        fuentes6.put("fase", "Trifásico");
        fuentes6.put("s_tension", "");
        fuentes6.put("s_corriente", "");
        fuentes6.put("clasific", false);
        fuentes6.put("desc", "VAL-US-277/40/3+1-FM");
        fuentes6.put("nmro_parte", "2910374");
        fuentes6.put("protect_sobre", true);
        fuentes6.put("voltaje", "277/480 V AC");
        fuentes6.put("corriente", "n/a");
        mFirestore.collection("FuentesAl").document("55").set(fuentes6);

        Map<String, Object> fuentes7 = new HashMap<>();
        fuentes7.put("id", 47);
        fuentes7.put("fase", "Trifásico");
        fuentes7.put("s_tension", "24 V DC");
        fuentes7.put("s_corriente", "40 A");
        fuentes7.put("clasific", true);
        fuentes7.put("desc", "QUINT-4PS/3AC/24DC/40");
        fuentes7.put("nmro_parte", "2904623");
        fuentes7.put("protect_sobre", false);
        fuentes7.put("voltaje", "");
        fuentes7.put("corriente", "");
        mFirestore.collection("FuentesAl").document("47").set(fuentes7);

        Map<String, Object> fuentes8 = new HashMap<>();
        fuentes8.put("id", 48);
        fuentes8.put("fase", "Trifásico");
        fuentes8.put("s_tension", "24 V DC");
        fuentes8.put("s_corriente", "40 A");
        fuentes8.put("clasific", false);
        fuentes8.put("desc", "TRIO-PS-2G/3AC/24DC/40");
        fuentes8.put("nmro_parte", "2903156");
        fuentes8.put("protect_sobre", false);
        fuentes8.put("voltaje", "");
        fuentes8.put("corriente", "");
        mFirestore.collection("FuentesAl").document("48").set(fuentes8);

        Map<String, Object> fuentes9 = new HashMap<>();
        fuentes9.put("id", 49);
        fuentes9.put("fase", "Trifásico");
        fuentes9.put("s_tension", "48 V DC");
        fuentes9.put("s_corriente", "20 A");
        fuentes9.put("clasific", true);
        fuentes9.put("desc", "QUINT-PS/3AC/48DC/20");
        fuentes9.put("nmro_parte", "2320827");
        fuentes9.put("protect_sobre", false);
        fuentes9.put("voltaje", "");
        fuentes9.put("corriente", "");
        mFirestore.collection("FuentesAl").document("49").set(fuentes9);

        Map<String, Object> fuentes10 = new HashMap<>();
        fuentes10.put("id", 23);
        fuentes10.put("fase", "Monofásico");
        fuentes10.put("s_tension", "24 V DC");
        fuentes10.put("s_corriente", "3.8 A");
        fuentes10.put("clasific", false);
        fuentes10.put("desc", "QUINT4-PS/1AC/24DC/3.8/SC");
        fuentes10.put("nmro_parte", "2904599");
        fuentes10.put("protect_sobre", false);
        fuentes10.put("voltaje", "");
        fuentes10.put("corriente", "");
        mFirestore.collection("FuentesAl").document("23").set(fuentes10);

        Map<String, Object> fuentes11 = new HashMap<>();
        fuentes11.put("id", 24);
        fuentes11.put("fase", "Monofásico");
        fuentes11.put("s_tension", "24 V DC");
        fuentes11.put("s_corriente", "4.2 A");
        fuentes11.put("clasific", true);
        fuentes11.put("desc", "UNO-PS/1AC/24DC/100W");
        fuentes11.put("nmro_parte", "2902993");
        fuentes11.put("protect_sobre", false);
        fuentes11.put("voltaje", "");
        fuentes11.put("corriente", "");
        mFirestore.collection("FuentesAl").document("24").set(fuentes11);

        Map<String, Object> fuentes12 = new HashMap<>();
        fuentes12.put("id", 25);
        fuentes12.put("fase", "Monofásico");
        fuentes12.put("s_tension", "24 V DC");
        fuentes12.put("s_corriente", "5 A");
        fuentes12.put("clasific", true);
        fuentes12.put("desc", "QUINT4-PS/1AC/24DC/5");
        fuentes12.put("nmro_parte", "2904600");
        fuentes12.put("protect_sobre", false);
        fuentes12.put("voltaje", "");
        fuentes12.put("corriente", "");
        mFirestore.collection("FuentesAl").document("25").set(fuentes12);

        Map<String, Object> fuentes13 = new HashMap<>();
        fuentes13.put("id", 26);
        fuentes13.put("fase", "Monofásico");
        fuentes13.put("s_tension", "24 V DC");
        fuentes13.put("s_corriente", "5 A");
        fuentes13.put("clasific", false);
        fuentes13.put("desc", "TRIO-PS-2G/1AC/24DC/5");
        fuentes13.put("nmro_parte", "2903148");
        fuentes13.put("protect_sobre", false);
        fuentes13.put("voltaje", "");
        fuentes13.put("corriente", "");
        mFirestore.collection("FuentesAl").document("26").set(fuentes13);

        Map<String, Object> fuentes14 = new HashMap<>();
        fuentes14.put("id", 27);
        fuentes14.put("fase", "Monofásico");
        fuentes14.put("s_tension", "24 V DC");
        fuentes14.put("s_corriente", "6.25 A");
        fuentes14.put("clasific", true);
        fuentes14.put("desc", "UNO-PS/1AC/24DC/150W");
        fuentes14.put("nmro_parte", "2904376");
        fuentes14.put("protect_sobre", false);
        fuentes14.put("voltaje", "");
        fuentes14.put("corriente", "");
        mFirestore.collection("FuentesAl").document("27").set(fuentes14);

        Map<String, Object> fuentes15 = new HashMap<>();
        fuentes15.put("id", 28);
        fuentes15.put("fase", "Monofásico");
        fuentes15.put("s_tension", "24 V DC");
        fuentes15.put("s_corriente", "10 A");
        fuentes15.put("clasific", true);
        fuentes15.put("desc", "QUINT4-PS/1AC/24DC/10");
        fuentes15.put("nmro_parte", "2904601");
        fuentes15.put("protect_sobre", false);
        fuentes15.put("voltaje", "");
        fuentes15.put("corriente", "");
        mFirestore.collection("FuentesAl").document("28").set(fuentes15);

        Map<String, Object> fuentes16 = new HashMap<>();
        fuentes16.put("id", 29);
        fuentes16.put("fase", "Monofásico");
        fuentes16.put("s_tension", "24 V DC");
        fuentes16.put("s_corriente", "10 A");
        fuentes16.put("clasific", false);
        fuentes16.put("desc", "TRIO-PS-2G/1AC/24DC/10");
        fuentes16.put("nmro_parte", "2903149");
        fuentes16.put("protect_sobre", false);
        fuentes16.put("voltaje", "");
        fuentes16.put("corriente", "");
        mFirestore.collection("FuentesAl").document("29").set(fuentes16);

        Map<String, Object> fuentes17 = new HashMap<>();
        fuentes17.put("id", 30);
        fuentes17.put("fase", "Monofásico");
        fuentes17.put("s_tension", "24 V DC");
        fuentes17.put("s_corriente", "10 A");
        fuentes17.put("clasific", true);
        fuentes17.put("desc", "UNO-PS/1AC/24DC/240W");
        fuentes17.put("nmro_parte", "2904372");
        fuentes17.put("protect_sobre", false);
        fuentes17.put("voltaje", "");
        fuentes17.put("corriente", "");
        mFirestore.collection("FuentesAl").document("30").set(fuentes17);

        Map<String, Object> fuentes18 = new HashMap<>();
        fuentes18.put("id", 31);
        fuentes18.put("fase", "Monofásico");
        fuentes18.put("s_tension", "24 V DC");
        fuentes18.put("s_corriente", "20 A");
        fuentes18.put("clasific", true);
        fuentes18.put("desc", "QUINT4-PS/1AC/24DC/24");
        fuentes18.put("nmro_parte", "2904602");
        fuentes18.put("protect_sobre", false);
        fuentes18.put("voltaje", "");
        fuentes18.put("corriente", "");
        mFirestore.collection("FuentesAl").document("31").set(fuentes18);

        Map<String, Object> fuentes19 = new HashMap<>();
        fuentes19.put("id", 32);
        fuentes19.put("fase", "Monofásico");
        fuentes19.put("s_tension", "24 V DC");
        fuentes19.put("s_corriente", "20 A");
        fuentes19.put("clasific", false);
        fuentes19.put("desc", "TRIO-PS-2G/1AC/24DC/20");
        fuentes19.put("nmro_parte", "2903151");
        fuentes19.put("protect_sobre", false);
        fuentes19.put("voltaje", "");
        fuentes19.put("corriente", "");
        mFirestore.collection("FuentesAl").document("32").set(fuentes19);

        Map<String, Object> fuentes20 = new HashMap<>();
        fuentes20.put("id", 33);
        fuentes20.put("fase", "Monofásico");
        fuentes20.put("s_tension", "24 V DC");
        fuentes20.put("s_corriente", "40 A");
        fuentes20.put("clasific", true);
        fuentes20.put("desc", "QUINT4-PS/1AC/24DC/40");
        fuentes20.put("nmro_parte", "2904603");
        fuentes20.put("protect_sobre", false);
        fuentes20.put("voltaje", "");
        fuentes20.put("corriente", "");
        mFirestore.collection("FuentesAl").document("33").set(fuentes20);*/
    }

}
