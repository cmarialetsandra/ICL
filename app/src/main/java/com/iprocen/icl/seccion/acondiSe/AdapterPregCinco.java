package com.iprocen.icl.seccion.acondiSe;

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

    private List<AcondiSe> asList;

    public AdapterPregCinco(List<AcondiSe> asList) {
        this.asList = asList;
    }

    @NonNull
    @Override
    public AdapterPregCinco.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_3, parent,false);
        AdapterPregCinco.ViewHolder holder = new AdapterPregCinco.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterPregCinco.ViewHolder holder, int position) {
        final AcondiSe opc = asList.get(position);
        holder.txtDesc.setText(opc.getDesc());
        holder.txtNmroParte.setText(opc.getNmro_parte());
    }

    @Override
    public int getItemCount() {
        return asList.size();
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