package com.iprocen.icl.seccion.reles;

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

public class PregDosFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;

    private ArrayList<Rele> listRe = new ArrayList<>();
    private ArrayList<Rele> listAdapter = new ArrayList<>();
    private AdapterPregDos adapter;

    private int tipo;
    private String tipo_rele;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg2re);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregDos(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        tipo = bundle.getInt("tipo");
        tipo_rele = bundle.getString("tipo_rele");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("Reles").whereEqualTo("tipo", tipo).whereEqualTo("tipo_rele", tipo_rele)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        Rele rele = doc.getDocument().toObject(Rele.class);
                        listRe.add(rele);
                    }
                }

                for (Rele re1: listRe){
                    for (Rele re2: listRe){
                        if (re1.getVoltaje().equals(re2.getVoltaje())){
                            if (agregar(re1.getVoltaje())){
                                listAdapter.add(re1);
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

    private boolean agregar(String valor){
        for (Rele rele: listAdapter){
            if (rele.getVoltaje().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
