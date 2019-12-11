package com.example.turistworld.Objetos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.turistworld.R;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView lugar,ubicacion;
        ImageView fotolugar;

        public ViewHolder  (@NonNull View itemView) {
            super(itemView);
            lugar=(TextView)itemView.findViewById(R.id.tvlugar);
            ubicacion=(TextView)itemView.findViewById(R.id.tvu);
            fotolugar=(ImageView)itemView.findViewById( R.id.imgLugares);
        }


    }
    public List<listaLugares> lugarlista;

    public RecyclerViewAdaptador(List<listaLugares> lugarlista) {
        this.lugarlista = lugarlista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lugares,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        holder.lugar.setText(lugarlista.get(position).getLugar());
        holder.ubicacion.setText(lugarlista.get(position).getUbucacion());
        holder.fotolugar.setImageResource(lugarlista.get(position).getImglugar());
    }

    @Override
    public int getItemCount(){
        return lugarlista.size();
    }
}
