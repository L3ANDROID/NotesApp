package com.lmorocho.notesapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.lmorocho.notesapp.R;
import com.lmorocho.notesapp.Repositories.NoteRepository;

public class AddNoteActivity extends AppCompatActivity {

    private EditText titleInput;
    private EditText descriptionInput;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        titleInput = findViewById(R.id.title_input);
        descriptionInput = findViewById(R.id.description_input);
        registerButton = findViewById(R.id.register_note_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void register(){
        try {
            Date fecha = new Date();
            String nowString = new SimpleDateFormat("dd/MM/YYYY").format(fecha);
            String titulo = titleInput.getText().toString();
            String descripcion = descriptionInput.getText().toString();

            if(titulo.isEmpty() || descripcion.isEmpty()){
                Toast.makeText(this, "You must complete these fields", Toast.LENGTH_SHORT).show();
                return;
            }

            NoteRepository.create(nowString,titulo,descripcion);

            Toast.makeText(this, "Registro satisfactorio", Toast.LENGTH_SHORT).show();

            finish();

        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
