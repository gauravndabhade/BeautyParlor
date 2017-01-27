package com.gaurav.beautyparlor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static MyClickListener myClickListener;
    private ArrayList<Customer> mDataset;

    public MyAdapter(ArrayList<Customer> myDataset) {
        mDataset = myDataset;
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        MyAdapter.myClickListener = myClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView1.setText(mDataset.get(position).getTimeslot().toString());
        holder.mTextView2.setText(mDataset.get(position).getStatus().toString());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextView1;
        public TextView mTextView2;

        public ViewHolder(View v) {
            super(v);
            mTextView1 = (TextView) v.findViewById(R.id.t1);
            mTextView2 = (TextView) v.findViewById(R.id.t2);
            v.setOnClickListener(this);
        }

        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }
}
