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
        Map<String, Object> ins1 = new HashMap<>();
        ins1.put("id", 2);
        ins1.put("tipo", 1);
        ins1.put("material", "");
        ins1.put("campo1", "");
        ins1.put("campo2", "");
        ins1.put("campo3", "");
        ins1.put("desc", "");
        ins1.put("nmro_parte", "");
        mFirestore.collection("Marcaje").document("2").set(ins1);
    }
}
