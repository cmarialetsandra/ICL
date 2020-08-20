package com.iprocen.icl.seccion.cablePre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;
import com.iprocen.icl.seccion.conectores.Conector;

import java.util.List;

public class AdapterPregNueve extends RecyclerView.Adapter<AdapterPregNueve.ViewHolder>{

    private List<CablePre> caList;
    private int chaqueta, cmat, montaje;

    public AdapterPregNueve(List<CablePre> caList, int chaqueta, int cmat, int montaje) {
        this.caList = caList;
        this.chaqueta = chaqueta;
        this.cmat = cmat;
        this.montaje = montaje;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_6, parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final CablePre opc = caList.get(position);
        if (chaqueta == 1){
            holder.txtNmroParte.setText(opc.getChaqueta_s());
        }else if(chaqueta == 2){
            holder.txtNmroParte.setText(opc.getChaqueta_n());
        }

        if (cmat == 1){
            holder.txtCmat.setText(opc.getCmat_s());
        }else if (cmat == 2){
            holder.txtCmat.setText(opc.getChaqueta_n());
        }

        if (montaje == 1){
            holder.txtReceptaculo.setText(opc.getMontaje_f());
        }else if (montaje == 2){
            holder.txtReceptaculo.setText(opc.getMontaje_p());
        }
    }

    @Override
    public int getItemCount() {
        return caList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNmroParte, txtCmat, txtReceptaculo;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNmroParte = (TextView) itemView.findViewById(R.id.txt_nmro);
            txtCmat = (TextView) itemView.findViewById(R.id.txt_cmat);
            txtReceptaculo = (TextView) itemView.findViewById(R.id.txt_receptaculo);
            context = itemView.getContext();
        }
    }
}