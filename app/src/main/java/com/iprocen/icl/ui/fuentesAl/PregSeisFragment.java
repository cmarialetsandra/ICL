package com.iprocen.icl.ui.fuentesAl;

import android.annotation.SuppressLint;
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.iprocen.icl.R;

import java.util.ArrayList;

public class PregSeisFragment extends Fragment {

    FirebaseFirestore mFirestore;

    TextView txt_preg;
    RecyclerView recyclerView;

    private ArrayList<FuentesAl> listAdapter = new ArrayList<>();

    AdapterPregSeis adapter;

    String fase, voltaje;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fuentes_al, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        fase = bundle.getString("fase");
        voltaje = bundle.getString("voltaje");
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        txt_preg = getActivity().findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.result);

        recyclerView = getActivity().findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterPregSeis(listAdapter);
        recyclerView.setAdapter(adapter);

        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("FuentesAl").whereEqualTo("fase", fase)
                .whereEqualTo("voltaje", voltaje).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        FuentesAl fuentesAl = doc.getDocument().toObject(FuentesAl.class);
                        listAdapter.add(fuentesAl);
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

}
