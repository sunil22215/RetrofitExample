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
<<<<<<< HEAD
    private TextView textViewUserName;
    private TextView textViewUserEmail;
=======
    private TextView textViewName1;
    private TextView textViewEmail1;
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
<<<<<<< HEAD
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        sharedPrefManager = new SharedPrefManager(getActivity());
        textViewUserName = view.findViewById(R.id.textViewUserName);
        textViewUserEmail = view.findViewById(R.id.textViewUserEmail);

        String userName = "Hey! " + sharedPrefManager.getUser().getUsername();
        textViewUserName.setText(userName);
        textViewUserEmail.setText(sharedPrefManager.getUser().getEmail());

=======
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        textViewName1 = view.findViewById(R.id.textViewName1);
        textViewEmail1 = view.findViewById(R.id.textViewEmail1);

        sharedPrefManager = new SharedPrefManager(getActivity());

        String userName1 = "Hey! " + sharedPrefManager.getUser().getUsername();
        textViewName1.setText(userName1);
        textViewEmail1.setText(sharedPrefManager.getUser().getEmail());
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
        return view;
    }
}