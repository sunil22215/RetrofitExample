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
    private TextView textViewUserName;
    private TextView textViewUserEmail;
    SharedPrefManager sharedPrefManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_dashboard, container, false);
        sharedPrefManager = new SharedPrefManager(getActivity());
        textViewUserName = view.findViewById(R.id.textViewUserName);
        textViewUserEmail = view.findViewById(R.id.textViewUserEmail);

        String userName = "Hey! "+sharedPrefManager.getUser().getUsername();
        textViewUserName.setText(userName);
        textViewUserEmail.setText(sharedPrefManager.getUser().getEmail());

        return view;
    }
}