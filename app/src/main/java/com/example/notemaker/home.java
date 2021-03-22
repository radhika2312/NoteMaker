package com.example.notemaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.notemaker.Adapter.ListAdapter;
import com.example.notemaker.Adapter.titleAdapter;
import com.example.notemaker.model.notes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {

    ImageView add;
    private RecyclerView recyclerView;
    private ListAdapter Adapter1;
    private List<notes> mNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        add=findViewById(R.id.add);

        //setting up recycler view
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mNotes=new ArrayList<>();

        /*FirebaseDatabase.getInstance().getReference().child("Post").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mNotes.clear();

                for(DataSnapshot Snapshot:snapshot.getChildren())
                {
                    notes i=Snapshot.getValue(notes.class);
                    if(i.getUserId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid()))
                    {
                        mNotes.add(i);
                        Toast.makeText(home.this,i.getTitle(),Toast.LENGTH_SHORT).show();

                    }
                }

                //Adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        Adapter1 = new ListAdapter(this, mNotes);
        recyclerView.setAdapter(Adapter1);

        FirebaseDatabase.getInstance().getReference().child("Post").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mNotes.clear();

                for(DataSnapshot Snapshot:snapshot.getChildren())
                {
                    notes i=Snapshot.getValue(notes.class);
                    if(i.getUserId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid()))
                    {
                        mNotes.add(i);
                        //Toast.makeText(home.this,i.getTitle(),Toast.LENGTH_SHORT).show();

                    }
                }

                Adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this,note.class));
                finish();
            }
        });
    }
}