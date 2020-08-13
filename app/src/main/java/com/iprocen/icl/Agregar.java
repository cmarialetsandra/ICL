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
        Map<String, Object> cb1 = new HashMap<>();
        cb1.put("id", 74);
        cb1.put("tipo", 4);
        cb1.put("ul", "");
        cb1.put("nmro_polos", "");
        cb1.put("curva", "");
        cb1.put("amperaje", "");
        cb1.put("canal", "");
        cb1.put("funcion", "");
        cb1.put("accesorio", "Barra de bus");
        cb1.put("desc", "TMC 8 B2 80 46 CA");
        cb1.put("nmro_parte", "2907996");
        mFirestore.collection("CircuitBr").document("74").set(cb1);

        Map<String, Object> cb2 = new HashMap<>();
        cb2.put("id", 75);
        cb2.put("tipo", 4);
        cb2.put("ul", "");
        cb2.put("nmro_polos", "");
        cb2.put("curva", "");
        cb2.put("amperaje", "");
        cb2.put("canal", "");
        cb2.put("funcion", "");
        cb2.put("accesorio", "Barra de bus");
        cb2.put("desc", "TMC 8 B3 80 48 CA");
        cb2.put("nmro_parte", "2907997");
        mFirestore.collection("CircuitBr").document("75").set(cb2);

        Map<String, Object> cb3 = new HashMap<>();
        cb3.put("id", 76);
        cb3.put("tipo", 4);
        cb3.put("ul", "");
        cb3.put("nmro_polos", "");
        cb3.put("curva", "");
        cb3.put("amperaje", "");
        cb3.put("canal", "");
        cb3.put("funcion", "");
        cb3.put("accesorio", "Terminal");
        cb3.put("desc", "TMC 8 B TERM PIN");
        cb3.put("nmro_parte", "2907998");
        mFirestore.collection("CircuitBr").document("76").set(cb3);

        Map<String, Object> cb4 = new HashMap<>();
        cb4.put("id", 77);
        cb4.put("tipo", 4);
        cb4.put("ul", "");
        cb4.put("nmro_polos", "");
        cb4.put("curva", "");
        cb4.put("amperaje", "");
        cb4.put("canal", "");
        cb4.put("funcion", "");
        cb4.put("accesorio", "Tapa final");
        cb4.put("desc", "TMC 8 B TERM PIN");
        cb4.put("nmro_parte", "2907999");
        mFirestore.collection("CircuitBr").document("77").set(cb4);

        Map<String, Object> cb5 = new HashMap<>();
        cb5.put("id", 78);
        cb5.put("tipo", 4);
        cb5.put("ul", "");
        cb5.put("nmro_polos", "");
        cb5.put("curva", "");
        cb5.put("amperaje", "");
        cb5.put("canal", "");
        cb5.put("funcion", "");
        cb5.put("accesorio", "Tapa de bus");
        cb5.put("desc", "TMC 8 B BUS CAP");
        cb5.put("nmro_parte", "2908000");
        mFirestore.collection("CircuitBr").document("78").set(cb5);

        Map<String, Object> cb6 = new HashMap<>();
        cb6.put("id", 79);
        cb6.put("tipo", 4);
        cb6.put("ul", "");
        cb6.put("nmro_polos", "");
        cb6.put("curva", "");
        cb6.put("amperaje", "");
        cb6.put("canal", "");
        cb6.put("funcion", "");
        cb6.put("accesorio", "Auxiliar");
        cb6.put("desc", "TMC 7/8 AUX");
        cb6.put("nmro_parte", "2908219");
        mFirestore.collection("CircuitBr").document("79").set(cb6);

        Map<String, Object> cb7 = new HashMap<>();
        cb7.put("id", 80);
        cb7.put("tipo", 4);
        cb7.put("ul", "");
        cb7.put("nmro_polos", "");
        cb7.put("curva", "");
        cb7.put("amperaje", "");
        cb7.put("canal", "");
        cb7.put("funcion", "");
        cb7.put("accesorio", "Alarma");
        cb7.put("desc", "TMC 7/8 ALARM");
        cb7.put("nmro_parte", "2908220");
        mFirestore.collection("CircuitBr").document("80").set(cb7);

        Map<String, Object> cb8 = new HashMap<>();
        cb8.put("id", 81);
        cb8.put("tipo", 4);
        cb8.put("ul", "");
        cb8.put("nmro_polos", "");
        cb8.put("curva", "");
        cb8.put("amperaje", "");
        cb8.put("canal", "");
        cb8.put("funcion", "");
        cb8.put("accesorio", "Derivación");
        cb8.put("desc", "TMC 7/8 12VDC SHNT");
        cb8.put("nmro_parte", "2908221");
        mFirestore.collection("CircuitBr").document("81").set(cb8);

        Map<String, Object> cb9 = new HashMap<>();
        cb9.put("id", 82);
        cb9.put("tipo", 4);
        cb9.put("ul", "");
        cb9.put("nmro_polos", "");
        cb9.put("curva", "");
        cb9.put("amperaje", "");
        cb9.put("canal", "");
        cb9.put("funcion", "");
        cb9.put("accesorio", "Derivación");
        cb9.put("desc", "TMC 7/8 24VDC SHNT");
        cb9.put("nmro_parte", "2908222");
        mFirestore.collection("CircuitBr").document("82").set(cb9);

        Map<String, Object> cb10 = new HashMap<>();
        cb10.put("id", 83);
        cb10.put("tipo", 4);
        cb10.put("ul", "");
        cb10.put("nmro_polos", "");
        cb10.put("curva", "");
        cb10.put("amperaje", "");
        cb10.put("canal", "");
        cb10.put("funcion", "");
        cb10.put("accesorio", "Derivación");
        cb10.put("desc", "TMC 7/8 48VDC SHNT");
        cb10.put("nmro_parte", "2908224");
        mFirestore.collection("CircuitBr").document("83").set(cb10);

        Map<String, Object> cb11 = new HashMap<>();
        cb11.put("id", 84);
        cb11.put("tipo", 4);
        cb11.put("ul", "");
        cb11.put("nmro_polos", "");
        cb11.put("curva", "");
        cb11.put("amperaje", "");
        cb11.put("canal", "");
        cb11.put("funcion", "");
        cb11.put("accesorio", "Derivación");
        cb11.put("desc", "TMC 7/8 125VDC SHNT");
        cb11.put("nmro_parte", "2908225");
        mFirestore.collection("CircuitBr").document("84").set(cb11);

        Map<String, Object> cb12 = new HashMap<>();
        cb12.put("id", 85);
        cb12.put("tipo", 4);
        cb12.put("ul", "");
        cb12.put("nmro_polos", "");
        cb12.put("curva", "");
        cb12.put("amperaje", "");
        cb12.put("canal", "");
        cb12.put("funcion", "");
        cb12.put("accesorio", "Derivación");
        cb12.put("desc", "TMC 7/8 120VAC SHNT");
        cb12.put("nmro_parte", "2908226");
        mFirestore.collection("CircuitBr").document("85").set(cb12);

        Map<String, Object> cb13 = new HashMap<>();
        cb13.put("id", 86);
        cb13.put("tipo", 4);
        cb13.put("ul", "");
        cb13.put("nmro_polos", "");
        cb13.put("curva", "");
        cb13.put("amperaje", "");
        cb13.put("canal", "");
        cb13.put("funcion", "");
        cb13.put("accesorio", "Derivación");
        cb13.put("desc", "TMC 7/8 240VAC SHNT");
        cb13.put("nmro_parte", "2908227");
        mFirestore.collection("CircuitBr").document("86").set(cb13);

        Map<String, Object> cb14 = new HashMap<>();
        cb14.put("id", 87);
        cb14.put("tipo", 4);
        cb14.put("ul", "");
        cb14.put("nmro_polos", "");
        cb14.put("curva", "");
        cb14.put("amperaje", "");
        cb14.put("canal", "");
        cb14.put("funcion", "");
        cb14.put("accesorio", "Derivación");
        cb14.put("desc", "TMC 7/8 277VAC SHNT");
        cb14.put("nmro_parte", "2908228");
        mFirestore.collection("CircuitBr").document("87").set(cb14);

    }
}
