package com.iprocen.icl.seccion.circuitBr.TMC;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.iprocen.icl.R;
import com.iprocen.icl.seccion.circuitBr.AdapterResultado;
import com.iprocen.icl.seccion.circuitBr.CircuitBr;

import java.util.ArrayList;

public class TMCCincoFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;
    private FloatingActionButton btn_sig;

    private ArrayList<CircuitBr> listAdapter = new ArrayList<>();
    private AdapterResultado adapter;

    private int tipo;
    private String ul, nmro_polos, curva, amperaje;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc_boton, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.result);

        btn_sig = (FloatingActionButton) view.findViewById(R.id.btn_sig);
        btn_sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccesorioFragment fragment = new AccesorioFragment();
                FragmentTransaction transaction = ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterResultado(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        tipo = bundle.getInt("tipo");
        ul = bundle.getString("ul");
        nmro_polos = bundle.getString("nmro_polos");
        curva = bundle.getString("curva");
        amperaje = bundle.getString("amperaje");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("CircuitBr").whereEqualTo("tipo", tipo).whereEqualTo("ul", ul)
                .whereEqualTo("nmro_polos", nmro_polos).whereEqualTo("curva", curva).whereEqualTo("amperaje", amperaje)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

            @Override
            public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null){
                    Log.d("Error", e.getMessage());
                }
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                    if (doc.getType() == DocumentChange.Type.ADDED){
                        CircuitBr circuitBr = doc.getDocument().toObject(CircuitBr.class);
                        listAdapter.add(circuitBr);
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });
    }

}
