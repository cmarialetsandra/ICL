package com.iprocen.icl.seccion.instalacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;

import java.util.List;

public class AdapterResultado extends RecyclerView.Adapter<AdapterResultado.ViewHolder>{

    private List<Instalacion> inList;

    public AdapterResultado(List<Instalacion> inList) {
        this.inList = inList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_result_8, parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Instalacion opc = inList.get(position);

        if (opc.getTipo().equals("Cortar") || opc.getTipo().equals("Herramientas y punteras")){
            holder.lblColumna1.setText(R.string.funcion);
            holder.txtColumna1.setText(opc.getFuncion());
            holder.lblColumna2.setText(R.string.tamanio_cond);
            holder.txtColumna2.setText(opc.getTamanio());
            holder.lblColumna3.setVisibility(View.GONE);
            holder.txtColumna3.setVisibility(View.GONE);
        }else if(opc.getTipo().equals("Desailar")){
            holder.lblColumna1.setText(R.string.funcion);
            holder.txtColumna1.setText(opc.getFuncion());
            holder.lblColumna2.setText(R.string.tamanio_cond);
            holder.txtColumna2.setText(opc.getTamanio());
            holder.lblColumna3.setText(R.string.tipo_aislamiento);
            holder.txtColumna3.setText(opc.getAislamiento());
        }else if (opc.getTipo().equals("Ponchar")){
            holder.lblColumna1.setText(R.string.tamanio_cond);
            holder.txtColumna1.setText(opc.getTamanio());
            holder.lblColumna2.setText(R.string.forma_ponchado);
            holder.txtColumna2.setText(opc.getForma());
            holder.lblColumna3.setVisibility(View.GONE);
            holder.txtColumna3.setVisibility(View.GONE);
        }else if (opc.getTipo().equals("Punteras")){
            holder.lblColumna1.setText(R.string.awg);
            holder.txtColumna1.setText(opc.getAwg());
            holder.lblColumna2.setText(R.string.color);
            holder.txtColumna2.setText(opc.getColor());
            holder.lblColumna3.setText(R.string.empaque_estandar);
            holder.txtColumna3.setText(opc.getEmpaque());
        }else if (opc.getTipo().equals("Ensamblar")){
            holder.lblColumna1.setText(R.string.herramienta);
            holder.txtColumna1.setText(opc.getHerramienta());
            holder.lblColumna2.setVisibility(View.GONE);
            holder.txtColumna2.setVisibility(View.GONE);
            holder.lblColumna3.setVisibility(View.GONE);
            holder.txtColumna3.setVisibility(View.GONE);
        }

        holder.txtDesc.setText(opc.getDesc());
        holder.txtNmroParte.setText(opc.getNmro_parte());
    }

    @Override
    public int getItemCount() {
        return inList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView lblColumna1, lblColumna2, lblColumna3, txtColumna1, txtColumna2, txtColumna3, txtDesc, txtNmroParte;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lblColumna1 = (TextView) itemView.findViewById(R.id.lbl_columna1);
            txtColumna1 = (TextView) itemView.findViewById(R.id.txt_columna1);
            lblColumna2 = (TextView) itemView.findViewById(R.id.lbl_columna2);
            txtColumna2 = (TextView) itemView.findViewById(R.id.txt_columna2);
            lblColumna3 = (TextView) itemView.findViewById(R.id.lbl_columna3);
            txtColumna3 = (TextView) itemView.findViewById(R.id.txt_columna3);
            txtDesc = (TextView) itemView.findViewById(R.id.txt_desc1);
            txtNmroParte = (TextView) itemView.findViewById(R.id.txt_nmro1);
            context = itemView.getContext();
        }
    }
}