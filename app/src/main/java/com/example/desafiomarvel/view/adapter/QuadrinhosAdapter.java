package com.example.desafiomarvel.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafiomarvel.R;
import com.example.desafiomarvel.model.pojos.Result;
import com.example.desafiomarvel.view.onclink.ComicsOnClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class QuadrinhosAdapter extends RecyclerView.Adapter <QuadrinhosAdapter.ViewHolder> {
    private List<Result> resultList;
    private ComicsOnClick listener;

    public QuadrinhosAdapter(List<Result> resultList, ComicsOnClick listener) {
        this.resultList = resultList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyvler, parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Result result = resultList.get(position);
        holder.onBind(result);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.comicsOnClick(result);
            }
        });

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

            titulo = itemView.findViewById(R.id.txtTitulo);
            poster = itemView.findViewById(R.id.imagem_Retorno);
        }

        public void onBind(Result result) {
            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(poster);
            titulo.setText(result.getTitle());

        }
    }
}
