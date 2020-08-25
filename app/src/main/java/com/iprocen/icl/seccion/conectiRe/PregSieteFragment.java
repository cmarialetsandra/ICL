package com.iprocen.icl.seccion.conectiRe;

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

    private ArrayList<ConectiRe> listCo = new ArrayList<>();
    private ArrayList<ConectiRe> listAdapter = new ArrayList<>();
    private AdapterPregSiete adapter;

    private String c1d2, lan, temp, mguard, memoria, firewall;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg7crs);

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
        c1d2 = bundle.getString("c1d2");
        lan = bundle.getString("lan");
        temp = bundle.getString("temp");
        mguard = bundle.getString("mguard");
        memoria = bundle.getString("memoria");
        firewall = bundle.getString("firewall");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("ConectiRe").whereEqualTo("c1d2", c1d2).whereEqualTo("lan", lan).whereEqualTo("temp", temp)
                .whereEqualTo("mguard", mguard).whereEqualTo("memoria", memoria).whereEqualTo("firewall", firewall)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        ConectiRe conectiRe = doc.getDocument().toObject(ConectiRe.class);
                        listCo.add(conectiRe);
                    }
                }

                for (ConectiRe co1: listCo){
                    for (ConectiRe co2: listCo){
                        if (co1.getVpn().equals(co2.getVpn())){
                            if (agregar(co1.getVpn())){
                                listAdapter.add(co1);
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

    private boolean agregar(String valor){
        for (ConectiRe conectiRe: listAdapter){
            if (conectiRe.getVpn().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
