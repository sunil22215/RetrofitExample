package com.example.retrofitexample;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
<<<<<<< HEAD
    private static String shared_pref_name = "theCodingShef";
=======
    private static String shared_pref_name = "codingshef";
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
    Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        this.context = context;
<<<<<<< HEAD
=======

>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
    }

    public void saveUser(User user) {
        sharedPreferences = context.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt("id", user.getId());
        editor.putString("username", user.getUsername());
<<<<<<< HEAD
        editor.putString("useremail", user.getEmail());
        editor.putBoolean("logged", true);
        editor.apply();

=======
        editor.putString("email", user.getEmail());
        editor.putBoolean("logged", true);
        editor.apply();
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
    }

    public boolean isLoggedIn() {
        sharedPreferences = context.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("logged", false);
    }

    public User getUser() {
        sharedPreferences = context.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        return new User(sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("username", null),
<<<<<<< HEAD
                sharedPreferences.getString("useremail", null));
    }

    public void logOut() {
=======
                sharedPreferences.getString("email", null));

    }

    void logout() {
>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
        sharedPreferences = context.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
<<<<<<< HEAD
=======

>>>>>>> 004173b205b6d4d245ce77e901d138d9c3427239
    }
}
