package com.onpu.assistantprogrammer.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.onpu.assistantprogrammer.R;
import com.onpu.assistantprogrammer.util.CustomFragmentManager;

/**
 * Crafted by veek on 23.05.16 with love ♥
 */
public class MenuFragment extends Fragment {

    CustomFragmentManager fragmentManager = CustomFragmentManager.getInstance();
    View rootView;
    Button btnTest;
    Button btnLinks;
    Button btnAbout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_menu, null);
        btnTest = (Button) rootView.findViewById(R.id.btnTest);
        btnLinks = (Button) rootView.findViewById(R.id.btnLinks);
        btnAbout = (Button) rootView.findViewById(R.id.btnAbout);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.setFragment(new TestFragment(), true);
            }
        });
        btnLinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.setFragment(new LangMenuFragment(), true);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("About");
                View view = (View) getActivity().getLayoutInflater()
                        .inflate(R.layout.dialog_about, null);
                builder.setView(view);
                AlertDialog alert = builder.create();
                alert.show();



            }
        });
        return rootView;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
