package com.example.recyclercardviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.PrimitiveIterator;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewViewHolder> {
    Context context;
    private int[] images;
    private String[] title, desc;

    public NewAdapter(Context context, int[] images, String[] title, String[] desc) {
        this.context = context;
        this.images = images;
        this.title = title;
        this.desc = desc;
    }

    @NonNull
    @Override
    public NewAdapter.NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_layout, parent, false);
        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewAdapter.NewViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.t1.setText(title[position]);
        holder.t2.setText(desc[position]);
    }

    @Override
    public int getItemCount() {
        return desc.length;
    }

    public class NewViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView t1, t2;

        public NewViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewId);
            t1 = itemView.findViewById(R.id.titleTextViewId);
            t2 = itemView.findViewById(R.id.descriptionTextViewId);
        }
    }
}
