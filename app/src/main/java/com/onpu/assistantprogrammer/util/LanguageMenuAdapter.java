package com.onpu.assistantprogrammer.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onpu.assistantprogrammer.R;
import com.onpu.assistantprogrammer.fragment.LangMenuFragment;
import com.onpu.assistantprogrammer.fragment.TestFragment;
import com.onpu.assistantprogrammer.model.Language;

import java.util.List;

/**
 * Crafted by veek on 25.05.16 with love ♥
 */
public class LanguageMenuAdapter extends RecyclerView.Adapter<LanguageMenuAdapter.LangVH>{
    List<Language> languages;
    CustomFragmentManager fragmentManager = CustomFragmentManager.getInstance();
    Context context;

    @Override
    public LangVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.language_item, parent, false);
        LangVH langVH = new LangVH(view);
        return langVH;

    }

    @Override
    public void onBindViewHolder(LangVH holder, final int position) {
        holder.text.setText(languages.get(position).descr);
        if (languages.get(position).img!=0) holder.logo.setImageResource(languages.get(position).img);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                TextView textView = new TextView(context);
                int padding_in_dp = 8;
                final float scale = context.getResources().getDisplayMetrics().density;
                int padding_in_px = (int) (padding_in_dp * scale + 0.5f);
                textView.setPadding(padding_in_px, padding_in_px, padding_in_px, padding_in_px);
                textView.setLinksClickable(true);
                textView.setTextSize(18);
                textView.setAutoLinkMask(Linkify.WEB_URLS);
                textView.setText(languages.get(position).descr);
                builder.setCancelable(true)
                        .setIcon(languages.get(position).img)
                        .setTitle(languages.get(position).name)
                        .setView(textView)
                        .setPositiveButton("Видео", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Uri uri = Uri.parse(languages.get(position).vUrl);
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                fragmentManager.setFragment(new LangMenuFragment(), false);
                                context.startActivity(intent);
                            }
                        })
                        .setNegativeButton("Инфо", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Uri uri = Uri.parse(languages.get(position).tUrl);
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                fragmentManager.setFragment(new LangMenuFragment(), false);
                                context.startActivity(intent);
                            }
                        })
                        .setNeutralButton("Закрыть", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                fragmentManager.setFragment(new LangMenuFragment(), false);
                            }
                        })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        fragmentManager.setFragment(new LangMenuFragment(), false);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return languages.size();
    }

    public static class LangVH extends RecyclerView.ViewHolder {
        RecyclerView langRV;
       // TextView name;
        TextView text;
        ImageView logo;
        CardView cardView;

        LangVH(View view){
            super(view);
            langRV = (RecyclerView)view.findViewById(R.id.langRV);
          //  name = (TextView)view.findViewById(R.id.tv2);
            cardView = (CardView)view.findViewById(R.id.card_view2);
            text = (TextView)view.findViewById(R.id.tv3);
            logo = (ImageView)view.findViewById(R.id.imageView2);
        }
    }

    public LanguageMenuAdapter(List<Language> languages, Context context) {
        this.languages = languages;
        this.context = context;
    }
}
