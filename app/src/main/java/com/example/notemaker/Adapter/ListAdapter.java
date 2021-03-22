package com.example.notemaker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notemaker.R;
import com.example.notemaker.fullview;
import com.example.notemaker.model.notes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Context mContext;
    private List<notes> mArticles;
    private FirebaseUser firebaseUser;


    public ListAdapter(Context mContext, List<notes> mArticles) {
        this.mContext = mContext;
        this.mArticles = mArticles;
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.title_item, parent,false);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        final notes note=mArticles.get(position);
        //Toast.makeText(mContext,"hey",Toast.LENGTH_SHORT).show();
        holder.title.setText(note.getTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, fullview.class);
                intent.putExtra("Id",note.getId());
                //intent.putExtra("authorId",post.getPublisher());
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);

        }
    }
}
