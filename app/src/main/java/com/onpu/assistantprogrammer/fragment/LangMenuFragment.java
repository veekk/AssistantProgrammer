package com.onpu.assistantprogrammer.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onpu.assistantprogrammer.MainActivity;
import com.onpu.assistantprogrammer.R;
import com.onpu.assistantprogrammer.model.Language;
import com.onpu.assistantprogrammer.util.CustomFragmentManager;
import com.onpu.assistantprogrammer.util.LanguageMenuAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Crafted by veek on 25.05.16 with love ♥
 */
public class LangMenuFragment extends Fragment{

    CustomFragmentManager fragmentManager = CustomFragmentManager.getInstance();
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.language_menu, null);  //Инфлейтим наш лэйаут
        RecyclerView langRV = (RecyclerView)rootView.findViewById(R.id.langRV); // Определяем RecyclerView
        LinearLayoutManager llm = new LinearLayoutManager(getActivity()); // Определяем llm
        langRV.setLayoutManager(llm); //Присваиваем llm RecyclerView
        List<Language> languages = new ArrayList<>();
        //Создаём навый список языков
        //Забиваем наш список языков в формате (id, название языка, описание, ссылка на инфо, ссылка на видео) для диалогов
        //вызываемых из пункта меню Links
        languages.add(new Language(0, "Python", "pyth фловралофыралофыраоф", "https://py-info.com", "https://py-video.com"));
        languages.add(new Language(1, "JavaScript", "js фловралофыралофыраоф", "https://js-info.com", "https://js-video.com"));
        languages.add(new Language(2, "Java", "java фловралофыралофыраоф", "https://java-info.com", "https://java-video.com"));
        languages.add(new Language(3, "C#", "c# фловралофыралофыраоф", "https://csh-info.com", "https://csh-video.com"));
        languages.add(new Language(4, "C", "c фловралофыралофыраоф", "https://c-info.com", "https://c-video.com"));
        languages.add(new Language(5, "Ruby", "ruby фловралофыралофыраоф", "https://ruby-info.com", "https://ruby-video.com"));
        languages.add(new Language(6, "PHP", "php фловралофыралофыраоф", "https://php-info.com", "https://php-video.com"));
        languages.add(new Language(7, "Objective-C", "obj-c фловралофыралофыраоф", "https://objc-info.com", "https://objc-video.com"));
        languages.add(new Language(8, "C++", "c++ фловралофыралофыраоф", "https://cpp-info.com", "https://cpp-video.com"));
        LanguageMenuAdapter adapter = new LanguageMenuAdapter(languages, getActivity()); //определяем адаптер
        langRV.setAdapter(adapter); //сетим адаптер
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
