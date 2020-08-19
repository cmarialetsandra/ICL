package com.iprocen.icl.seccion.SAI_UPS;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;

import java.util.List;

public class UPSAdapterPregTres extends RecyclerView.Adapter<UPSAdapterPregTres.ViewHolder>{

    private List<SAI_UPS> saiList;

    public UPSAdapterPregTres(List<SAI_UPS> saiList) {
        this.saiList = saiList;
    }

    @NonNull
    @Override
    public UPSAdapterPregTres.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_3, parent,false);
        UPSAdapterPregTres.ViewHolder holder = new UPSAdapterPregTres.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final UPSAdapterPregTres.ViewHolder holder, int position) {
        final SAI_UPS opc = saiList.get(position);
        holder.txtDesc.setText(opc.getDesc());
        holder.txtNmroParte.setText(opc.getNmro_parte());
    }

    @Override
    public int getItemCount() {
        return saiList.size();
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