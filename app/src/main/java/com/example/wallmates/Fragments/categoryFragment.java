package com.example.wallmates.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wallmates.Adapters.categoryAdapter;
import com.example.wallmates.Modals.categoryModal;
import com.example.wallmates.databinding.FragmentCategoryBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class categoryFragment extends Fragment {
FragmentCategoryBinding binding ;
ArrayList<categoryModal>  categoryModalArrayList;
com.example.wallmates.Adapters.categoryAdapter categoryAdapter;


FirebaseFirestore db ;


    public categoryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater,container,false);
        db = FirebaseFirestore.getInstance();

        initCategory();
        return binding.getRoot();
    }

    private void initCategory() {
        categoryModalArrayList = new ArrayList<>();
        categoryAdapter = new categoryAdapter(getContext(), categoryModalArrayList) ;
        binding.rcvCategory.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.rcvCategory.setAdapter(categoryAdapter);

        db.collection("category").orderBy("type").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot document : task.getResult()){{
                    categoryModal categoryModal = document.toObject(com.example.wallmates.Modals.categoryModal.class);
                    categoryModalArrayList.add(categoryModal);
                    categoryAdapter.notifyDataSetChanged();
                    }
                    }
                }
            }
        });
    }
}