package com.example.lab5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonaViewHolder>{

    List<Aves> avess;
    Context context;

    public RVAdapter(List<Aves> personas, Context context) {
        this.avess = personas;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ave,parent,false);
        PersonaViewHolder personaViewHolder = new PersonaViewHolder(view);
        return personaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        holder.nombreAve.setText(avess.get(position).nombre);
        holder.edadAve.setText(avess.get(position).edad);
        holder.descripcionAve.setText(avess.get(position).descripcion);

        Drawable original = context.getResources().getDrawable(avess.get(position).foto,null);
        Bitmap originalBitmap = ((BitmapDrawable)original).getBitmap();
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(),originalBitmap);
        roundedBitmapDrawable.setCornerRadius(originalBitmap.getHeight());

        holder.fotoAve.setImageDrawable(roundedBitmapDrawable);
    }

    @Override
    public int getItemCount() {
        return avess.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView nombreAve;
        TextView edadAve;
        TextView descripcionAve;
        ImageView fotoAve;

        public PersonaViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cv);
            nombreAve = (TextView) itemView.findViewById(R.id.nombreAve);
            edadAve = (TextView) itemView.findViewById(R.id.edadAve);
            descripcionAve = (TextView) itemView.findViewById(R.id.descripcionAve);
            fotoAve = (ImageView) itemView.findViewById(R.id.fotoAve);
        }
    }

}
