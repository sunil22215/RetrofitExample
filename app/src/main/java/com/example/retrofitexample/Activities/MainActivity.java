package com.example.retrofitexample.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitexample.R;
import com.example.retrofitexample.RetrofitClient;
import com.example.retrofitexample.modelResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView textViewLogin;
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initLayout();
        setListenerWithView();

    }

    private void initLayout() {
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        textViewLogin = findViewById(R.id.textViewLogin);
    }


    private void setListenerWithView() {
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchOnLogin();
            }
        });

    }


    private void registerUser() {
        String userName = editTextName.getText().toString();
        String userEmail = editTextEmail.getText().toString();
        String userPassword = editTextPassword.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (userName.isEmpty()) {
            editTextName.requestFocus();
            editTextName.setError("Please Enter your Name");
            return;
        }

        if (userEmail.isEmpty()) {
<<<<<<< HEAD
            Toast.makeText(this, "enter user email", Toast.LENGTH_SHORT).show();
=======
           editTextEmail.requestFocus();
           editTextEmail.setError("Enter your Email");
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
            return;
        }

        if (!userEmail.matches(emailPattern)) {
<<<<<<< HEAD
            Toast.makeText(this, "enter valid email", Toast.LENGTH_SHORT).show();
=======
          editTextEmail.requestFocus();
          editTextEmail.setError("Enter Valid Email");
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
            return;
        }

        if (userPassword.isEmpty()) {
<<<<<<< HEAD
            Toast.makeText(this, "enter user password", Toast.LENGTH_SHORT).show();
=======
           editTextPassword.requestFocus();
           editTextPassword.setError("Please Enter Your Password");
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
            return;
        }

        if (userPassword.length() < 5) {
<<<<<<< HEAD
            Toast.makeText(this, "password length must be greater than four", Toast.LENGTH_SHORT).show();
=======
           editTextPassword.requestFocus();
           editTextPassword.setError("Password Lenght");
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
            return;
        }


        Call<RegisterResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .register(userName, userEmail, userPassword);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                RegisterResponse registerResponse = response.body();
                if (response.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                    Toast.makeText(MainActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void switchOnLogin() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}
