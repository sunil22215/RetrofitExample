package com.example.retrofitexample;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static String shared_pref_name = "theCodingShef";
    Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        this.context = context;
    }

    public void saveUser(User user) {
        sharedPreferences = context.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt("id", user.getId());
        editor.putString("username", user.getUsername());
        editor.putString("useremail", user.getEmail());
        editor.putBoolean("logged", true);
        editor.apply();

    }

    public boolean isLoggedIn() {
        sharedPreferences = context.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("logged", false);
    }

    public User getUser() {
        sharedPreferences = context.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        return new User(sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("username", null),
                sharedPreferences.getString("useremail", null));
    }

    public void logOut() {
        sharedPreferences = context.getSharedPreferences(shared_pref_name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
