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
        Map<String, Object> as1 = new HashMap<>();
        as1.put("id", 17);
        as1.put("conversion", "Conversión de señal especiales y aislamiento");
        as1.put("aliment", "Estándar");
        as1.put("entrada", "4-20 mA/HART");
        as1.put("salida", "2x 4-20mA/HART");
        as1.put("desc", "MINI MCR-2-RPSS-I-2I");
        as1.put("nmro_parte", "2905628");
        mFirestore.collection("AcondiSe").document("17").set(as1);
    }

}
