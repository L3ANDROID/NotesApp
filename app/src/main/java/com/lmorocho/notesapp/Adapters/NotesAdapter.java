package com.lmorocho.notesapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lmorocho.notesapp.Models.Note;
import com.lmorocho.notesapp.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<Note> notas;

    public NotesAdapter(List<Note> notas){
        this.notas = notas;
    }

    public void setNotas(List<Note> notas) {
        this.notas = notas;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView description;
        public TextView fecha;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text);
            description = itemView.findViewById(R.id.description_text);
            fecha = itemView.findViewById(R.id.fecha_text);
        }
    }

    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NotesAdapter.ViewHolder viewHolder, int position) {
        Note notas = this.notas.get(position);
        viewHolder.title.setText(notas.getTitle());
        viewHolder.description.setText(notas.getDescription());
        viewHolder.fecha.setText(notas.getDate());
    }

    @Override
    public int getItemCount() {
        return this.notas.size();
    }

}

