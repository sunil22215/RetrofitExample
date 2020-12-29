package com.example.retrofitexample.modelResponse;

import com.example.retrofitexample.User;

public class LoginResponse {
<<<<<<< HEAD

=======
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
    User user;
    private String error;
    private String message;

    public LoginResponse(User user, String error, String message) {
        this.user = user;
        this.error = error;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
