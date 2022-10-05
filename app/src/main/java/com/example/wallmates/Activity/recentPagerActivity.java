package com.example.wallmates.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.wallmates.Adapters.bomPagerAdapter;
import com.example.wallmates.Adapters.pagerAdapter;
import com.example.wallmates.Modals.bomModal;
import com.example.wallmates.Modals.newestModal;
import com.example.wallmates.databinding.ActivityRecentPagerBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class recentPagerActivity extends AppCompatActivity {
 ActivityRecentPagerBinding binding;

 int pos ;
 ArrayList<newestModal> arrayList = new ArrayList<>();

    FirebaseFirestore db ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecentPagerBinding.inflate(getLayoutInflater()) ;
    setContentView(binding.getRoot());


        // Firebase instance

        db = FirebaseFirestore.getInstance();
        initPager();


    }


    private void initPager() {

        pos = getIntent().getIntExtra("pos",1);
         arrayList = (ArrayList<newestModal>) getIntent().getSerializableExtra("list");
        pagerAdapter  pagerAdapter = new pagerAdapter(this,arrayList);
        binding.pager.setAdapter(pagerAdapter);
        binding.pager.setCurrentItem(pos);
        binding.pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        binding.pager.setClipToPadding(false);
        binding.pager.setClipChildren(false);
        binding.pager.setOffscreenPageLimit(3);
        binding.pager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


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