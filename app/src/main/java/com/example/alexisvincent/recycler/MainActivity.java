package com.example.alexisvincent.recycler;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton cameraB = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        cameraB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });


        ImageButton plasticB = (ImageButton) findViewById(R.id.imgB_plastic);
        plasticB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PlasticActivity.class));
            }
        });

        ImageButton paperB = (ImageButton) findViewById(R.id.imgB_paper);
        paperB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PlasticActivity.class));
            }
        });
        ImageButton aluminumB = (ImageButton) findViewById(R.id.imgB_aluminum);
        aluminumB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PlasticActivity.class));
            }
        });
        ImageButton landfillB = (ImageButton) findViewById(R.id.imgB_landfill);
        landfillB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PlasticActivity.class));
            }
        });

    }

    }
