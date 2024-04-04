package com.example.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class userAdaptor extends RecyclerView.Adapter<userAdaptor.ViewHolder> {
    MainActivity mainActivity;
    List<UserModel> alluserslist;
    public userAdaptor(MainActivity mainActivity, List<UserModel> alluserslist) {
    this.mainActivity=mainActivity;
    this.alluserslist=alluserslist;

    }

    @NonNull
    @Override
    public userAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mainActivity).inflate(R.layout.item_user,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull userAdaptor.ViewHolder holder, int position) {
holder.textView.setText(alluserslist.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return alluserslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview);
        }
    }
}
