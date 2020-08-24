package com.iprocen.icl.seccion.poeTec;

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

public class PregSeisFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;

    private ArrayList<PoeTec> listPT = new ArrayList<>();
    private ArrayList<PoeTec> listAdapter = new ArrayList<>();
    private AdapterPregSeis adapter;

    private int tipo;
    private String campo1, campo2, campo3, campo4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregSeis(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        tipo = bundle.getInt("tipo");
        switch (tipo){
            case 1:
                txt_preg.setText(R.string.pg6poe);
                break;
            case 2:
                txt_preg.setText(R.string.pg12poe);
                break;
            case 3:
                txt_preg.setText(R.string.pg16poe);
                break;
        }

        campo1 = bundle.getString("campo1");
        campo2 = bundle.getString("campo2");
        campo3 = bundle.getString("campo3");
        campo4 = bundle.getString("campo4");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("PoeTec").whereEqualTo("tipo", tipo).whereEqualTo("campo1", campo1)
                .whereEqualTo("campo2", campo2).whereEqualTo("campo3", campo3).whereEqualTo("campo4", campo4)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        PoeTec poeTec = doc.getDocument().toObject(PoeTec.class);
                        listPT.add(poeTec);
                    }
                }

                for (PoeTec pt1: listPT){
                    for (PoeTec pt2: listPT){
                        if (pt1.getCampo5().equals(pt2.getCampo5())){
                            if (agregar(pt1.getCampo5())){
                                listAdapter.add(pt1);
                            }
                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

    private boolean agregar(String valor){
        for (PoeTec poeTec: listAdapter){
            if (poeTec.getCampo5().equals(valor)){
                return false;
            }
        }
        return true;
    }
}
