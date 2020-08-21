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

public class PregCuatroFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;

    private ArrayList<SwitcheEt> listSw = new ArrayList<>();
    private ArrayList<SwitcheEt> listAdapter = new ArrayList<>();
    private AdapterPregCuatro adapter;

    private String puerto_cobre, puerto_especial, puerto_total;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg4se);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregCuatro(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        puerto_cobre = bundle.getString("puerto_cobre");
        puerto_especial = bundle.getString("puerto_especial");
        puerto_total = bundle.getString("puerto_total");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("SwitchesEt").whereEqualTo("puerto_cobre", puerto_cobre)
                .whereEqualTo("puerto_especial", puerto_especial).whereEqualTo("puerto_total", puerto_total)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        SwitcheEt switcheEt = doc.getDocument().toObject(SwitcheEt.class);
                        listSw.add(switcheEt);
                    }
                }

                for (SwitcheEt sw1: listSw){
                    for (SwitcheEt sw2: listSw){
                        if (sw1.getVelocidad().equals(sw2.getVelocidad())){
                            if (agregar(sw1.getVelocidad())){
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
        for (SwitcheEt switcheEt: listAdapter){
            if (switcheEt.getVelocidad().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
