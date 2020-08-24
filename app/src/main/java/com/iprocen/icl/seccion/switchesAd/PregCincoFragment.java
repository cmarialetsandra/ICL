package com.iprocen.icl.seccion.switchesAd;

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

    private ArrayList<SwitchesAd> listSw = new ArrayList<>();
    private ArrayList<SwitchesAd> listAdapter = new ArrayList<>();
    private AdapterPregCinco adapter;

    private String puerto_cobre, puerto_fibra, puerto_combinado, velocidad;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg4sa);

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
        puerto_cobre = bundle.getString("puerto_cobre");
        puerto_fibra = bundle.getString("puerto_fibra");
        puerto_combinado = bundle.getString("puerto_combinado");
        velocidad = bundle.getString("velocidad");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("SwitchesAd").whereEqualTo("puerto_cobre", puerto_cobre)
                .whereEqualTo("puerto_fibra", puerto_fibra).whereEqualTo("puerto_combinado", puerto_combinado)
                .whereEqualTo("velocidad", velocidad)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        SwitchesAd switchesAd = doc.getDocument().toObject(SwitchesAd.class);
                        listSw.add(switchesAd);
                    }
                }

                for (SwitchesAd sw1: listSw){
                    for (SwitchesAd sw2: listSw){
                        if (sw1.getCaracteristica().equals(sw2.getCaracteristica())){
                            if (agregar(sw1.getCaracteristica())){
                                listAdapter.add(sw1);
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

    private boolean agregar(String valor){
        for (SwitchesAd switchesAd: listAdapter){
            if (switchesAd.getCaracteristica().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
