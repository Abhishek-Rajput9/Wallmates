package com.example.wallmates.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wallmates.Modals.newestModal;
import com.example.wallmates.R;
import com.example.wallmates.databinding.NewestViewholderBinding;
import com.example.wallmates.Activity.recentPagerActivity;

import java.util.ArrayList;

public class newestAdapter extends RecyclerView.Adapter<newestAdapter.ViewHolder> {
    Context context;
    ArrayList<newestModal> newestModalArrayList;

    public newestAdapter(Context context, ArrayList<newestModal> newestModalArrayList) {
        this.context = context;
        this.newestModalArrayList = newestModalArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newest_viewholder, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        newestModal newestModal = newestModalArrayList.get(position);
   Glide.with(context).load(newestModal.getImage()).into(holder.binding.image);
   holder.itemView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent = new Intent(context, recentPagerActivity.class);
           intent.putExtra("list",newestModalArrayList);
           intent.putExtra("pos",position);
           context.startActivity(intent);
       }
   });
    }

    @Override
    public int getItemCount() {
        return newestModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        NewestViewholderBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = NewestViewholderBinding.bind(itemView);
        }
    }
}
