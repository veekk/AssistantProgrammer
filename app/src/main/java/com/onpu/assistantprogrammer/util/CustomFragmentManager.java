package com.onpu.assistantprogrammer.util;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Crafted by veek on 22.05.16 with love ♥
 */
public class CustomFragmentManager {

    private static CustomFragmentManager instance;

    private Activity activity;
    private FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private int containerResId;

    private CustomFragmentManager(){
    }



    public static CustomFragmentManager getInstance() {

        if (instance == null) {
            instance = new CustomFragmentManager();
        }

        return instance;
    }


    public void init(Activity activity, int containerResId){
        this.activity = activity;
        fragmentManager = activity.getFragmentManager();
        this.containerResId = containerResId;
    }


    public void setFragment(Fragment fragment, boolean addToBackStack) {

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerResId, fragment);

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    public void removeFragment(Fragment fragment){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    public int getSize(){
        return fragmentManager.getBackStackEntryCount();
    }


    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }


}

