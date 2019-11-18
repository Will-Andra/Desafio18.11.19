package com.example.desafiomarvel.view.fragment.recycler;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.desafiomarvel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AutoresFragment extends Fragment {


    public AutoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_autores, container, false);
    }

}
