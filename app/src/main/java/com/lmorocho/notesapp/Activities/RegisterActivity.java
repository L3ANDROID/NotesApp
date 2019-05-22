package com.lmorocho.notesapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lmorocho.notesapp.R;
import com.lmorocho.notesapp.Repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText fullnameInput;
    private EditText emailInput;
    private EditText passwordnput;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameInput = findViewById(R.id.username_input);
        fullnameInput = findViewById(R.id.fullname_input);
        emailInput = findViewById(R.id.email_input);
        passwordnput = findViewById(R.id.password_input);
        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRegister();
            }
        });
    }

    private void callRegister(){
        try {
            String username = usernameInput.getText().toString();
            String fullname = fullnameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordnput.getText().toString();

            if (username.isEmpty() || fullname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            UserRepository.create(username, fullname, email, password);

            Toast.makeText(this, "Registro satisfactorio", Toast.LENGTH_SHORT).show();

            finish();

        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
