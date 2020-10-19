package com.example.user.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends android.support.v4.app.Fragment {
    //private static final String COMMON_TAG = "OrientationChange";

    View rootView;

    ListView listViewConcepts;
    ArrayAdapter<String> ConceptsAdapter;
    Context context;
    String [] Concepts;

    FragmentActionListener fragmentActionListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list,container,false);
        initUI();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getString(R.string.app_name));
    }


    public void setFragmentActionListener(FragmentActionListener fragmentActionListener){
        this.fragmentActionListener = fragmentActionListener;
    }


    private void initUI(){
        context  = getContext();
        Concepts = getResources().getStringArray(R.array.array_Concepts);
        listViewConcepts = (ListView)rootView.findViewById(R.id.list);

        ConceptsAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,Concepts);
        listViewConcepts.setAdapter(ConceptsAdapter);

        listViewConcepts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (fragmentActionListener!=null){
                    fragmentActionListener.onConceptSelected(Concepts[i]);
                }
            }
        });
    }

}

