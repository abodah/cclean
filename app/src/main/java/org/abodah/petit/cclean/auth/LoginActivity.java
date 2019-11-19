package org.abodah.petit.cclean.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.abodah.petit.cclean.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

}
