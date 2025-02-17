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

public class f4 extends AppCompatActivity {
    int x=0,y=0;
    int sd=0;
    ImageButton prof_but,log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f4);
        String check = "doctor";
        for(int i=0 ; i<6; i++){
            if (LoginActivity.email.charAt(i) == check.charAt(i)) continue;
            else{
                sd=1;
            }
        }


        prof_but = findViewById(R.id.profile_but);
        log_out = findViewById(R.id.logout_but);

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(f4.this,LoginActivity.class));
            }
        });

        int room[] = {R.id.room401, R.id.room402,R.id.room403, R.id.room404,R.id.room405, R.id.room406, R.id.room407,R.id.room408, R.id.room409,R.id.room410};

        if(sd==1){
            for (int i = 0; i < room.length; i++){
                prof_but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(f4.this,profile.class));
                    }
                });
                EditText rooms = findViewById(room[i]);
                rooms.setFocusable(false);
                rooms.setClickable(true);
            }
        }

        int qr[] = {R.id.qr401, R.id.qr402,R.id.qr403, R.id.qr404,R.id.qr405, R.id.qr406, R.id.qr407,R.id.qr408, R.id.qr409,R.id.qr410};

        for (int i = 0; i < qr.length; i++){
            ImageView qrs = findViewById(qr[i]);
            qrs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(x==0 && sd==0){
                        qrs.setColorFilter(ContextCompat.getColor(f4.this, R.color.lemon), PorterDuff.Mode.SRC_IN);
                        x=1;
                    }
                    else{
                        qrs.setColorFilter(ContextCompat.getColor(f4.this, R.color.grey), PorterDuff.Mode.SRC_IN);
                        x=0;
                    }
                }
            });
        }

        int gen[] = {R.id.gen401, R.id.gen402, R.id.gen403, R.id.gen404, R.id.gen405, R.id.gen406, R.id.gen407, R.id.gen408, R.id.gen409, R.id.gen410};

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

        if(sd==0){
            prof_but.setVisibility(Button.INVISIBLE);
        }

    }

}