package com.example.user.fragments;

import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentActionListener{


    private static final String ACTIVITY_NAME = MainActivity.class.getSimpleName();

    FragmentManager fragmentManager;

    android.support.v4.app.FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if(savedInstanceState==null){
            ConceptFragment();
        }
        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            ConceptFragment();
        }
    }

    private void ConceptFragment(){

        fragmentTransaction=fragmentManager.beginTransaction();

        ListFragment ConceptListFragment=new ListFragment();
        ConceptListFragment.setFragmentActionListener(this);

        fragmentTransaction.add(R.id.frameHolder,ConceptListFragment);
        fragmentTransaction.commit();
    }

    private void DescriptionFragment(String countryName){
        fragmentTransaction=fragmentManager.beginTransaction();

        ListItemFragment ConceptDescriptionFragment=new ListItemFragment();

        Bundle bundle=new Bundle();
        bundle.putString(FragmentActionListener.KEY_SELECTED_CONCEPT,countryName);
        ConceptDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.frameHolder,ConceptDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onConceptSelected(String Concept) {
        DescriptionFragment(Concept);
    }



}
