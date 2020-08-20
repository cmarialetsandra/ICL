package com.iprocen.icl.seccion.conectores;

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
import com.iprocen.icl.seccion.circuitBr.CanalFragment;
import com.iprocen.icl.seccion.circuitBr.TMC.TMCFragment;

public class PregCincoFragment extends Fragment {

    private TextView txt_preg;
    private Button btn_opc1, btn_opc2;

    private String heavycon, polos, tecnologia;
    private int conexion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc_2boton, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg5co);

        btn_opc1 = (Button) view.findViewById(R.id.btn_opc1);
        btn_opc1.setText(R.string.cubierta_c);
        btn_opc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambioFragment(1);
            }
        });

        btn_opc2 = (Button) view.findViewById(R.id.btn_opc2);
        btn_opc2.setText(R.string.cubierta_s);
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
        heavycon = bundle.getString("heavycon");
        polos = bundle.getString("polos");
        tecnologia = bundle.getString("tecnologia");
        conexion = bundle.getInt("conexion");
    }

    private void cambioFragment(int panel){
        Bundle bundle = new Bundle();
        bundle.putString("heavycon", heavycon);
        bundle.putString("polos", polos);
        bundle.putString("tecnologia", tecnologia);
        bundle.putInt("conexion", conexion);
        bundle.putInt("panel", panel);
        PregSeisFragment fragment = new PregSeisFragment();
        fragment.setArguments(bundle);
        FragmentTransaction transaction = ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
        transaction.commit();
    }

}
