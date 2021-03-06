package com.onpu.assistantprogrammer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.onpu.assistantprogrammer.fragment.MenuFragment;
import com.onpu.assistantprogrammer.model.Language;
import com.onpu.assistantprogrammer.util.CustomFragmentManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CustomFragmentManager fragmentManager = CustomFragmentManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager.init(this, R.id.frameContainer);
        fragmentManager.setFragment(new MenuFragment(), false);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}