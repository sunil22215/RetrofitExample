package com.example.retrofitexample.NavFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.retrofitexample.R;
import com.example.retrofitexample.SharedPrefManager;

public class DashboardFragment extends Fragment {
    SharedPrefManager sharedPrefManager;
    private TextView textViewName1;
    private TextView textViewEmail1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        textViewName1 = view.findViewById(R.id.textViewName1);
        textViewEmail1 = view.findViewById(R.id.textViewEmail1);

        sharedPrefManager = new SharedPrefManager(getActivity());

        String userName1 = "Hey! " + sharedPrefManager.getUser().getUsername();
        textViewName1.setText(userName1);
        textViewEmail1.setText(sharedPrefManager.getUser().getEmail());
        return view;
    }
}