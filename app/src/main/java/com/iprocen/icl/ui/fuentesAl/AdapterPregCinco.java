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

public class AdapterPregCinco extends RecyclerView.Adapter<AdapterPregCinco.PregCincoViewHolder>{

    List<FuentesAl> fuentesAlList;

    public AdapterPregCinco(List<FuentesAl> fuentesAlList) {
        this.fuentesAlList = fuentesAlList;
    }

    @NonNull
    @Override
    public PregCincoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_1, parent,false);
        PregCincoViewHolder holder = new PregCincoViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final PregCincoViewHolder holder, int position) {
        final FuentesAl opc = fuentesAlList.get(position);
        holder.txtDesc.setText(opc.getDesc());
        holder.txtNmroParte.setText(opc.getNmro_parte());
    }

    @Override
    public int getItemCount() {
        return fuentesAlList.size();
    }

    public static class PregCincoViewHolder extends RecyclerView.ViewHolder{
        TextView txtDesc;
        TextView txtNmroParte;
        Context context;

        public PregCincoViewHolder(@NonNull View itemView) {
            super(itemView);
            //txtDesc = (TextView) itemView.findViewById(R.id.txt_desc);
            //txtNmroParte = (TextView) itemView.findViewById(R.id.txt_nmro);
            context = itemView.getContext();
        }
    }
}
