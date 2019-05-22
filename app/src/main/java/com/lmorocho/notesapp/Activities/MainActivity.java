package com.lmorocho.notesapp.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lmorocho.notesapp.Adapters.NotesAdapter;
import com.lmorocho.notesapp.Models.Note;
import com.lmorocho.notesapp.R;
import com.lmorocho.notesapp.Repositories.NoteRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton add;

    private static final int REGISTER_FORM_REQUEST = 100;
    private RecyclerView notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add_note_b);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
            }
        });

        // Configure ReciclerView con un LinearLayout
        notesList = findViewById(R.id.notes_list);
        notesList.setLayoutManager(new LinearLayoutManager(this));

        // El recyclerview requiere de un ‘adaptador’ el cual contiene la lista de usuarios a mostrar, y para ello ‘infla’ un layout llamado ítem_user.xml.
        List<Note> notas = NoteRepository.listar();
        notesList.setAdapter(new NotesAdapter(notas));


    }
    //Yendo a AddNoteActivity
    public void addNote() {
        startActivityForResult(new Intent(this, AddNoteActivity.class), REGISTER_FORM_REQUEST);
    }

    // return from AddNoteActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        NotesAdapter adapter = (NotesAdapter)notesList.getAdapter();

        //Obteniemos del repository la lista de usuarios actualizada.
        List<Note> notas = NoteRepository.listar();
        adapter.setNotas(notas);
        adapter.notifyDataSetChanged();

    }
}
