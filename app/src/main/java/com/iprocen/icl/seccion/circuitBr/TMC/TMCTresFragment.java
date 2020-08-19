package com.iprocen.icl.seccion.circuitBr.TMC;

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
import com.iprocen.icl.seccion.circuitBr.CircuitBr;

import java.util.ArrayList;

public class TMCTresFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;

    private ArrayList<CircuitBr> listCB = new ArrayList<>();
    private ArrayList<CircuitBr> listAdapter = new ArrayList<>();
    private AdapterTMCPregTres adapter;

    private int tipo;
    private String ul, nmro_polos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg6cb);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterTMCPregTres(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        tipo = bundle.getInt("tipo");
        ul = bundle.getString("ul");
        nmro_polos = bundle.getString("nmro_polos");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("CircuitBr").whereEqualTo("tipo", tipo).whereEqualTo("ul", ul)
                .whereEqualTo("nmro_polos", nmro_polos)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        CircuitBr circuitBr = doc.getDocument().toObject(CircuitBr.class);
                        listCB.add(circuitBr);
                    }
                }

                for (CircuitBr cb1: listCB){
                    for (CircuitBr cb2: listCB){
                        if (cb1.getCurva().equals(cb2.getCurva())){
                            if (agregar(cb1.getCurva())){
                                listAdapter.add(cb1);
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

    private boolean agregar(String valor){
        for (CircuitBr circuitBr: listAdapter){
            if (circuitBr.getCurva().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
