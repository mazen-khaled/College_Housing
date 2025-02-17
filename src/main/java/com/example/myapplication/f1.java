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

public class f1 extends AppCompatActivity {
    EditText sub;
    int x=0,y=0;
    int sd=0;
    ImageButton prof_but,log_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1);
        sub = findViewById(R.id.room101);

        String check = "doctor";
        prof_but = findViewById(R.id.profile_but);
        log_out = findViewById(R.id.logout_but);

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(f1.this,LoginActivity.class));
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

        int room[] = {R.id.room101, R.id.room102,R.id.room103, R.id.room104,R.id.room105, R.id.room106, R.id.room107,R.id.room108, R.id.room109,R.id.room110};

        if(sd==1){
            for (int i = 0; i < room.length; i++){
                prof_but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(f1.this,profile.class));
                    }
                });
                EditText rooms = findViewById(room[i]);
                rooms.setFocusable(false);
                rooms.setClickable(true);
            }
        }

        int qr[] = {R.id.qr101, R.id.qr102,R.id.qr103, R.id.qr104,R.id.qr105, R.id.qr106, R.id.qr107,R.id.qr108, R.id.qr109,R.id.qr110};

        for (int i = 0; i < qr.length; i++){
            ImageView qrs = findViewById(qr[i]);
            qrs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(x==0 && sd==0){
                        qrs.setColorFilter(ContextCompat.getColor(f1.this, R.color.lemon), PorterDuff.Mode.SRC_IN);
                        x=1;
                    }
                    else{
                        qrs.setColorFilter(ContextCompat.getColor(f1.this, R.color.grey), PorterDuff.Mode.SRC_IN);
                        x=0;
                    }
                }
            });
        }

        int gen[] = {R.id.gen101, R.id.gen102, R.id.gen103, R.id.gen104, R.id.gen105, R.id.gen106, R.id.gen107, R.id.gen108, R.id.gen109, R.id.gen110};

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