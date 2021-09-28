package com.example.areturn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        int[] imageId = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
                R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i};

        String[] name = {"Галя","","","","","","","",""};
        String[] lastMessage = {"Отмена","","","","","","","",""};
        String[] lastMsgTime = {"13:13","","","","","","","",""};
        String[] phoneNo = {"8(800)200-90-02","","","","","","","",""};
        String[] country = {"Магнит!","","","","","","","",""};

        ArrayList<User>userArrayList = new ArrayList<>();

        for (int i = 0;i<imageId.length;i++) {
            User user = new User(name[i],lastMessage[i],lastMsgTime[i],phoneNo[i],country[i],imageId[i]);


            userArrayList.add(user);
        }
        ListAdapter listadapter = new ListAdapter(MainActivity.this,userArrayList);
        listView.setAdapter(listadapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,UserActivity.class);
                intent.putExtra("name",name[i]);
                intent.putExtra("phone",phoneNo[i]);
                intent.putExtra("country",country[i]);
                intent.putExtra("imageid",imageId[i]);
                startActivity(intent);
            }
        });

    }
}