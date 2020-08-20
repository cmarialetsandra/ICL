package com.iprocen.icl.seccion.cablePre;

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

public class PregCincoFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;

    private ArrayList<CablePre> listCa = new ArrayList<>();
    private ArrayList<CablePre> listAdapter = new ArrayList<>();
    private AdapterPregCinco adapter;

    private String tamanio, posicion, tipo, orientacion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg5ca);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregCinco(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        tamanio = bundle.getString("tamanio");
        posicion = bundle.getString("posicion");
        tipo = bundle.getString("tipo");
        orientacion = bundle.getString("orientacion");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("CablePre").whereEqualTo("tamanio", tamanio).whereEqualTo("posicion", posicion)
                .whereEqualTo("tipo", tipo).whereEqualTo("orientacion", orientacion)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        CablePre cablePre = doc.getDocument().toObject(CablePre.class);
                        listCa.add(cablePre);
                    }
                }

                for (CablePre ca1: listCa){
                    for (CablePre ca2: listCa){
                        if (ca1.getLongitud().equals(ca2.getLongitud())){
                            if (agregar(ca1.getLongitud())){
                                listAdapter.add(ca1);
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

    private boolean agregar(String valor){
        for (CablePre cablePre: listAdapter){
            if (cablePre.getLongitud().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
