package com.example.wallmates.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.wallmates.Adapters.bomPagerAdapter;
import com.example.wallmates.Modals.bomModal;
import com.example.wallmates.databinding.ActivityBomPagerBinding;

import java.io.IOException;
import java.util.ArrayList;

public class bomPagerActivity extends AppCompatActivity {

    ActivityBomPagerBinding binding;

    int pos ;
    ArrayList<bomModal> bomModalArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityBomPagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initBomPager();

        }



    private void initBomPager() {
        pos = getIntent().getIntExtra("pos",0);
        bomModalArrayList = (ArrayList<bomModal>) getIntent().getSerializableExtra("list1");
        bomPagerAdapter bomPagerAdapter = new bomPagerAdapter(this,bomModalArrayList);
        binding.pager.setAdapter(bomPagerAdapter);
        binding.pager.setCurrentItem(pos);
        binding.pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        CompositePageTransformer compositePageTransformer =new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(1));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r =1 -Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        binding.pager.setPageTransformer(compositePageTransformer);

    }

}