package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class f2 extends AppCompatActivity {

    EditText sub;
    int x=0,y=0;
    int sd=0;
    ImageButton prof_but,log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f2);

        String check = "doctor";
        prof_but = findViewById(R.id.profile_but);
        log_out = findViewById(R.id.logout_but);

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(f2.this,LoginActivity.class));
            }
        });

        for(int i=0 ; i<6; i++){
            if (LoginActivity.email.charAt(i) == check.charAt(i)) continue;
            else{
                sd=1;
            }
        }

        if(sd==0){
            prof_but.setVisibility(Button.INVISIBLE);
        }

        int room[] = {R.id.room201, R.id.room202,R.id.room203, R.id.room204,R.id.room205, R.id.room206, R.id.room207,R.id.room208, R.id.room209,R.id.room210};

        if(sd==1){
            for (int i = 0; i < room.length; i++){
                prof_but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(f2.this,profile.class));
                    }
                });
                EditText rooms = findViewById(room[i]);
                rooms.setFocusable(false);
                rooms.setClickable(true);
            }
        }

        int qr[] = {R.id.qr201, R.id.qr202,R.id.qr203, R.id.qr204,R.id.qr205, R.id.qr206, R.id.qr207,R.id.qr208, R.id.qr209,R.id.qr210};

        for (int i = 0; i < qr.length; i++){
            ImageView qrs = findViewById(qr[i]);
            qrs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(x==0 && sd==0){
                        qrs.setColorFilter(ContextCompat.getColor(f2.this, R.color.lemon), PorterDuff.Mode.SRC_IN);
                        x=1;
                    }
                    else{
                        qrs.setColorFilter(ContextCompat.getColor(f2.this, R.color.grey), PorterDuff.Mode.SRC_IN);
                        x=0;
                    }
                }
            });
        }

        int gen[] = {R.id.gen201, R.id.gen202, R.id.gen203, R.id.gen204, R.id.gen205, R.id.gen206, R.id.gen207, R.id.gen208, R.id.gen209, R.id.gen210};

        for (int i = 0; i < gen.length; i++) {
            ImageView gens = findViewById(gen[i]);
            gens.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(x==1) {
                        if (y == 0) {
                            gens.setImageResource(R.drawable.picture15);
                            y = 1;
                        } else {
                            gens.setImageResource(R.drawable.room);
                            y = 0;
                        }
                    }
                    else{
                        gens.setImageResource(R.drawable.room);
                    }
                }
            });
        }
    }
}