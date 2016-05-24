package com.onpu.assistantprogrammer.Utils;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.onpu.assistantprogrammer.Fragments.MenuFragment;
import com.onpu.assistantprogrammer.Fragments.TestFragment;
import com.onpu.assistantprogrammer.Item;
import com.onpu.assistantprogrammer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Crafted by veek on 22.05.16 with love ♥
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MViewHolder>{
    public List<Item> items;
    public List<Item> currentItems = new ArrayList<>();
    CustomFragmentManager fragmentManager = CustomFragmentManager.getInstance();
    int currentID = 0;
    int i;
    int image;
    String language;
    Context context;
    @Override
    public MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        MViewHolder mvh = new MViewHolder(view);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MViewHolder holder, final int position) {

            holder.textView.setText(items.get(currentID).getText());
            holder.linearLayout.removeAllViews();
            for (i = 0; i < items.get(currentID).relations.length; i++) {
                final Button mBtn = new Button(context);
                String text = items.get(items.get(currentID).relations[i]).text.toString();
                mBtn.setText(text);
                mBtn.setId(items.get(items.get(currentID).relations[i]).id);
                mBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        currentID = mBtn.getId();
                        if (currentID>55) {
                            switch (currentID) {
                                case 56:
                                    language = "Pyhton";
                                    image = R.drawable.python;
                                    break;
                                case 57:
                                    language = "JavaScript";
                                    image = R.drawable.js;
                                    break;
                                case 58:
                                    language = "Java";
                                    image = R.drawable.java;
                                    break;
                                case 59:
                                    language = "C#";
                                    image = R.drawable.csharp;
                                    break;
                                case 60:
                                    language = "C";
                                    image = R.drawable.c;
                                    break;
                                case 61:
                                    language = "Ruby";
                                    image = R.drawable.ruby;
                                    break;
                                case 62:
                                    language = "PHP";
                                    image = R.drawable.php;
                                    break;
                                case 63:
                                    language = "Objective-C";
                                    image = R.drawable.objc;
                                    break;
                                case 64:
                                    language = "C++";
                                    image = R.drawable.cpp;
                                    break;

                            }

                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            ImageView imgView = new ImageView(context);
                            imgView.setImageResource(image);
                            builder.setTitle("Язык программирования для Вас - "+language)
                                    .setView(imgView)
                                    .setCancelable(false)
                                    .setPositiveButton("Пройти тест заново", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            fragmentManager.setFragment(new TestFragment(), false);
                                        }
                                    })
                                    .setNegativeButton("Меню", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    fragmentManager.setFragment(new MenuFragment(), false);
                                }
                            });
                            AlertDialog alert = builder.create();
                            alert.show();
                        }else {currentItems.add(items.get(currentID));
                            notifyDataSetChanged();}
                    }
                });
                LinearLayout.LayoutParams params = new
                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.weight = 1;
                mBtn.setLayoutParams(params);
                holder.linearLayout.addView(mBtn);
            }


        }



    @Override
    public int getItemCount() {
       return 1;//currentItems.size();
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
        currentItems.add(items.get(currentID));
    }




}
