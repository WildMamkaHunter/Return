package com.example.areturn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {
    TextView name_profile,phone_profile,country_profile;
    ImageView profile_image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        name_profile=findViewById(R.id.name_profile);
        phone_profile=findViewById(R.id.phone_profile);
        country_profile=findViewById(R.id.country_profile);
        profile_image=findViewById(R.id.profile_image);

        Intent intent2 = this.getIntent();
        if (intent2!=null){
            String name = intent2.getStringExtra("name");
            String phone = intent2.getStringExtra("phone");
            String country = intent2.getStringExtra("country");
            int imageid = intent2.getIntExtra("imageid",R.drawable.a);

            name_profile.setText(name);
            phone_profile.setText(phone);
            country_profile.setText(country);
            profile_image.setImageResource(imageid);

        }

    }
}
