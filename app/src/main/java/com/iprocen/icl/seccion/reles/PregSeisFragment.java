package com.iprocen.icl.seccion.reles;

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

public class PregSeisFragment extends Fragment {

    private FirebaseFirestore mFirestore;

    private TextView txt_preg;
    private RecyclerView recyclerView;
    private FloatingActionButton btn_sig;

    private ArrayList<Rele> listAdapter = new ArrayList<>();
    private AdapterResultado adapter;

    private int tipo;
    private String tipo_rele, voltaje, salida, contacto, conexion, accesorio;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc_boton, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.result);

        btn_sig = (FloatingActionButton) view.findViewById(R.id.btn_sig);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mFirestore = FirebaseFirestore.getInstance();

        adapter = new AdapterResultado(listAdapter);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        tipo = bundle.getInt("tipo");
        tipo_rele = bundle.getString("tipo_rele");
        voltaje = bundle.getString("voltaje");
        salida = bundle.getString("salida");
        contacto = bundle.getString("contacto");
        conexion = bundle.getString("conexion");
        accesorio = bundle.getString("accesorio");

        if (accesorio.equals("No")){
            btn_sig.setVisibility(View.GONE);
        }else{
            btn_sig.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("tipo", tipo);
                    bundle.putString("tipo_rele", tipo_rele);
                    bundle.putString("voltaje", voltaje);
                    bundle.putString("salida", salida);
                    bundle.putString("contacto", contacto);
                    bundle.putString("conexion", conexion);
                    bundle.putString("accesorio", accesorio);
                    PregSieteFragment fragment = new PregSieteFragment();
                    fragment.setArguments(bundle);
                    FragmentTransaction transaction = ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                    transaction.commit();
                }
            });
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listarDatos();
    }

    private void listarDatos(){
        mFirestore.collection("Reles").whereEqualTo("tipo", tipo).whereEqualTo("tipo_rele", tipo_rele)
                .whereEqualTo("voltaje", voltaje).whereEqualTo("salida", salida).whereEqualTo("contacto", contacto)
                .whereEqualTo("conexion", conexion)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {

                    @Override
                    public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirebaseFirestoreException e) {
                        if (e != null){
                            Log.d("Error", e.getMessage());
                        }
                        for(DocumentChange doc: documentSnapshots.getDocumentChanges()){
                            if (doc.getType() == DocumentChange.Type.ADDED){
                                Rele rele = doc.getDocument().toObject(Rele.class);
                                listAdapter.add(rele);
                            }
                        }

                        adapter.notifyDataSetChanged();
                    }
                });
    }

}
