package com.e.marvelapp.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.e.marvelapp.R;
import com.e.marvelapp.model.Result;
import com.e.marvelapp.view.adapter.ComicsAdapter;
import com.e.marvelapp.view.interfaces.OnClick;
import com.e.marvelapp.viewmodel.ComicsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClick {

    private RecyclerView recyclerView;
    private ComicsAdapter adapter;
    private List<Result> results = new ArrayList<>();
    private ComicsViewModel viewModel;
    public static final String Comics_KEY = "comics";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        viewModel.getAllComics();

        viewModel.getListaComics().observe(this, resultadoLista -> {
            adapter.atualizaLista(resultadoLista);
        });

    }

    private void initViews() {
        adapter = new ComicsAdapter(results,this);
        recyclerView = findViewById(R.id.recyclerViewComics);
        viewModel = ViewModelProviders.of(this).get(ComicsViewModel.class);

    }


    @Override
    public void onClick(Result result) {
        Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Comics_KEY, result);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}
