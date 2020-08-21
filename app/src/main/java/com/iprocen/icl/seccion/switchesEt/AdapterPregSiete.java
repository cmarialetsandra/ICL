package com.iprocen.icl.seccion.switchesEt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;
import com.iprocen.icl.seccion.fuentesAl.FuentesAl;

import java.util.List;

public class AdapterPregSiete extends RecyclerView.Adapter<AdapterPregSiete.ViewHolder>{

    private List<SwitcheEt> swList;

    public AdapterPregSiete(List<SwitcheEt> swList) {
        this.swList = swList;
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
        final SwitcheEt opc = swList.get(position);
        holder.txtDesc.setText(opc.getDesc());
        holder.txtNmroParte.setText(opc.getNmro_parte());
        if (opc.isCondicion()){
            holder.txtClasif.setText(R.string.condicion_extrema);
        }else{
            holder.txtClasif.setText(R.string.no_condicion_extrema);
        }
    }

    @Override
    public int getItemCount() {
        return swList.size();
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
