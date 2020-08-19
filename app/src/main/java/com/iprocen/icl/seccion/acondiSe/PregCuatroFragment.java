package com.iprocen.icl.seccion.acondiSe;

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

    private ArrayList<AcondiSe> listAS = new ArrayList<>();
    private ArrayList<AcondiSe> listAdapter = new ArrayList<>();
    private AdapterPregCuatro adapter;

    private String conversion, aliment, entrada;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg4as);

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
        conversion = bundle.getString("conversion");
        aliment = bundle.getString("aliment");
        entrada = bundle.getString("entrada");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("AcondiSe").whereEqualTo("conversion", conversion).whereEqualTo("aliment", aliment)
                .whereEqualTo("entrada", entrada)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        AcondiSe acondiSe = doc.getDocument().toObject(AcondiSe.class);
                        listAS.add(acondiSe);
                    }
                }

                for (AcondiSe as1: listAS){
                    for (AcondiSe as2: listAS){
                        if (as1.getSalida().equals(as2.getSalida())){
                            if (agregar(as1.getSalida())){
                                listAdapter.add(as1);
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

    private boolean agregar(String valor){
        for (AcondiSe acondiSe: listAdapter){
            if (acondiSe.getSalida().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
