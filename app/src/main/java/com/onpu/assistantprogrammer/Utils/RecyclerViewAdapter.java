package com.onpu.assistantprogrammer.Utils;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.onpu.assistantprogrammer.Item;
import com.onpu.assistantprogrammer.R;

import java.util.List;

/**
 * Crafted by veek on 22.05.16 with love ♥
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MViewHolder>{
    public List<Item> items;
    public List<Item> currentItems;
    int currentID = 0;
    int i;
    Context context;
    @Override
    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        MViewHolder mvh = new MViewHolder(view);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MViewHolder holder, final int position) {


        holder.textView.setText(items.get(position).text);

//        View v = LayoutInflater.from(context).inflate(R.layout.button, ViewGroup);
        holder.linearLayout.removeAllViews();
        for (i = 0; i<items.get(position).relations.length; i++){
            String text;
            Button mBtn = new Button(context);
            mBtn.setText("");
            text = items.get(items.get(position).relations[i]).text.toString();
            mBtn.setText(text);
            mBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentItems.add(items.get(items.get(position).relations[i]));
                }
            });
            LinearLayout.LayoutParams params = new
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.weight=1;
            mBtn.setLayoutParams(params);
            holder.linearLayout.addView(mBtn);
        }


    }

    @Override
    public int getItemCount() {
       return currentItems.size();
    }

    public static class MViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecView;
        TextView textView;
        LinearLayout linearLayout;
       // Button mBtn = new Button(context);

        MViewHolder(View itemView){
            super(itemView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.lLay3);
            mRecView = (RecyclerView)itemView.findViewById(R.id.mRecView);
            textView = (TextView) itemView.findViewById(R.id.textView);
           // LinearLayout.LayoutParams params = new LinearLayout.LayoutParams()
            //mBtn = (Button) itemView.findViewById(R.id.button2);

        }
    }



    public RecyclerViewAdapter(List<Item> items, Context context){
        this.items = items;
        this.context = context;
        currentItems.add(items.get(0));
    }




}
