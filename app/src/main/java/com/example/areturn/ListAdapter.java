package com.example.areturn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<User> {
    public ListAdapter(@NonNull Context context, ArrayList<User> userArrayList) {
        super(context, R.layout.item_list, (List<User>)userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = getItem(position);
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.item_list,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView userName = convertView.findViewById(R.id.personName);
        TextView lstMsg = convertView.findViewById(R.id.lastMessage);
        TextView time = convertView.findViewById(R.id.msgtime);

        imageView.setImageResource(user.imageId);
        userName.setText(user.name);
        lstMsg.setText(user.lastMessage);
        time.setText(user.lastMsgTime);

        return convertView;
    }
}
