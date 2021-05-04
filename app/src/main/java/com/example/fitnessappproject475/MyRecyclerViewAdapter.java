package com.example.fitnessappproject475;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {


        private String[] localDataSet;
        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView textView;

            public ViewHolder(View view) {
                super(view);
                textView = (TextView) view.findViewById(R.id.FoodName);
            }

            public TextView getTextView() {
                return textView;
            }
        }

        public MyRecyclerViewAdapter(String[] dataSet) {
            localDataSet = dataSet;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.recyclerview, viewGroup, false);

            return new ViewHolder(view);
        }


        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            viewHolder.getTextView().setText(localDataSet[position]);
        }

        @Override
        public int getItemCount() {
            return localDataSet.length;
        }

        //TODO: add this "recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));" to ensure the kcal turns into a row new to food
    }
