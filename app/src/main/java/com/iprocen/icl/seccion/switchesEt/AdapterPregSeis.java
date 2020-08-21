package com.iprocen.icl.seccion.switchesEt;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.iprocen.icl.R;

import java.util.List;

public class AdapterPregSeis extends RecyclerView.Adapter<AdapterPregSeis.ViewHolder>{

    private List<SwitcheEt> swList;

    public AdapterPregSeis(List<SwitcheEt> swList) {
        this.swList = swList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_opc, parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final SwitcheEt opc = swList.get(position);
        holder.txtOpc.setText(opc.getArea());
        holder.txtOpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("puerto_cobre", opc.getPuerto_cobre());
                bundle.putString("puerto_especial", opc.getPuerto_especial());
                bundle.putString("puerto_total", opc.getPuerto_total());
                bundle.putString("velocidad", opc.getVelocidad());
                bundle.putString("alimentacion", opc.getAlimentacion());
                bundle.putString("area", opc.getArea());
                PregSieteFragment fragment = new PregSieteFragment();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) holder.context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return swList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtOpc;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtOpc = (TextView) itemView.findViewById(R.id.txt_opc);
            context = itemView.getContext();
        }
    }
}