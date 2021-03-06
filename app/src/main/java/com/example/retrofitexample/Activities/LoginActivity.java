package com.example.retrofitexample.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitexample.R;
import com.example.retrofitexample.RetrofitClient;
import com.example.retrofitexample.SharedPrefManager;
import com.example.retrofitexample.modelResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    SharedPrefManager sharedPrefManager;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefManager = new SharedPrefManager(getApplicationContext());
        setContentView(R.layout.activity_login);
        initLayout();
        setListenerOnView();

    }

    private void initLayout() {

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewRegister = findViewById(R.id.textViewRegister);

    }


    private void setListenerOnView() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                loginUser();
=======
                userLogin();
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
            }
        });
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchOnRegister();
            }
        });
        sharedPrefManager = new SharedPrefManager(getApplicationContext());


<<<<<<< HEAD
    }

    private void loginUser() {

        String userEmail = editTextEmail.getText().toString();
        String userPassword = editTextPassword.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (userEmail.isEmpty()) {
            Toast.makeText(this, "enter user email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!userEmail.matches(emailPattern)) {
            Toast.makeText(this, "enter valid email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userPassword.isEmpty()) {
            Toast.makeText(this, "enter user password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userPassword.length() < 5) {
            Toast.makeText(this, "password length must be greater than four", Toast.LENGTH_SHORT).show();
            return;
        }

        Call<LoginResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .login(userEmail, userPassword);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse loginResponse = response.body();
                if (response.isSuccessful()) {
                    if (loginResponse.getError().equals("200")) {
                        sharedPrefManager.saveUser(loginResponse.getUser());
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }

                } else {
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
=======
    private void initLayout() {
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239


    }

    private void userLogin() {
        String userMail = editTextEmail.getText().toString();
        String userPassword = editTextPassword.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (userMail.isEmpty()) {
            editTextEmail.requestFocus();
            editTextEmail.setError("Please Enter Email");
            return;
        }

        if (!userMail.matches(emailPattern)) {
            editTextEmail.requestFocus();
            editTextEmail.setError("Please Enter Valid Email");
            return;
        }

        if (userPassword.isEmpty()) {
            editTextPassword.requestFocus();
            editTextPassword.setError("Please Enter Password");
            return;
        }

        if (userPassword.length() < 5) {
            editTextPassword.requestFocus();
            editTextPassword.setError("Please Enter Valid Password");
            return;
        }

        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().login(userMail, userPassword);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (response.isSuccessful()) {

                    if (loginResponse.getError().equals("200")) {
                        sharedPrefManager.saveUser(loginResponse.getUser());
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void switchOnRegister() {

        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

<<<<<<< HEAD

=======
    @Override
    protected void onStart() {
        super.onStart();
        if (sharedPrefManager.isLoggedIn()) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
}