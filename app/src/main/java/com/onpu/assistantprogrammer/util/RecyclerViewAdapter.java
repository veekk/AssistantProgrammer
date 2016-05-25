package com.onpu.assistantprogrammer.util;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.onpu.assistantprogrammer.fragment.MenuFragment;
import com.onpu.assistantprogrammer.fragment.TestFragment;
import com.onpu.assistantprogrammer.model.Item;
import com.onpu.assistantprogrammer.R;
import com.onpu.assistantprogrammer.model.Language;

import java.util.ArrayList;
import java.util.List;

/**
 * Crafted by veek on 22.05.16 with love ♥
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MViewHolder>{
    public List<Item> items;
    public List<Item> currentItems = new ArrayList<>();
    public List<Language> languages;
    CustomFragmentManager fragmentManager = CustomFragmentManager.getInstance();
    int currentID = 0;
    int i;
    int myID = 0;
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
                            imgView.setPadding(8,8,8,8);
                            imgView.setImageResource(image);
                            builder.setTitle("Язык программирования для Вас - "+language)
                                    .setView(imgView)
                                    .setCancelable(false)
                                    .setNegativeButton("Материалы", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            switch (currentID){
                                                case 56:
                                                    myID=0;
                                                    break;
                                                case 57:
                                                    myID=1;
                                                    break;
                                                case 58:
                                                    myID=2;
                                                    break;
                                                case 59:
                                                    myID=3;
                                                    break;
                                                case 60:
                                                    myID=4;
                                                    break;
                                                case 61:
                                                    myID=5;
                                                    break;
                                                case 62:
                                                    myID=6;
                                                    break;
                                                case 63:
                                                    myID=7;
                                                    break;
                                                case 64:
                                                    myID=8;
                                                    break;
                                            }
                                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                            TextView textView = new TextView(context);
                                            int padding_in_dp = 8;
                                            final float scale = context.getResources().getDisplayMetrics().density;
                                            int padding_in_px = (int) (padding_in_dp * scale + 0.5f);
                                            textView.setPadding(padding_in_px, padding_in_px, padding_in_px, padding_in_px);
                                            textView.setLinksClickable(true);
                                            textView.setTextSize(18);
                                            textView.setAutoLinkMask(Linkify.WEB_URLS);
                                            textView.setText(languages.get(myID).descr);
                                            builder.setCancelable(true)
                                                    .setIcon(languages.get(myID).img)
                                                    .setTitle(languages.get(myID).name)
                                                    .setView(textView)
                                                    .setPositiveButton("Видео", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            Uri uri = Uri.parse(languages.get(myID).vUrl);
                                                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                            context.startActivity(intent);
                                                        }
                                                    })
                                                    .setNegativeButton("Инфо", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            Uri uri = Uri.parse(languages.get(myID).tUrl);
                                                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                            context.startActivity(intent);
                                                        }
                                                    })
                                                    .setNeutralButton("Меню", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            fragmentManager.setFragment(new MenuFragment(), false);
                                                        }
                                                    });
                                            AlertDialog alert = builder.create();
                                            alert.show();
                                        }
                                    })
                                    .setPositiveButton("Пройти тест заново", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            fragmentManager.setFragment(new TestFragment(), false);
                                        }
                                    })
                                    .setNeutralButton("Меню", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    fragmentManager.setFragment(new MenuFragment(), false);
                                }
                            });
                            AlertDialog alert = builder.create();
                            alert.show();
                        }else {currentItems.add(items.get(currentID));
                            notifyItemChanged(0);}
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

        MViewHolder(View itemView){
            super(itemView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.lLay3);
            mRecView = (RecyclerView)itemView.findViewById(R.id.mRecView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }



    public RecyclerViewAdapter(List<Item> items, List<Language> languages, Context context){
        this.items = items;
        this.languages = languages;
        this.context = context;
        currentItems.add(items.get(currentID));
    }




}
