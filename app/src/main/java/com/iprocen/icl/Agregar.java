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
        /*Map<String, Object> bo1 = new HashMap<>();
        bo1.put("id", 37);
        bo1.put("tipo_conex", "Resorte (ST)");
        bo1.put("awg", "28-12");
        bo1.put("l_max", "20");
        bo1.put("puntos_conex", "2");
        bo1.put("desc", "ST 2.5");
        bo1.put("nmro_parte", "3031212");
        bo1.put("tapa", "3030417");
        bo1.put("puente", "3030161");
        bo1.put("destornillador", "1204517");
        bo1.put("etiq_lado", "0828744");
        bo1.put("etiq_sup", "0828734");
        mFirestore.collection("Borneras").document("37").set(bo1);*/

    }
}
