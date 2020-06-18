package com.iprocen.icl.ui.fuentesAl;

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
import java.util.HashSet;
import java.util.Set;

public class FuentesAlFragment extends Fragment {

    FirebaseFirestore mFirestore;

    TextView txt_preg;
    RecyclerView recyclerView;

    private ArrayList<String> listFuentesA = new ArrayList<>();
    AdapterPregUno adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fuentes_al, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txt_preg = getActivity().findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg1fa);

        recyclerView = getActivity().findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregUno(listFuentesA);
        recyclerView.setAdapter(adapter);

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
                       listFuentesA.add(fuentesAl.getFase());
                   }
               }

                Set<String> hashSet = new HashSet<>(listFuentesA);
                listFuentesA.clear();
                listFuentesA.addAll(hashSet);

                adapter.notifyDataSetChanged();
            }
        });
    }

}
