package com.example.fitnessappproject475;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
//            Toast.makeText(getBaseContext(), "Click the sign in button again to sign in!" , Toast.LENGTH_SHORT ).show();
//            signIn();
        }


        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            viewHolder.getTextView().setText(localDataSet[position]);
        }

        @Override
        public int getItemCount() {
            return localDataSet.length;
        }


    }
