package com.example.desafiomarvel.view.fragment.detalhe;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafiomarvel.R;
import com.example.desafiomarvel.model.pojos.Result;
import com.squareup.picasso.Picasso;

import static com.example.desafiomarvel.view.fragment.recycler.QuadrinhosFragment.COMICS_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalheComicsFragment extends Fragment {
    private ImageView imgFundo;
    private ImageView imgFrente;
    private TextView txtDescricao;
    private TextView txtPreco;
    private TextView txtPublicacao;
    private TextView txtPaginas;
    private TextView txtTitulo;


    public DetalheComicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalhe_comics, container, false);

        initView(view);

        if (getArguments() != null) {

            Result result = getArguments().getParcelable(COMICS_KEY);

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgFrente);
            Picasso.get().load(result.getImages().get(0).getPath() + ".jpg").into(imgFundo);

            txtDescricao.setText(result.getDescription());
            txtPublicacao.setText(result.getModified());
            txtPreco.setText(result.getPrices().get(0).getType());
            txtPaginas.setText("Tipo de Revista: " + result.getFormat());
            txtTitulo.setText(result.getTitle());

        }

        return view;
    }

    private void initView(View view) {
        txtDescricao = view.findViewById(R.id.text_descrecao);
        imgFrente = view.findViewById(R.id.imageFrente);
        imgFundo = view.findViewById(R.id.imageFundo);
        txtPublicacao = view.findViewById(R.id.text_publicacao);
        txtPreco = view.findViewById(R.id.text_preco);
        txtPaginas = view.findViewById(R.id.text_paginas);
        txtTitulo = view.findViewById(R.id.text_titulo_descricao);
    }

}
