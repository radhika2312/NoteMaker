package com.example.notemaker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class titleAdapter extends RecyclerView.Adapter<titleAdapter.ViewHolder> {
    private Context mContext;
    private List<notes> mNotes;
   // private List<String> mUserIds;
    private FirebaseUser firebaseUser;

    public titleAdapter(Context mContext, List<notes> mNotes ){
        this.mContext = mContext;

        this.mNotes=mNotes;
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.title_item, parent,false);
        return new titleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final notes Id=mNotes.get(position);
        holder.title.setText(Id.getTitle());
        Toast.makeText(mContext,"jk",Toast.LENGTH_SHORT).show();
        if(mNotes.size()!=0)
        {
            Toast.makeText(mContext,Id.getTitle(),Toast.LENGTH_SHORT).show();

        }
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, fullview.class);
                intent.putExtra("Id",Id.getId());
                //intent.putExtra("authorId",post.getPublisher());
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);

        }
    }


}
