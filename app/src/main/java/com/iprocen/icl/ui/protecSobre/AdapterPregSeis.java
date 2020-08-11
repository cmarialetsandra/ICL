package com.iprocen.icl.ui.protecSobre;

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

public class AdapterPregSeis extends RecyclerView.Adapter<AdapterPregSeis.ViewHolder>{

    List<ProtecSobre> psList;

    public AdapterPregSeis(List<ProtecSobre> psList) {
        this.psList = psList;
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
        final ProtecSobre opc = psList.get(position);
        holder.txtOpc.setText(opc.getMonitoreo());
        holder.txtOpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("senial", opc.getSenial());
                bundle.putString("conexion", opc.getConexion());
                bundle.putString("voltaje", opc.getVoltaje());
                bundle.putString("aterrizaje", opc.getAterrizaje());
                bundle.putString("disenio", opc.getDisenio());
                bundle.putString("monitoreo", opc.getMonitoreo());
                PregSieteFragment fragment = new PregSieteFragment();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) holder.context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return psList.size();
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