package com.iprocen.icl.ui.fuentesAl;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.iprocen.icl.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FuentesAlFragment extends Fragment {

    FirebaseDatabase frDb;
    DatabaseReference dbRe;

    TextView txt_preg;
    RecyclerView recyclerView;

    private ArrayList<String> listFuentesA = new ArrayList<>();
    AdapterPregUno adapterPregUno;

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

        inicializarFirebase();

        adapterPregUno = new AdapterPregUno(listFuentesA);
        recyclerView.setAdapter(adapterPregUno);

        listarDatos();
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(getContext());
        frDb = FirebaseDatabase.getInstance();
        dbRe = frDb.getReference();
    }

    private void listarDatos(){
        dbRe.child("FuentesAl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listFuentesA.removeAll(listFuentesA);
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    FuentesAl fuentesAl = objSnapshot.getValue(FuentesAl.class);
                    listFuentesA.add(fuentesAl.getFase());
                }

                //Eliminando elementos repetidos de la lista
                Set<String> hashSet = new HashSet<String>(listFuentesA);
                listFuentesA.clear();
                listFuentesA.addAll(hashSet);

                adapterPregUno.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
