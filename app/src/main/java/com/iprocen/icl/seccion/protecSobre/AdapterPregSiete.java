package com.iprocen.icl.seccion.protecSobre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;

import java.util.List;

public class AdapterPregSiete extends RecyclerView.Adapter<AdapterPregSiete.ViewHolder>{

    private List<ProtecSobre> psList;

    public AdapterPregSiete(List<ProtecSobre> psList) {
        this.psList = psList;
    }

    @NonNull
    @Override
    public AdapterPregSiete.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_3, parent,false);
        AdapterPregSiete.ViewHolder holder = new AdapterPregSiete.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterPregSiete.ViewHolder holder, int position) {
        final ProtecSobre opc = psList.get(position);
        holder.txtDesc.setText(opc.getDesc());
        holder.txtNmroParte.setText(opc.getNmro_parte());
    }

    @Override
    public int getItemCount() {
        return psList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtDesc, txtNmroParte;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDesc = (TextView) itemView.findViewById(R.id.txt_desc1);
            txtNmroParte = (TextView) itemView.findViewById(R.id.txt_nmro1);
            context = itemView.getContext();
        }
    }
}