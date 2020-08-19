package com.iprocen.icl.seccion.reles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;

import java.util.List;

public class AdapterResultadoAccesorio extends RecyclerView.Adapter<AdapterResultadoAccesorio.ViewHolder>{

    private List<Rele> reList;

    public AdapterResultadoAccesorio(List<Rele> reList) {
        this.reList = reList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_3, parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Rele opc = reList.get(position);
        holder.txtDesc.setText(opc.getDesc_acc());
        holder.txtNmroParte.setText(opc.getNmro_parte_acc());
    }

    @Override
    public int getItemCount() {
        return reList.size();
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