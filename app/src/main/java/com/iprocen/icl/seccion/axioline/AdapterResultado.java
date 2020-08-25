package com.iprocen.icl.seccion.axioline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;

import java.util.List;

public class AdapterResultado extends RecyclerView.Adapter<AdapterResultado.ViewHolder>{

    private List<Axioline> axList;

    public AdapterResultado(List<Axioline> axList) {
        this.axList = axList;
    }

    @NonNull
    @Override
    public AdapterResultado.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_7, parent,false);
        AdapterResultado.ViewHolder holder = new AdapterResultado.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterResultado.ViewHolder holder, int position) {
        final Axioline opc = axList.get(position);
        holder.txtDesc.setText(opc.getDesc());
        holder.txtDesig.setText(opc.getDesig());
        holder.txtNmroParte.setText(opc.getNmro_parte());
    }

    @Override
    public int getItemCount() {
        return axList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtDesc, txtDesig, txtNmroParte;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDesc = (TextView) itemView.findViewById(R.id.txt_desc1);
            txtDesig = (TextView) itemView.findViewById(R.id.txt_desig1);
            txtNmroParte = (TextView) itemView.findViewById(R.id.txt_nmro1);
            context = itemView.getContext();
        }
    }
}