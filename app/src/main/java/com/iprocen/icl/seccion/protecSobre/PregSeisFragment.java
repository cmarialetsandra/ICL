package com.iprocen.icl.seccion.protecSobre;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.iprocen.icl.R;

import java.util.ArrayList;

public class PregSeisFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;

    private ArrayList<ProtecSobre> listPS = new ArrayList<>();
    private ArrayList<ProtecSobre> listAdapter = new ArrayList<>();
    private AdapterPregSeis adapter;

    private String senial, conexion, voltaje, aterrizaje, disenio;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg6ps);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregSeis(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        senial = bundle.getString("senial");
        conexion = bundle.getString("conexion");
        voltaje = bundle.getString("voltaje");
        aterrizaje = bundle.getString("aterrizaje");
        disenio = bundle.getString("disenio");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("ProtecSobre").whereEqualTo("senial", senial).whereEqualTo("conexion", conexion)
                .whereEqualTo("voltaje", voltaje).whereEqualTo("aterrizaje", aterrizaje).whereEqualTo("disenio", disenio)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        ProtecSobre protecSobr = doc.getDocument().toObject(ProtecSobre.class);
                        listPS.add(protecSobr);
                    }
                }

                for (ProtecSobre ps1: listPS){
                    for (ProtecSobre ps2: listPS){
                        if (ps1.getMonitoreo().equals(ps2.getMonitoreo())){
                            if (agregar(ps1.getMonitoreo())){
                                listAdapter.add(ps1);
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

    private boolean agregar(String valor){
        for (ProtecSobre protecSobre: listAdapter){
            if (protecSobre.getMonitoreo().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
