package com.iprocen.icl.ui.fuentesAl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;

import java.util.List;

public class AdapterPregSeis extends RecyclerView.Adapter<AdapterPregSeis.PregSeisViewHolder>{

    List<FuentesAl> fuentesAlList;

    public AdapterPregSeis(List<FuentesAl> fuentesAlList) {
        this.fuentesAlList = fuentesAlList;
    }

    @NonNull
    @Override
    public PregSeisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_2, parent,false);
        PregSeisViewHolder holder = new PregSeisViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final PregSeisViewHolder holder, int position) {
        final FuentesAl opc = fuentesAlList.get(position);
        holder.txtCorriente.setText(opc.getCorriente());
        holder.txtDesc.setText(opc.getDesc());
        holder.txtNmroParte.setText(opc.getNmro_parte());
    }

    @Override
    public int getItemCount() {
        return fuentesAlList.size();
    }

    public static class PregSeisViewHolder extends RecyclerView.ViewHolder{
        TextView txtCorriente, txtDesc, txtNmroParte;
        Context context;

        public PregSeisViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCorriente = (TextView) itemView.findViewById(R.id.txt_corriente);
            txtDesc = (TextView) itemView.findViewById(R.id.txt_desc2);
            txtNmroParte = (TextView) itemView.findViewById(R.id.txt_nmro2);
            context = itemView.getContext();
        }
    }
}
