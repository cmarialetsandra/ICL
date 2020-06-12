package com.iprocen.icl;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.iprocen.icl.ui.fuentesAl.FuentesAl;

public class Agregar extends Fragment {

    EditText txt_id, txt_fase, txt_s_tension, txt_s_corriente, txt_clasific, txt_desc, txt_nmro_parte,
            txt_protect_sobre, txt_voltaje, txt_corriente;

    Button btn_guardar;

    FirebaseDatabase frDb;
    DatabaseReference dbRe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agregar, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txt_id = getActivity().findViewById(R.id.txt_id);
        txt_fase = getActivity().findViewById(R.id.txt_fase);
        txt_s_tension = getActivity().findViewById(R.id.txt_s_tension);
        txt_s_corriente = getActivity().findViewById(R.id.txt_s_corriente);
        txt_clasific = getActivity().findViewById(R.id.txt_clasific);
        txt_desc = getActivity().findViewById(R.id.txt_desc);
        txt_nmro_parte = getActivity().findViewById(R.id.txt_nmro_parte);
        txt_protect_sobre = getActivity().findViewById(R.id.txt_protect_sobre);
        txt_voltaje = getActivity().findViewById(R.id.txt_voltaje);
        txt_corriente = getActivity().findViewById(R.id.txt_corriente);
        btn_guardar = getActivity().findViewById(R.id.btn_guardar);

        inicializarFirebase();

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregar();
            }
        });
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(getContext());
        frDb = FirebaseDatabase.getInstance();
        dbRe = frDb.getReference();
    }

    private void agregar(){
        String id = txt_id.getText().toString();
        String fase = txt_fase.getText().toString();
        String s_tension = txt_s_tension.getText().toString();
        String s_corriente = txt_s_corriente.getText().toString();
        String clasific = txt_clasific.getText().toString();
        String desc = txt_desc.getText().toString();
        String nmro_parte = txt_nmro_parte.getText().toString();
        String protect_sobre = txt_protect_sobre.getText().toString();
        String voltaje = txt_voltaje.getText().toString();
        String corriente = txt_corriente.getText().toString();

        FuentesAl fuentesAl = new FuentesAl();
        fuentesAl.setId(id);
        fuentesAl.setFase(fase);
        fuentesAl.setS_tension(s_tension);
        fuentesAl.setS_corriente(s_corriente);
        fuentesAl.setClasific(clasific);
        fuentesAl.setDesc(desc);
        fuentesAl.setNmro_parte(nmro_parte);
        fuentesAl.setProtect_sobre(protect_sobre);
        fuentesAl.setVoltaje(voltaje);
        fuentesAl.setCorriente(corriente);

        dbRe.child("FuentesAl").child(fuentesAl.getId()).setValue(fuentesAl);

        limpiar();
    }

    private void limpiar(){
        txt_id.setText("");
        txt_fase.setText("");
        txt_s_tension.setText("");
        txt_s_corriente.setText("");
        txt_clasific.setText("");
        txt_desc.setText("");
        txt_nmro_parte.setText("");
        txt_protect_sobre.setText("");
        txt_voltaje.setText("");
        txt_corriente.setText("");
    }
}
