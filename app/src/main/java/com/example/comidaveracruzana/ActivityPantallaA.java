package com.example.comidaveracruzana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ActivityPantallaA extends AppCompatActivity {

    //Declaracion de los fragmentos que necesitamos, las 5 vista
    FirstFragment firstFragment = new FirstFragment();
    SecondFragment secondFragment = new SecondFragment();
    ThirdFragment thirdFragment = new ThirdFragment();
    FourthFragment fourthFragment = new FourthFragment();
    FifthFragment fifthFragment = new FifthFragment();
    ActivityBuscar ab = new ActivityBuscar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla);

        //referenciamos en navigation con nuevo id de bottom_vavigation
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        //cada vez que el usuario presione sabe que fragmento es
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //aqui se mostrara siempre la primera pantalla que es inicio
        loadFragment(firstFragment);

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.firstFragment:

                    loadFragment(firstFragment);
                    return true;
                case R.id.secondFragment:
                    /*Intent intentb = new Intent(ActivityPantallaA.this, ActivityBuscar.class);
                    startActivity(intentb);*/
                    loadFragment(secondFragment);
                    return true;
                case R.id.thirdFragment:

                    loadFragment(thirdFragment);
                    return true;
                case R.id.fourthFragment:
                    loadFragment(fourthFragment);
                    return true;
                case R.id.fifthFragment:
                    loadFragment(fifthFragment);
                    return true;
            }
            return false;
        }
    };

    //esto remplaza el fragmento en caso de seleccionar otro
    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}