package com.iprocen.icl.seccion.hmis;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;

import java.util.List;

public class AdapterPregNueve extends RecyclerView.Adapter<AdapterPregNueve.ViewHolder>{

    private List<Hmis> hmList;

    public AdapterPregNueve(List<Hmis> hmList) {
        this.hmList = hmList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_opc, parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Hmis opc = hmList.get(position);
        holder.txtOpc.setText(opc.getAprobacion());
        holder.txtOpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("pantalla", opc.getPantalla());
                bundle.putString("resolucion", opc.getResolucion());
                bundle.putString("brillo", opc.getBrillo());
                bundle.putString("retro_ilu", opc.getRetro_ilu());
                bundle.putString("tecnologia", opc.getTecnologia());
                bundle.putString("procesador", opc.getProcesador());
                bundle.putString("temperatura", opc.getTemperatura());
                bundle.putString("proteccion", opc.getProteccion());
                bundle.putString("aprobacion", opc.getAprobacion());
                PregDiezFragment fragment = new PregDiezFragment();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) holder.context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return hmList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtOpc;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtOpc = (TextView) itemView.findViewById(R.id.txt_opc);
            context = itemView.getContext();
        }
    }
}