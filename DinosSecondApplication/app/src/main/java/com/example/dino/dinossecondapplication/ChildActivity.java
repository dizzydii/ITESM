package com.example.dino.dinossecondapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class ChildActivity extends AppCompatActivity {
    private int internalCounter;
    Button changeActivity, changeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        internalCounter = 0;

        changeActivity = (Button) findViewById(R.id.childChangeActivity2Main);
        changeColor = (Button) findViewById(R.id.childChangeColor);

        changeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeActivity2Main = new Intent(ChildActivity.this, MainActivity.class);
                startActivity(changeActivity2Main);
            }
        });

        if ( changeColor != null) {
            changeColor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    internalCounter++;
                    switch (internalCounter % 4) {
                        case 0:
                            changeBackgroundColor(Color.WHITE);
                            break;
                        case 1:
                            changeBackgroundColor(Color.CYAN);
                            break;
                        case 2:
                            changeBackgroundColor(Color.GREEN);
                            break;
                        case 3:
                            changeBackgroundColor(Color.RED);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }

    private void changeBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}
