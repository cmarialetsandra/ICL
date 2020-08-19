package com.iprocen.icl.seccion.fuentesAl;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.iprocen.icl.R;

import java.util.ArrayList;

public class FuentesAlFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;

    private ArrayList<FuentesAl> listFuentesA = new ArrayList<>();
    private ArrayList<FuentesAl> listAdapter = new ArrayList<>();
    private AdapterPregUno adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg1fa);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregUno(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("FuentesAl").addSnapshotListener(new EventListener<QuerySnapshot>() {


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
                       if (f1.getFase().equals(f2.getFase())){
                            if (agregar(f1.getFase())){
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
            if (fuentesAl.getFase().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
