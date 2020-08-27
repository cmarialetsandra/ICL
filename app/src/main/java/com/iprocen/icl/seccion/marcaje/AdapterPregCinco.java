package com.iprocen.icl.seccion.marcaje;

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

public class AdapterPregCinco extends RecyclerView.Adapter<AdapterPregCinco.ViewHolder>{

    private List<Marcaje> maList;

    public AdapterPregCinco(List<Marcaje> maList) {
        this.maList = maList;
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
        final Marcaje opc = maList.get(position);
        holder.txtOpc.setText(opc.getCampo3());
        holder.txtOpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("tipo", opc.getTipo());
                bundle.putString("material", opc.getMaterial());
                bundle.putString("campo1", opc.getCampo1());
                bundle.putString("campo2", opc.getCampo2());
                bundle.putString("campo3", opc.getCampo3());
                PregSeisFragment fragment = new PregSeisFragment();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) holder.context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return maList.size();
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