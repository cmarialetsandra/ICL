package com.iprocen.icl.seccion.conectores;

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

    private List<Conector> coList;
    private int conexion, panel, entrada;

    public AdapterPregSiete(List<Conector> coList, int conexion, int panel, int entrada) {
        this.coList = coList;
        this.conexion = conexion;
        this.panel = panel;
        this.entrada = entrada;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_5, parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Conector opc = coList.get(position);
        if (conexion == 1){
            holder.txtDesc.setText(opc.getDesc_m());
            holder.txtNmroParte.setText(opc.getNmro_parte_m());
        }else if(conexion == 2){
            holder.txtDesc.setText(opc.getDesc_f());
            holder.txtNmroParte.setText(opc.getNmro_parte_f());
        }

        if (panel == 1){
            holder.txtBase.setText(opc.getCubierta_c());
        }else if (panel == 2){
            holder.txtBase.setText(opc.getCubierta_s());
        }

        if (entrada == 1){
            holder.txtBajo.setText(opc.getSuperior_bajo());
            holder.txtAlto.setText(opc.getSuperior_alto());
        }else if (entrada == 2){
            holder.txtBajo.setText(opc.getLateral_bajo());
            holder.txtAlto.setText(opc.getLateral_alto());
        }
    }

    @Override
    public int getItemCount() {
        return coList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtDesc, txtNmroParte, txtBase, txtBajo, txtAlto;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDesc = (TextView) itemView.findViewById(R.id.txt_desc);
            txtNmroParte = (TextView) itemView.findViewById(R.id.txt_nmro);
            txtBase = (TextView) itemView.findViewById(R.id.txt_base);
            txtBajo = (TextView) itemView.findViewById(R.id.txt_bajo);
            txtAlto = (TextView) itemView.findViewById(R.id.txt_alto);
            context = itemView.getContext();
        }
    }
}