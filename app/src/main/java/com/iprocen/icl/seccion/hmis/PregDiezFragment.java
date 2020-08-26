package com.iprocen.icl.seccion.hmis;

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

public class PregDiezFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;

    private ArrayList<Hmis> listAdapter = new ArrayList<>();
    private AdapterPregDiez adapter;

    private String pantalla, resolucion, brillo, retro_ilu, tecnologia, procesador, temperatura, proteccion, aprobacion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.result);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregDiez(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        pantalla = bundle.getString("pantalla");
        resolucion = bundle.getString("resolucion");
        brillo = bundle.getString("brillo");
        retro_ilu = bundle.getString("retro_ilu");
        tecnologia = bundle.getString("tecnologia");
        procesador = bundle.getString("procesador");
        temperatura = bundle.getString("temperatura");
        proteccion = bundle.getString("proteccion");
        aprobacion = bundle.getString("aprobacion");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("Hmis").whereEqualTo("pantalla", pantalla).whereEqualTo("resolucion", resolucion)
                .whereEqualTo("brillo",brillo).whereEqualTo("retro_ilu", retro_ilu).whereEqualTo("tecnologia", tecnologia)
                .whereEqualTo("procesador", procesador).whereEqualTo("temperatura", temperatura).whereEqualTo("proteccion", proteccion)
                .whereEqualTo("aprobacion", aprobacion)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        Hmis hmis = doc.getDocument().toObject(Hmis.class);
                        listAdapter.add(hmis);
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }
}
