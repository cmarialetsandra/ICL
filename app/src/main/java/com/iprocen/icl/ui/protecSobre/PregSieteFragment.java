package com.iprocen.icl.ui.protecSobre;

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

    FirebaseFirestore mFirestore;

    TextView txt_preg;
    RecyclerView recyclerView;

    private ArrayList<ProtecSobre> listAdapter = new ArrayList<>();
    AdapterPregSiete adapter;

    private String senial, conexion, voltaje, aterrizaje, disenio, monitoreo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_protec_sobre, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg_ps);
        txt_preg.setText(R.string.result);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_ps);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregSiete(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        senial = bundle.getString("senial");
        conexion = bundle.getString("conexion");
        voltaje = bundle.getString("voltaje");
        aterrizaje = bundle.getString("aterrizaje");
        disenio = bundle.getString("disenio");
        monitoreo = bundle.getString("monitoreo");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("ProtecSobre").whereEqualTo("senial", senial).whereEqualTo("conexion", conexion)
                .whereEqualTo("voltaje", voltaje).whereEqualTo("aterrizaje", aterrizaje).whereEqualTo("disenio", disenio)
                .whereEqualTo("monitoreo", monitoreo)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        ProtecSobre protecSobr = doc.getDocument().toObject(ProtecSobre.class);
                        listAdapter.add(protecSobr);
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

}
