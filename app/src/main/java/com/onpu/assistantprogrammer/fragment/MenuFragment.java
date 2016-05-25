package com.onpu.assistantprogrammer.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.onpu.assistantprogrammer.R;
import com.onpu.assistantprogrammer.util.CustomFragmentManager;

/**
 * Crafted by veek on 23.05.16 with love ♥
 */
public class MenuFragment extends Fragment {

    CustomFragmentManager fragmentManager = CustomFragmentManager.getInstance();
    View rootView;
    Button btnTest;
    Button btnMaterial;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_menu, null);
        btnTest = (Button) rootView.findViewById(R.id.btnTest);
        btnMaterial = (Button) rootView.findViewById(R.id.btnLinks);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.setFragment(new TestFragment(), true);
            }
        });
        btnMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.setFragment(new LangMenuFragment(), true);
            }
        });
        return rootView;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
