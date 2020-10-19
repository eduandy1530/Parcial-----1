package com.example.user.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListItemFragment extends android.support.v4.app.Fragment {


    View rootView;
    TextView textViewDefinitionsDescription;


    String ConceptName;
    String countryDescription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list_item,container,false);
        initUI();
        return rootView;

    }

    private void initUI(){
        textViewDefinitionsDescription = (TextView)rootView.findViewById(R.id.textViewDefinitionDescription);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        ConceptName = bundle.getString(FragmentActionListener.KEY_SELECTED_CONCEPT,"Android");
        countryDescription = getString(getStringId(ConceptName));

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(ConceptName);
        textViewDefinitionsDescription.setText(countryDescription);
    }

    private int getStringId(String ConceptName){
        if(ConceptName.equals("Android")){
            return R.string.Android;
        }else if(ConceptName.equals("Java")){
            return R.string.Java;
        }else if(ConceptName.equals("ListView")){
            return R.string.ListView;
        }else if(ConceptName.equals("Fragmento")){
            return R.string.Fragmento;
        }else {
            return R.string.Android;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
