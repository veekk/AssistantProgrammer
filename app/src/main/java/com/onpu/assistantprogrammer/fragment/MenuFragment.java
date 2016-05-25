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
        rootView = inflater.inflate(R.layout.fragment_menu, null); //Инфлейтим наш лэйаут
        btnTest = (Button) rootView.findViewById(R.id.btnTest); // Определяем кнопки
        btnLinks = (Button) rootView.findViewById(R.id.btnLinks); // Определяем кнопки
        btnAbout = (Button) rootView.findViewById(R.id.btnAbout); // Определяем кнопки
        btnTest.setOnClickListener(new View.OnClickListener() { //Присваем действие на нажатие
            @Override
            public void onClick(View v) {
                fragmentManager.setFragment(new TestFragment(), true); //Сеттим фрагмент с тестом
            }
        });
        btnLinks.setOnClickListener(new View.OnClickListener() { //Присваем действие на нажатие
            @Override
            public void onClick(View v) {
                fragmentManager.setFragment(new LangMenuFragment(), true);  //Сеттим фрагмент с материалами
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {  //Присваем действие на нажатие
            @Override
            public void onClick(View v) {
                //Определяем диалог
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("About");
                View view = (View) getActivity().getLayoutInflater()
                        .inflate(R.layout.dialog_about, null); //инфлейтим лэйаут для диалога
                builder.setView(view); //присваем диалогу вью по лэйауту
                AlertDialog alert = builder.create();
                alert.show(); //показываем диалог



            }
        });
        return rootView;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
