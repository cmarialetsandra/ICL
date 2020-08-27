package com.iprocen.icl.seccion.marcaje;

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

public class MarcajeFragment extends Fragment {

    private TextView txt_preg;
    private Button btn_opc1, btn_opc2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opc_2boton, container, false);

        txt_preg = (TextView) view.findViewById(R.id.txt_preg);
        txt_preg.setText(R.string.pg1ma);

        btn_opc1 = (Button) view.findViewById(R.id.btn_opc1);
        btn_opc1.setText(R.string.menu_marcaje);
        btn_opc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("tipo", 1);
                PregDosFragment fragment = new PregDosFragment();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });

        btn_opc2 = (Button) view.findViewById(R.id.btn_opc2);
        btn_opc2.setText(R.string.impresora);
        btn_opc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("tipo", 2);
                bundle.putString("material", "");
                PregTresFragment fragment = new PregTresFragment();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });

        return view;
    }
}
