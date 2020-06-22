package com.iprocen.icl.ui.fuentesAl;

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

    FirebaseFirestore mFirestore;

    TextView txt_preg;
    RecyclerView recyclerView;

    private ArrayList<FuentesAl> listFuentesA = new ArrayList<>();
    private ArrayList<FuentesAl> listAdapter = new ArrayList<>();

    AdapterPregDos adapter;

    String fase;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fuentes_al, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        fase = bundle.getString("fase");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txt_preg = getActivity().findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg2fa);

        recyclerView = getActivity().findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregDos(listAdapter);
        recyclerView.setAdapter(adapter);

        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("FuentesAl").whereEqualTo("fase", fase)
                .whereEqualTo("protect_sobre", "No").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        FuentesAl fuentesAl = doc.getDocument().toObject(FuentesAl.class);
                        listFuentesA.add(fuentesAl);
                    }
                }

                for (FuentesAl f1: listFuentesA){
                    for (FuentesAl f2: listFuentesA){
                        if (f1.getS_tension().equals(f2.getS_tension())){
                            if (agregar(f1.getS_tension())){
                                listAdapter.add(f1);
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

    private boolean agregar(String valor){
        for (FuentesAl fuentesAl: listAdapter){
            if (fuentesAl.getS_tension().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
