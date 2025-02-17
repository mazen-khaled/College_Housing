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

public class f3 extends AppCompatActivity {
    int x = 0, y = 0;
    int sd = 0;
    ImageButton prof_but, log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f3);

        String check = "doctor";
        for (int i = 0; i < 6; i++) {
            if (LoginActivity.email.charAt(i) == check.charAt(i)) continue;
            else {
                sd = 1;
            }
        }
        prof_but = findViewById(R.id.profile_but);
        log_out = findViewById(R.id.logout_but);


        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(f3.this, LoginActivity.class));
            }
        });

        int room[] = {R.id.room301, R.id.room302, R.id.room303, R.id.room304, R.id.room305, R.id.room306, R.id.room307, R.id.room308, R.id.room309, R.id.room310};

        if (sd == 1) {
            for (int i = 0; i < room.length; i++) {
                prof_but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(f3.this, profile.class));
                    }
                });
                EditText rooms = findViewById(room[i]);
                rooms.setFocusable(false);
                rooms.setClickable(true);
            }
        }

        int qr[] = {R.id.qr301, R.id.qr302, R.id.qr303, R.id.qr304, R.id.qr305, R.id.qr306, R.id.qr307, R.id.qr308, R.id.qr309, R.id.qr310};

        for (int i = 0; i < qr.length; i++) {
            ImageView qrs = findViewById(qr[i]);
            qrs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (x == 0 && sd == 0) {
                        qrs.setColorFilter(ContextCompat.getColor(f3.this, R.color.lemon), PorterDuff.Mode.SRC_IN);
                        x = 1;
                    } else {
                        qrs.setColorFilter(ContextCompat.getColor(f3.this, R.color.grey), PorterDuff.Mode.SRC_IN);
                        x = 0;
                    }
                }
            });
        }
        if(sd==0){
            prof_but.setVisibility(Button.INVISIBLE);
        }

        int gen[] = {R.id.gen301, R.id.gen302, R.id.gen303, R.id.gen304, R.id.gen305, R.id.gen306, R.id.gen307, R.id.gen308, R.id.gen309, R.id.gen310};

        for (int i = 0; i < gen.length; i++) {
            ImageView gens = findViewById(gen[i]);
            gens.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (x == 1) {
                        if (y == 0) {
                            gens.setImageResource(R.drawable.picture15);
                            y = 1;
                        } else {
                            gens.setImageResource(R.drawable.room);
                            y = 0;
                        }
                    } else {
                        gens.setImageResource(R.drawable.room);
                    }
                }
            });
        }
    }
}