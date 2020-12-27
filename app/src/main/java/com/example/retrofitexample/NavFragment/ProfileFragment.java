package com.example.retrofitexample.NavFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.retrofitexample.R;
import com.example.retrofitexample.RetrofitClient;
import com.example.retrofitexample.SharedPrefManager;
import com.example.retrofitexample.modelResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProfileFragment extends Fragment {
    SharedPrefManager sharedPrefManager;
    int userId;
    private EditText editTextUserName;
    private EditText editTextUserEmail;
    private Button buttonUpdate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        sharedPrefManager = new SharedPrefManager(getActivity());
        userId = sharedPrefManager.getUser().getId();


        editTextUserName = view.findViewById(R.id.editTextUserName);
        editTextUserEmail = view.findViewById(R.id.editTextUserEmail);
        buttonUpdate = view.findViewById(R.id.buttonUpdate);

        setListenerWithView();

        return view;
    }

    private void setListenerWithView() {
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callUpdateApi();
            }
        });

    }

    private void callUpdateApi() {
        String userName = editTextUserName.getText().toString();
        String userEmail = editTextUserEmail.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (userName.isEmpty()) {
            Toast.makeText(getActivity(), "enter user name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userEmail.isEmpty()) {
            Toast.makeText(getActivity(), "enter user email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!userEmail.matches(emailPattern)) {
            Toast.makeText(getActivity(), "enter valid email", Toast.LENGTH_SHORT).show();
            return;
        }

        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .updateUserAccount(userId, userName, userEmail);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse updateResponse = response.body();
                if (response.isSuccessful()) {
                    if (updateResponse.getError().equals("200")) {
                        sharedPrefManager.saveUser(updateResponse.getUser());
                        Toast.makeText(getActivity(), updateResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), updateResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}