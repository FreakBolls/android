package com.example.cl1_cibertec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {


    Context context;
    private ArrayList<datoscardModel> arrayList = new ArrayList<>();

    public CardAdapter(Context context, ArrayList<datoscardModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_modelo,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userNameCard.setText(arrayList.get(position).getUserNameCard());
        holder.pictureCard.setImageResource(arrayList.get(position).getPictureCard());
        holder.numero_me_gusta.setText(arrayList.get(position).getNumero_me_gusta()+"");




        holder.like_checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            int likes = arrayList.get(position).getNumero_me_gusta();
            if (isChecked) {
                arrayList.get(position).setNumero_me_gusta(likes + 1);  // Incrementa los likes
            } else {
                arrayList.get(position).setNumero_me_gusta(likes - 1);  // Decrementa los likes
            }
            holder.numero_me_gusta.setText(String.valueOf(arrayList.get(position).getNumero_me_gusta()));  // Actualiza el número de likes

        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView userNameCard;
        ImageView pictureCard;

        TextView numero_me_gusta;

        CheckBox like_checkbox;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            userNameCard = itemView.findViewById(R.id.userNameCard);
            pictureCard= itemView.findViewById(R.id.pictureCard);
            numero_me_gusta= itemView.findViewById(R.id.numero_me_gusta);
            like_checkbox= itemView.findViewById(R.id.like_checkbox);


        }
    }

}
