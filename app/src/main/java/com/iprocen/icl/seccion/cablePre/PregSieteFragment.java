package com.iprocen.icl.seccion.cablePre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.iprocen.icl.R;
import com.iprocen.icl.seccion.conectores.PregCincoFragment;

public class PregSieteFragment extends Fragment {

    private TextView txt_preg;
    private Button btn_opc1, btn_opc2;

    private String tamanio, posicion, tipo, orientacion, longitud;
    private int chaqueta;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc_2boton, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg7ca);

        btn_opc1 = (Button) view.findViewById(R.id.btn_opc1);
        btn_opc1.setText(R.string.blindado);
        btn_opc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambioFragment(1);
            }
        });

        btn_opc2 = (Button) view.findViewById(R.id.btn_opc2);
        btn_opc2.setText(R.string.no_blindado);
        btn_opc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambioFragment(2);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        tamanio = bundle.getString("tamanio");
        posicion = bundle.getString("posicion");
        tipo = bundle.getString("tipo");
        orientacion = bundle.getString("orientacion");
        longitud = bundle.getString("longitud");
        chaqueta = bundle.getInt("chaqueta");
    }

    private void cambioFragment(int cmat){
        Bundle bundle = new Bundle();
        bundle.putString("tamanio", tamanio);
        bundle.putString("posicion", posicion);
        bundle.putString("tipo", tipo);
        bundle.putString("orientacion", orientacion);
        bundle.putString("longitud", longitud);
        bundle.putInt("chaqueta", chaqueta);
        bundle.putInt("cmat", cmat);
        PregOchoFragment fragment = new PregOchoFragment();
        fragment.setArguments(bundle);
        FragmentTransaction transaction = ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
        transaction.commit();
    }

}
