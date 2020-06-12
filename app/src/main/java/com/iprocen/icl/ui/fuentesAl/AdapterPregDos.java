package com.iprocen.icl.ui.fuentesAl;

import android.content.Context;
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

public class AdapterPregDos extends RecyclerView.Adapter<AdapterPregDos.PregDosViewHolder>{

    List<String> fuentesAlList;

    public AdapterPregDos(List<String> fuentesAlList) {
        this.fuentesAlList = fuentesAlList;
    }

    @NonNull
    @Override
    public PregDosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler, parent,false);
        PregDosViewHolder holder = new PregDosViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PregDosViewHolder holder, int position) {
        String opc = fuentesAlList.get(position);
        holder.txtOpc.setText(opc);
        holder.txtOpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PregTresFragment fragment = new PregTresFragment();
                FragmentTransaction transaction = ((AppCompatActivity) holder.context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return fuentesAlList.size();
    }

    public static class PregDosViewHolder extends RecyclerView.ViewHolder{
        TextView txtOpc;
        Context context;

        public PregDosViewHolder(@NonNull View itemView) {
            super(itemView);
            txtOpc = (TextView) itemView.findViewById(R.id.txt_opc);
            context = itemView.getContext();
        }
    }
}
