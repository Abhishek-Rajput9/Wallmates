package com.example.wallmates.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.wallmates.Fragments.categoryFragment;
import com.example.wallmates.Fragments.homeFragment;
import com.example.wallmates.R;
import com.example.wallmates.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.navBar.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home){
                    loadFrag(new homeFragment(),1);
                }else
                {
                    loadFrag(new categoryFragment(),1);
                }
            }
        });
        binding.navBar.setSelectedItemId(R.id.home);
    }

    private void loadFrag(Fragment fragment , int flag) {
        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag == 0){
            ft.add(R.id.container ,fragment);
        }else{
            ft.replace(R.id.container,fragment) ;
        }
        ft.commit();
    }
}