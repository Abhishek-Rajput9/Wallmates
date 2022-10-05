package com.example.wallmates.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.wallmates.Adapters.typeWiseAdapter;
import com.example.wallmates.Modals.typeWiseModal;
import com.example.wallmates.databinding.ActivityTypeWiseBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class typeWiseActivity extends AppCompatActivity {
    ActivityTypeWiseBinding binding;

    ArrayList<typeWiseModal> typeWiseModalArrayList;
    com.example.wallmates.Adapters.typeWiseAdapter typeWiseAdapter;
     FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTypeWiseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = FirebaseFirestore.getInstance();

        initType();

    }

    private void initType() {
        typeWiseModalArrayList = new ArrayList<>();
        typeWiseAdapter = new typeWiseAdapter(this, typeWiseModalArrayList);
        binding.rcvType.setLayoutManager(new GridLayoutManager(this,3));
        binding.rcvType.setAdapter(typeWiseAdapter);
        String type = getIntent().getStringExtra("type");

        if (type!= null && type.equalsIgnoreCase("game")){
            db.collection("wallmates").whereEqualTo("type", "game").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("nature")){
            db.collection("wallmates").whereEqualTo("type", "nature").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("abstract")){
            db.collection("wallmates").whereEqualTo("type", "abstract").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("god")){
            db.collection("wallmates").whereEqualTo("type", "god").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("amoled")){
            db.collection("wallmates").whereEqualTo("type", "amoled").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("anime")){
            db.collection("wallmates").whereEqualTo("type", "anime").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("superhero")){
            db.collection("wallmates").whereEqualTo("type", "superhero").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("sports")){
            db.collection("wallmates").whereEqualTo("type", "sports").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("minimal")){
            db.collection("wallmates").whereEqualTo("type", "minimal").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("teal")){
            db.collection("wallmates").whereEqualTo("type", "teal").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("blue")){
            db.collection("wallmates").whereEqualTo("type", "blue").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("red")){
            db.collection("wallmates").whereEqualTo("type", "red").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("green")){
            db.collection("wallmates").whereEqualTo("type", "green").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
        if (type!= null && type.equalsIgnoreCase("yellow")){
            db.collection("wallmates").whereEqualTo("type", "yellow").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()){
                        for (QueryDocumentSnapshot document : task.getResult()){
                            typeWiseModal typeWiseModal = document.toObject(com.example.wallmates.Modals.typeWiseModal.class);
                            typeWiseModalArrayList.add(typeWiseModal);
                            typeWiseAdapter.notifyDataSetChanged();

                        }
                    }
                }
            });



        }
    }
}