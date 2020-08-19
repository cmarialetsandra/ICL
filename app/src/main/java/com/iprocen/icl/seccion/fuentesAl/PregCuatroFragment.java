package com.iprocen.icl.seccion.fuentesAl;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;

public class PregCuatroFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;
    private FloatingActionButton btn_sig;

    private ArrayList<FuentesAl> listAdapter = new ArrayList<>();

    private AdapterPregCuatro adapter;

    private String fase, s_tension, s_corriente;

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
                Bundle bundle = new Bundle();
                bundle.putString("fase", fase);
                PregCincoFragment fragment = new PregCincoFragment();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });

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
        fase = bundle.getString("fase");
        s_tension = bundle.getString("s_tension");
        s_corriente = bundle.getString("s_corriente");
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("FuentesAl").whereEqualTo("fase", fase)
                .whereEqualTo("s_tension", s_tension).whereEqualTo("s_corriente", s_corriente).addSnapshotListener(new EventListener<QuerySnapshot>() {
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
