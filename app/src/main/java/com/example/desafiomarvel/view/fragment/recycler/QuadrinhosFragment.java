package com.example.desafiomarvel.view.fragment.recycler;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.desafiomarvel.R;
import com.example.desafiomarvel.model.pojos.Result;
import com.example.desafiomarvel.view.adapter.QuadrinhosAdapter;
import com.example.desafiomarvel.view.fragment.detalhe.DetalheComicsFragment;
import com.example.desafiomarvel.view.onclink.ComicsOnClick;
import com.example.desafiomarvel.viewmodel.QuadrinhosViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuadrinhosFragment extends Fragment implements ComicsOnClick {

    private List<Result> results = new ArrayList<>();
    private QuadrinhosViewModel viewModel;
    private RecyclerView recyclerView;
    private QuadrinhosAdapter adapter;
    public static final String COMICS_KEY = "comics";


    public QuadrinhosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quadrinhos, container, false);


        initViews(view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));


        viewModel.getComics();
        viewModel.getListaComics().observe(this, results1 -> {
            adapter.atualizaLista(results1);

        });


        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_Quadrinhos);
        viewModel = ViewModelProviders.of(this).get(QuadrinhosViewModel.class);
        adapter = new QuadrinhosAdapter(results, this);
    }


    @Override
    public void comicsOnClick(Result result) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(COMICS_KEY, result);

        Fragment detalheFragment = new DetalheComicsFragment();
        detalheFragment.setArguments(bundle);
        replaceFragment(detalheFragment);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerPrincipal, fragment);
        transaction.commit();
    }

}
