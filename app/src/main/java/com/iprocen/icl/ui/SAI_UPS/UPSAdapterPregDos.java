package com.iprocen.icl.ui.SAI_UPS;

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

public class UPSAdapterPregDos extends RecyclerView.Adapter<UPSAdapterPregDos.ViewHolder>{

    private List<SAI_UPS> saiList;

    public UPSAdapterPregDos(List<SAI_UPS> saiList) {
        this.saiList = saiList;
    }

    @NonNull
    @Override
    public UPSAdapterPregDos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_opc, parent,false);
        UPSAdapterPregDos.ViewHolder holder = new UPSAdapterPregDos.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final UPSAdapterPregDos.ViewHolder holder, int position) {
        final SAI_UPS opc = saiList.get(position);
        holder.txtOpc.setText(opc.getSalida());
        holder.txtOpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("aliment", opc.getAliment());
                bundle.putString("alm_energia", opc.getAlm_energia());
                bundle.putString("entrada", opc.getEntrada());
                bundle.putString("salida", opc.getSalida());
                UPSPregTresFragment fragment = new UPSPregTresFragment();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) holder.context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return saiList.size();
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