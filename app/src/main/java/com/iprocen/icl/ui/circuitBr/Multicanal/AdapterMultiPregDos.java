package com.iprocen.icl.ui.circuitBr.Multicanal;

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
import com.iprocen.icl.ui.circuitBr.CircuitBr;
import com.iprocen.icl.ui.circuitBr.TMC.TMCDosFragment;

import java.util.List;

public class AdapterMultiPregDos extends RecyclerView.Adapter<AdapterMultiPregDos.ViewHolder>{

    private List<CircuitBr> cbList;

    public AdapterMultiPregDos(List<CircuitBr> cbList) {
        this.cbList = cbList;
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
        final CircuitBr opc = cbList.get(position);
        holder.txtOpc.setText(opc.getAmperaje());
        holder.txtOpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("tipo", opc.getTipo());
                bundle.putString("canal", opc.getCanal());
                bundle.putString("amperaje", opc.getAmperaje());
                MultiTresFragment fragment = new MultiTresFragment();
                fragment.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) holder.context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).disallowAddToBackStack();
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cbList.size();
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