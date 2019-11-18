package com.example.desafiomarvel.view.fragment.recycler;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafiomarvel.R;
import com.example.desafiomarvel.model.pojos.Result;
import com.example.desafiomarvel.view.adapter.HeroisAdapter;
import com.example.desafiomarvel.view.onclink.PersonagemOnClick;
import com.example.desafiomarvel.viewmodel.HeroisViewModel;

import java.util.ArrayList;
import java.util.List;



public class HeroisFragment extends Fragment implements PersonagemOnClick {
    private List<Result> results = new ArrayList<>();
    private HeroisViewModel viewModel;
    private RecyclerView recyclerView;
    private HeroisAdapter adapter;
    public static final String HEROI_KEY = "Heroi";




    public HeroisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_herois, container, false);

        initViews(view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));


        //viewModel.getPersonagens();
        viewModel.getListaPersonagem().observe(this, results1 -> {
            adapter.atualizaListaP(results1);

        });


        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_Herois);
        viewModel = ViewModelProviders.of(this).get(HeroisViewModel.class);
        adapter = new HeroisAdapter(results, this);
    }

    @Override
    public void personagemOnClick(Result result) {

    }
}

