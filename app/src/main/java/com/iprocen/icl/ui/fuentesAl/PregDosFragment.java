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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.iprocen.icl.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PregDosFragment extends Fragment {

    FirebaseDatabase frDb;
    DatabaseReference dbRe;

    TextView txt_preg;
    RecyclerView recyclerView;

    private ArrayList<String> listFuentesA = new ArrayList<>();
    AdapterPregDos adapterPregDos;

    String fase;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fuentes_al, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        fase = bundle.getString("fase");
        Log.e("fase", fase);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txt_preg = getActivity().findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg2fa);

        recyclerView = getActivity().findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        inicializarFirebase();

        adapterPregDos = new AdapterPregDos(listFuentesA);
        recyclerView.setAdapter(adapterPregDos);

        listarDatos();
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(getContext());
        frDb = FirebaseDatabase.getInstance();
        dbRe = frDb.getReference();
    }

    private void listarDatos(){
        Query q = dbRe.child("FuentesAl").orderByChild("fase").equalTo(fase);
        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    FuentesAl fuentesAl = objSnapshot.getValue(FuentesAl.class);
                    listFuentesA.add(fuentesAl.getS_tension());
                    Log.e("s_tension", fuentesAl.getS_tension());
                }

                //Eliminando elementos repetidos de la lista
                Set<String> hashSet = new HashSet<String>(listFuentesA);
                listFuentesA.clear();
                listFuentesA.addAll(hashSet);

                adapterPregDos.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        /*dbRe.child("FuentesAl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listFuentesA.removeAll(listFuentesA);
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    FuentesAl fuentesAl = objSnapshot.getValue(FuentesAl.class);
                    listFuentesA.add(fuentesAl.getS_tension());
                }

                //Eliminando elementos repetidos de la lista
                Set<String> hashSet = new HashSet<String>(listFuentesA);
                listFuentesA.clear();
                listFuentesA.addAll(hashSet);

                adapterPregDos.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
    }

}
