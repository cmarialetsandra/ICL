package com.iprocen.icl.ui.SAI_UPS;

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

public class UPSPregCuatroFragment extends Fragment {

    FirebaseFirestore mFirestore;

    TextView txt_preg;
    RecyclerView recyclerView;

    private ArrayList<SAI_UPS> listSAI = new ArrayList<>();
    private ArrayList<SAI_UPS> listAdapter = new ArrayList<>();
    UPSAdapterPregCuatro adapter;

    private int aliment;
    private String alm_energia = "Sí";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ups4, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg_dc4);
        txt_preg.setText(R.string.pg3dc);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_dc4);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new UPSAdapterPregCuatro(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        aliment = bundle.getInt("aliment");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("SAI_UPS").whereEqualTo("aliment", aliment).whereEqualTo("alm_energia", alm_energia)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

                    @Override
                    public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                        if (e != null){
                            Log.d("Error", e.getMessage());
                        }
                        for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                            if (doc.getType() == DocumentChange.Type.ADDED){
                                SAI_UPS saiUps = doc.getDocument().toObject(SAI_UPS.class);
                                listSAI.add(saiUps);
                            }
                        }

                        for (SAI_UPS s1: listSAI){
                            for (SAI_UPS s2: listSAI){
                                if (s1.getT_alm_energia().equals(s2.getT_alm_energia())){
                                    if (agregar(s1.getT_alm_energia())){
                                        listAdapter.add(s1);
                                    }
                                }
                            }
                        }

                        adapter.notifyDataSetChanged();
                    }
                });
    }

    private boolean agregar(String valor){
        for (SAI_UPS saiUps: listAdapter){
            if (saiUps.getT_alm_energia().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
