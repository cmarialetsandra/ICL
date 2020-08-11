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

        Map<String, Object> ps1 = new HashMap<>();
        ps1.put("id", 42);
        ps1.put("senial", "Discreta");
        ps1.put("conexion", "Tornillo");
        ps1.put("voltaje", "<55 Vp Conductor-Tierra");
        ps1.put("aterrizaje", "Directo");
        ps1.put("disenio", "No-Enchufable");
        ps1.put("monitoreo", "Sin");
        ps1.put("desc", "CN-LAMBDA/4-0.47-BB");
        ps1.put("nmro_parte", "2800021");
        mFirestore.collection("ProtecSobre").document("42").set(ps1);

        Map<String, Object> ps2 = new HashMap<>();
        ps2.put("id", 43);
        ps2.put("senial", "Discreta");
        ps2.put("conexion", "Tornillo");
        ps2.put("voltaje", "<18 Vp Conductor-Tierra");
        ps2.put("aterrizaje", "Directo");
        ps2.put("disenio", "No-Enchufable");
        ps2.put("monitoreo", "Sin");
        ps2.put("desc", "CN-LAMBDA/4-2.25-BB");
        ps2.put("nmro_parte", "2801057");
        mFirestore.collection("ProtecSobre").document("43").set(ps2);

        Map<String, Object> ps3 = new HashMap<>();
        ps3.put("id", 44);
        ps3.put("senial", "Discreta");
        ps3.put("conexion", "Tornillo");
        ps3.put("voltaje", "<11 Vp Conductor-Tierra");
        ps3.put("aterrizaje", "Directo");
        ps3.put("disenio", "No-Enchufable");
        ps3.put("monitoreo", "Sin");
        ps3.put("desc", "CN-LAMBDA/4-5.9-BB");
        ps3.put("nmro_parte", "2838490");
        mFirestore.collection("ProtecSobre").document("44").set(ps3);

        Map<String, Object> ps4 = new HashMap<>();
        ps4.put("id", 45);
        ps4.put("senial", "Discreta");
        ps4.put("conexion", "Tornillo");
        ps4.put("voltaje", "280 DC");
        ps4.put("aterrizaje", "Directo");
        ps4.put("disenio", "No-Enchufable");
        ps4.put("monitoreo", "Sin");
        ps4.put("desc", "CN-UB-280DC-3-BB");
        ps4.put("nmro_parte", "2801050");
        mFirestore.collection("ProtecSobre").document("45").set(ps4);

        Map<String, Object> ps5 = new HashMap<>();
        ps5.put("id", 46);
        ps5.put("senial", "Discreta");
        ps5.put("conexion", "RJ45");
        ps5.put("voltaje", "<3.3 V DC");
        ps5.put("aterrizaje", "Directo");
        ps5.put("disenio", "No-Enchufable");
        ps5.put("monitoreo", "Sin");
        ps5.put("desc", "DT-LAN-CAT.6+");
        ps5.put("nmro_parte", "2881007");
        mFirestore.collection("ProtecSobre").document("46").set(ps5);

        Map<String, Object> ps6 = new HashMap<>();
        ps6.put("id", 47);
        ps6.put("senial", "Discreta");
        ps6.put("conexion", "RJ45");
        ps6.put("voltaje", "12 V DC");
        ps6.put("aterrizaje", "Directo");
        ps6.put("disenio", "No-Enchufable");
        ps6.put("monitoreo", "Sin");
        ps6.put("desc", "DT-UFB-485/BS");
        ps6.put("nmro_parte", "2920612");
        mFirestore.collection("ProtecSobre").document("47").set(ps6);

        Map<String, Object> ps7 = new HashMap<>();
        ps7.put("id", 48);
        ps7.put("senial", "Discreta");
        ps7.put("conexion", "RJ45");
        ps7.put("voltaje", "185 V DC/130 V AC");
        ps7.put("aterrizaje", "Directo");
        ps7.put("disenio", "No-Enchufable");
        ps7.put("monitoreo", "Sin");
        ps7.put("desc", "DT-TELE-SHDSL");
        ps7.put("nmro_parte", "2801593");
        mFirestore.collection("ProtecSobre").document("48").set(ps7);

        Map<String, Object> ps8 = new HashMap<>();
        ps8.put("id", 49);
        ps8.put("senial", "Discreta");
        ps8.put("conexion", "RJ45");
        ps8.put("voltaje", "185 V DC/130 V AC");
        ps8.put("aterrizaje", "Directo");
        ps8.put("disenio", "No-Enchufable");
        ps8.put("monitoreo", "Sin");
        ps8.put("desc", "DT-TELE-RJ45");
        ps8.put("nmro_parte", "2882925");
        mFirestore.collection("ProtecSobre").document("49").set(ps8);

        Map<String, Object> ps9 = new HashMap<>();
        ps9.put("id", 50);
        ps9.put("senial", "Discreta");
        ps9.put("conexion", "D-SUB");
        ps9.put("voltaje", "5 V DC/10 V AC");
        ps9.put("aterrizaje", "Directo");
        ps9.put("disenio", "No-Enchufable");
        ps9.put("monitoreo", "Sin");
        ps9.put("desc", "DT-UFB-V24/S-9-SB");
        ps9.put("nmro_parte", "2803069");
        mFirestore.collection("ProtecSobre").document("50").set(ps9);

        Map<String, Object> ps10 = new HashMap<>();
        ps10.put("id", 51);
        ps10.put("senial", "Discreta");
        ps10.put("conexion", "D-SUB");
        ps10.put("voltaje", "5.8 V DC");
        ps10.put("aterrizaje", "Directo");
        ps10.put("disenio", "No-Enchufable");
        ps10.put("monitoreo", "Sin");
        ps10.put("desc", "DT-UFB-IB-RB0");
        ps10.put("nmro_parte", "2800056");
        mFirestore.collection("ProtecSobre").document("51").set(ps10);

    }

}
