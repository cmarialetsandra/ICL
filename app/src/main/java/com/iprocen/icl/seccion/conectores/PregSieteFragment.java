package com.iprocen.icl.seccion.conectores;

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

    private ArrayList<Conector> listAdapter = new ArrayList<>();
    private AdapterPregSiete adapter;

    private String heavycon, polos, tecnologia;
    private int conexion, panel, entrada;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.result);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        heavycon = bundle.getString("heavycon");
        polos = bundle.getString("polos");
        heavycon = bundle.getString("heavycon");
        polos = bundle.getString("polos");
        tecnologia = bundle.getString("tecnologia");
        conexion = bundle.getInt("conexion");
        panel = bundle.getInt("panel");
        entrada = bundle.getInt("entrada");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listarDatos();

        adapter = new AdapterPregSiete(listAdapter, conexion, panel, entrada);
        recyclerView.setAdapter(adapter);
    }

    private void listarDatos(){
        mFirestore.collection("Conectores").whereEqualTo("heavycon", heavycon).whereEqualTo("polos", polos)
                .whereEqualTo("tecnologia", tecnologia)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        Conector conector = doc.getDocument().toObject(Conector.class);
                        listAdapter.add(conector);
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });

    }

}
