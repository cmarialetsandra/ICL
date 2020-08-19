package com.iprocen.icl.seccion.SAI_UPS;

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

public class UPSPregTresFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;
    private FloatingActionButton btn_sig;

    private ArrayList<SAI_UPS> listAdapter = new ArrayList<>();
    private UPSAdapterPregTres adapter;

    private int aliment;
    private String alm_energia, entrada, salida;

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
                bundle.putInt("aliment", aliment);
                UPSPregCuatroFragment fragment = new UPSPregCuatroFragment();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new UPSAdapterPregTres(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        aliment = bundle.getInt("aliment");
        alm_energia = bundle.getString("alm_energia");
        entrada = bundle.getString("entrada");
        salida = bundle.getString("salida");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("SAI_UPS").whereEqualTo("aliment", aliment).whereEqualTo("alm_energia", alm_energia)
                .whereEqualTo("entrada", entrada).whereEqualTo("salida", salida)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

                    @Override
                    public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                        if (e != null){
                            Log.d("Error", e.getMessage());
                        }
                        for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                            if (doc.getType() == DocumentChange.Type.ADDED){
                                SAI_UPS saiUps = doc.getDocument().toObject(SAI_UPS.class);
                                listAdapter.add(saiUps);
                            }
                        }

                        adapter.notifyDataSetChanged();
                    }
                });
    }

}
