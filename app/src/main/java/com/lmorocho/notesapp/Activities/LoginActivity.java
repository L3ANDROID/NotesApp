package com.lmorocho.notesapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lmorocho.notesapp.Models.User;
import com.lmorocho.notesapp.R;
import com.lmorocho.notesapp.Repositories.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private EditText emailInput;
    private EditText passwordInput;
    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLogin();
            }
        });

        registerButton = findViewById(R.id.register_button_of_login);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegister();
            }
        });
    }

    private void showRegister(){
        startActivity(new Intent(this, RegisterActivity.class));
    }

    private void callLogin(){
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Login process
        User user = UserRepository.login(email, password);

        if(user == null) {
            Toast.makeText(this, "Email y/o password inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        // Go to main
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
