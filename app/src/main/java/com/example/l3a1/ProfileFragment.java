package com.example.l3a1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapterProfile recyclerAdapterProfile;
    ArrayList<Madel> models;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        recyclerView = v.findViewById(R.id.rv_profile);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        models = new ArrayList<>();
        recyclerAdapterProfile = new RecyclerAdapterProfile(models, getContext());
        Madel ob1 = new Madel(R.drawable.ic_baseline_home_24, "Angular", "Web Application");
        models.add(ob1);

        recyclerView.setAdapter(recyclerAdapterProfile);

        return v;
    }
}