package com.onpu.assistantprogrammer.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onpu.assistantprogrammer.Item;
import com.onpu.assistantprogrammer.R;
import com.onpu.assistantprogrammer.Utils.CustomFragmentManager;
import com.onpu.assistantprogrammer.Utils.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Crafted by veek on 23.05.16 with love ♥
 */

public class TestFragment extends Fragment {

    CustomFragmentManager fragmentManager = CustomFragmentManager.getInstance();
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_test, null);

        RecyclerView mRecView = (RecyclerView)rootView.findViewById(R.id.mRecView);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecView.setLayoutManager(llm);
        List<Item> items = new ArrayList<>();
        items.clear();
        items.add(new Item(0, "Зачем хотите изучить программирование?", new int[]{1, 2, 3, 4, 5, 6}));
        items.add(new Item(1, "Для детей", new int[]{0}));
        items.add(new Item(2, "Заработать", new int[]{0}));
        items.add(new Item(3, "Я не знаю, выберите за меня", new int[]{0}));
        items.add(new Item(4, "Поразвлечься", new int[]{0}));
        items.add(new Item(5, "Интересно", new int[]{0}));
        items.add(new Item(6, "Саморазвитие", new int[]{0}));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(items, getActivity());
        mRecView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
