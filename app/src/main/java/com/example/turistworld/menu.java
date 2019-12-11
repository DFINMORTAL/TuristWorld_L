package com.example.turistworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    public static String user;
    Button mapa;
    Button lugares;
    Button brujula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mapa =(Button)findViewById(R.id.btmapa);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mapa = new Intent(menu.this, MapsActivity.class);
                startActivity(mapa);

            }
        });
        lugares =(Button)findViewById(R.id.btlugares);
        lugares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent lugares = new Intent(menu.this, lugares.class);
                startActivity(lugares);

            }
        });
        brujula =(Button)findViewById(R.id.btbrujula);
        brujula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent brujula = new Intent(menu.this, brujula.class);
                startActivity(brujula);

            }
        });


    }
}
