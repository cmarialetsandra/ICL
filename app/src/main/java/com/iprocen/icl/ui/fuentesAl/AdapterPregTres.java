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

public class AdapterPregTres extends RecyclerView.Adapter<AdapterPregTres.PregTresViewHolder>{

    List<FuentesAl> fuentesAlList;

    public AdapterPregTres(List<FuentesAl> fuentesAlList) {
        this.fuentesAlList = fuentesAlList;
    }

    @NonNull
    @Override
    public PregTresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler, parent,false);
        PregTresViewHolder holder = new PregTresViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PregTresViewHolder holder, int position) {
        FuentesAl opc = fuentesAlList.get(position);
        holder.txtOpc.setText(opc.getS_corriente());
        /*holder.txtOpc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PregDosFragment fragment = new PregDosFragment();
                FragmentTransaction transaction = ((AppCompatActivity) holder.context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.nav_host_fragment, fragment).addToBackStack(null);
                transaction.commit();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return fuentesAlList.size();
    }

    public static class PregTresViewHolder extends RecyclerView.ViewHolder{
        TextView txtOpc;
        Context context;

        public PregTresViewHolder(@NonNull View itemView) {
            super(itemView);
            txtOpc = (TextView) itemView.findViewById(R.id.txt_opc);
            context = itemView.getContext();
        }
    }
}
