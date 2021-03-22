package com.example.notemaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.EditText;

import com.example.notemaker.model.notes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class fullview extends AppCompatActivity {
    private EditText title;
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullview);

        Intent intent=getIntent();
        String Id=intent.getStringExtra("Id");

        title=findViewById(R.id.title);
        web=findViewById(R.id.web);

        FirebaseDatabase.getInstance().getReference().child("Post").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot s:snapshot.getChildren())
                {
                    notes i=s.getValue(notes.class);
                    if(i.getId().equals(Id))
                    {
                        title.setText(i.getTitle());
                        web.loadDataWithBaseURL(null,i.getNote(),"text/html","utf-8",null);


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}