package com.example.l3a1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFrogment extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFrogment() {
    }

    public static HomeFrogment newInstance(String param1, String param2) {
        HomeFrogment fragment = new HomeFrogment();
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
        View view = inflater.inflate(R.layout.fragment_home_frogment, container, false);
        recyclerView = view.findViewById(R.id.rv_home);
        List<String> list = new ArrayList<>();
        list.add("Value 1");
        list.add("Value 2");
        list.add("Value 3");
        list.add("Value 4");
        list.add("Value 6");
        list.add("Value 7");
        list.add("Value 8");
        list.add("Value 9");
        list.add("Value 10");
        list.add("Value 11");
        list.add("Value 12");
        list.add("Value 13");
        list.add("Value 14");
        list.add("Value 15");
        list.add("Value 16");
        list.add("Value 17");
        list.add("Value 18");
        list.add("Value 19");
        list.add("Value 20");
        recyclerAdapter = new RecyclerAdapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapter);

        return view;

    }
}