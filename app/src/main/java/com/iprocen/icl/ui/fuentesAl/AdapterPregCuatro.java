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

public class AdapterPregCuatro extends RecyclerView.Adapter<AdapterPregCuatro.PregCuatroViewHolder>{

    List<FuentesAl> fuentesAlList;

    public AdapterPregCuatro(List<FuentesAl> fuentesAlList) {
        this.fuentesAlList = fuentesAlList;
    }

    @NonNull
    @Override
    public PregCuatroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_1, parent,false);
        PregCuatroViewHolder holder = new PregCuatroViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final PregCuatroViewHolder holder, int position) {
        final FuentesAl opc = fuentesAlList.get(position);
        holder.txtDesc.setText(opc.getDesc());
        holder.txtNmroParte.setText(opc.getNmro_parte());
        if (opc.getClasific().equals("Sí")){
            holder.txtClasif.setText(R.string.conClasif);
        }else if (opc.getClasific().equals("No")){
            holder.txtClasif.setText(R.string.sinClasif);
        }
    }

    @Override
    public int getItemCount() {
        return fuentesAlList.size();
    }

    public static class PregCuatroViewHolder extends RecyclerView.ViewHolder{
        TextView txtDesc, txtNmroParte, txtClasif;
        Context context;

        public PregCuatroViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDesc = (TextView) itemView.findViewById(R.id.txt_desc1);
            txtNmroParte = (TextView) itemView.findViewById(R.id.txt_nmro1);
            txtClasif = (TextView) itemView.findViewById(R.id.txt_clasif);
            context = itemView.getContext();
        }
    }
}
