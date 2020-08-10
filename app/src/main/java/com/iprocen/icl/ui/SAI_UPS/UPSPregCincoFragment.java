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

public class UPSPregCincoFragment extends Fragment {

    FirebaseFirestore mFirestore;

    TextView txt_preg;
    RecyclerView recyclerView;

    private ArrayList<SAI_UPS> listAdapter = new ArrayList<>();
    UPSAdapterPregCinco adapter;

    private int aliment;
    private String t_alm_energia;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ups5, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg_dc5);
        txt_preg.setText(R.string.result);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_dc5);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new UPSAdapterPregCinco(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        aliment = bundle.getInt("aliment");
        t_alm_energia = bundle.getString("t_alm_energia");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("SAI_UPS").whereEqualTo("aliment", aliment).whereEqualTo("t_alm_energia", t_alm_energia)
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
