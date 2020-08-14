package com.iprocen.icl.ui.borneras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;

import java.util.List;

public class AdapterPregCinco extends RecyclerView.Adapter<AdapterPregCinco.ViewHolder>{

    private List<Bornera> boList;

    public AdapterPregCinco(List<Bornera> boList) {
        this.boList = boList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_4, parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Bornera opc = boList.get(position);
        holder.txtDesc.setText(opc.getDesc());
        holder.txtNmroParte.setText(opc.getNmro_parte());
        holder.txtTapa.setText(opc.getTapa());
        holder.txtPuente.setText(opc.getPuente());
        holder.txtDestornillador.setText(opc.getDestornillador());
        holder.txtSuperior.setText(opc.getEtiq_sup());
        holder.txtLado.setText(opc.getEtiq_lado());
    }

    @Override
    public int getItemCount() {
        return boList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtDesc, txtNmroParte, txtTapa, txtPuente, txtDestornillador, txtSuperior, txtLado;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDesc = (TextView) itemView.findViewById(R.id.txt_desc);
            txtNmroParte = (TextView) itemView.findViewById(R.id.txt_nmro);
            txtTapa = (TextView) itemView.findViewById(R.id.txt_tapa);
            txtPuente = (TextView) itemView.findViewById(R.id.txt_puente);
            txtDestornillador = (TextView) itemView.findViewById(R.id.txt_destornillador);
            txtSuperior = (TextView) itemView.findViewById(R.id.txt_superior);
            txtLado = (TextView) itemView.findViewById(R.id.txt_lado);
            context = itemView.getContext();
        }
    }
}