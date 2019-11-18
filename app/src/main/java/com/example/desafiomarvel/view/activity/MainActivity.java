package com.example.desafiomarvel.view.activity;

import android.os.Bundle;

import com.example.desafiomarvel.R;
import com.example.desafiomarvel.view.fragment.recycler.AutoresFragment;
import com.example.desafiomarvel.view.fragment.recycler.HeroisFragment;
import com.example.desafiomarvel.view.fragment.recycler.QuadrinhosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        replaceFragment( new QuadrinhosFragment());

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_Heroi, R.id.navigation_Quadrinhos, R.id.navigation_Autores)
                .build();

        navView.setOnNavigationItemSelectedListener(menuItem ->{
            int id =menuItem.getItemId();

            if(id == R.id.navigation_Heroi){
                replaceFragment(new HeroisFragment());

            } else if (id == R.id.navigation_Quadrinhos){

                replaceFragment(new QuadrinhosFragment());

            } else if (id == R.id.navigation_Autores){

                replaceFragment(new AutoresFragment());
            }

            return true;
        });

    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerPrincipal, fragment);
        transaction.commit();

    }
}
