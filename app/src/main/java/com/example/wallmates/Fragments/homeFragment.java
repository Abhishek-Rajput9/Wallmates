package com.example.wallmates.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wallmates.Adapters.bomAdapter;
import com.example.wallmates.Adapters.colorAdapter;
import com.example.wallmates.Adapters.newestAdapter;
import com.example.wallmates.Modals.bomModal;
import com.example.wallmates.Modals.colorModal;
import com.example.wallmates.Modals.newestModal;
import com.example.wallmates.databinding.FragmentHomeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class homeFragment extends Fragment {
    FragmentHomeBinding binding;

    // progress bar


    // best of month
    ArrayList<bomModal> bomModalArrayList;
    com.example.wallmates.Adapters.bomAdapter bomAdapter;

    // color Wallmates
    ArrayList<colorModal> colorModalArrayList;
    com.example.wallmates.Adapters.colorAdapter colorAdapter;

    // Recently Added or Newest
    ArrayList<newestModal> newestModalArrayList;
    com.example.wallmates.Adapters.newestAdapter newestAdapter;

    // Firebase intialisastion
    FirebaseFirestore db ;


    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        // Firebase instance
        db = FirebaseFirestore.getInstance();

        initBOM();
        initColor();
        initNewest();
        binding.textView.setVisibility(View.GONE);
        binding.textView3.setVisibility(View.GONE);
        binding.textView4.setVisibility(View.GONE);

        return binding.getRoot();
    }


    private void initNewest() {
        newestModalArrayList = new ArrayList<>();
        newestAdapter = new newestAdapter(getContext(), newestModalArrayList);
        binding.rcvNewest.setLayoutManager(new GridLayoutManager(getContext(),3));
        binding.rcvNewest.setAdapter(newestAdapter);
        db.collection("wallmates").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot documentSnapshot : task.getResult()){
                        newestModal newestModal = documentSnapshot.toObject(com.example.wallmates.Modals.newestModal.class);
                        newestModalArrayList.add(newestModal);
                        newestAdapter.notifyDataSetChanged();
                        binding.textView.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    private void initColor() {
        colorModalArrayList = new ArrayList<>();
        colorAdapter = new colorAdapter(getContext(), colorModalArrayList);
        binding.rcvColor.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.rcvColor.setAdapter(colorAdapter);
        db.collection("color mates").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot documentSnapshot : task.getResult()){
                        colorModal colorModal = documentSnapshot.toObject(com.example.wallmates.Modals.colorModal.class);
                        colorModalArrayList.add(colorModal);
                        colorAdapter.notifyDataSetChanged();
                        binding.textView3.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    private void initBOM() {
        bomModalArrayList = new ArrayList<>();
        bomAdapter = new bomAdapter(getContext(),bomModalArrayList);
        binding.rcvBOM.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        binding.rcvBOM.setAdapter(bomAdapter);

        db.collection("best of month").orderBy("image").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                        for (DocumentSnapshot documentSnapshot : task.getResult()){
                            bomModal bomModal = documentSnapshot.toObject(com.example.wallmates.Modals.bomModal.class);
                            bomModalArrayList.add(bomModal);
                            bomAdapter.notifyDataSetChanged();
                            binding.textView4.setVisibility(View.VISIBLE);
                        }
                }
            }
        });

    }
}