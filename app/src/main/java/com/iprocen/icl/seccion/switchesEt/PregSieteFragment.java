package com.iprocen.icl.seccion.switchesEt;

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

public class PregSieteFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;

    private ArrayList<SwitcheEt> listAdapter = new ArrayList<>();
    private AdapterPregSiete adapter;

    private String puerto_cobre, puerto_especial, puerto_total, velocidad, alimentacion, area;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.result);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregSiete(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        puerto_cobre = bundle.getString("puerto_cobre");
        puerto_especial = bundle.getString("puerto_especial");
        puerto_total = bundle.getString("puerto_total");
        velocidad = bundle.getString("velocidad");
        alimentacion = bundle.getString("alimentacion");
        area = bundle.getString("area");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("SwitchesEt").whereEqualTo("puerto_cobre", puerto_cobre)
                .whereEqualTo("puerto_especial", puerto_especial).whereEqualTo("puerto_total", puerto_total)
                .whereEqualTo("velocidad", velocidad).whereEqualTo("alimentacion", alimentacion).whereEqualTo("area", area)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        SwitcheEt switcheEt = doc.getDocument().toObject(SwitcheEt.class);
                        listAdapter.add(switcheEt);
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

}
