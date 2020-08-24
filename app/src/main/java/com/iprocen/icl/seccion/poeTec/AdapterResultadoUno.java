package com.iprocen.icl.seccion.poeTec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;

import java.util.List;

public class AdapterResultadoUno extends RecyclerView.Adapter<AdapterResultadoUno.ViewHolder>{

    private List<PoeTec> ptList;

    public AdapterResultadoUno(List<PoeTec> ptList) {
        this.ptList = ptList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_1, parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final PoeTec opc = ptList.get(position);
        holder.txtDesc.setText(opc.getDesc());
        holder.txtNmroParte.setText(opc.getNmro_parte());
        if (opc.isClasificacion()){
            holder.txtClasif.setText(R.string.condicion_extrema);
        }
    }

    @Override
    public int getItemCount() {
        return ptList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtDesc, txtNmroParte, txtClasif;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDesc = (TextView) itemView.findViewById(R.id.txt_desc1);
            txtNmroParte = (TextView) itemView.findViewById(R.id.txt_nmro1);
            txtClasif = (TextView) itemView.findViewById(R.id.txt_clasif);
            context = itemView.getContext();
        }
    }
}