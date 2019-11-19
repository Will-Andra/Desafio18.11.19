package com.e.marvelapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.marvelapp.R;
import com.e.marvelapp.model.Result;
import com.e.marvelapp.view.activity.MainActivity;
import com.e.marvelapp.view.interfaces.OnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ComicsAdapter extends RecyclerView.Adapter <ComicsAdapter.ViewHolder> {

    private List<Result> resultList;
    private OnClick listener;

    public ComicsAdapter(List<Result> resultList, OnClick listener) {
        this.resultList = resultList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.onBind(result);

        holder.itemView.setOnClickListener(v -> listener.onClick(result));
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void atualizaLista(List<Result> novaLista){
        if (this.resultList.isEmpty()){
            this.resultList = novaLista;
        }else {
            this.resultList.addAll(novaLista);
        }

        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private ImageView poster;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.txtTituloItem);
            poster = itemView.findViewById(R.id.imgComicsItem);
        }
        public void onBind(Result result) {
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(poster);
            titulo.setText(result.getTitle());

        }

    }
}
