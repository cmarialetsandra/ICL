package com.iprocen.icl.ui.fuentesAl;

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

public class AdapterPregUno extends RecyclerView.Adapter<AdapterPregUno.PregUnoViewHolder>{

    List<FuentesAl> fuentesAlList;

    public AdapterPregUno(List<FuentesAl> fuentesAlList) {
        this.fuentesAlList = fuentesAlList;
    }

    @NonNull
    @Override
    public PregUnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler, parent,false);
        PregUnoViewHolder holder = new PregUnoViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PregUnoViewHolder holder, int position) {
        final FuentesAl opc = fuentesAlList.get(position);
        holder.txtOpc.setText(opc.getFase());
        holder.txtOpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("fase", opc.getFase());
                PregDosFragment fragment = new PregDosFragment();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) holder.context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return fuentesAlList.size();
    }

    public static class PregUnoViewHolder extends RecyclerView.ViewHolder{
        TextView txtOpc;
        Context context;

        public PregUnoViewHolder(@NonNull View itemView) {
            super(itemView);
            txtOpc = (TextView) itemView.findViewById(R.id.txt_opc);
            context = itemView.getContext();
        }
    }
}