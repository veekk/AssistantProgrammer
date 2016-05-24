package com.onpu.assistantprogrammer.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.onpu.assistantprogrammer.R;
import com.onpu.assistantprogrammer.Utils.CustomFragmentManager;

/**
 * Crafted by veek on 23.05.16 with love ♥
 */
public class MenuFragment extends Fragment {

    CustomFragmentManager fragmentManager = CustomFragmentManager.getInstance();
    View rootView;
    Button btnTest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_menu, null);
        btnTest = (Button) rootView.findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.setFragment(new TestFragment(), true);
            }
        });
        return rootView;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
