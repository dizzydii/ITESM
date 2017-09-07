package com.example.dino.dinosthirdapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    private Button back2Main, toastButton;
    private String nameTextBox;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        nameTextBox = getIntent().getStringExtra("name");

        back2Main = (Button) findViewById(R.id.back2main);
        toastButton = (Button) findViewById(R.id.toastDialog);

        context = getApplicationContext();

        final Toast toastMessage = Toast.makeText(context, "This toast message display was initiated by : " + nameTextBox, Toast.LENGTH_LONG);
        // Creating a toast object and populating it with the context, the message and the display lenght


        back2Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back2Main = new Intent(ToastActivity.this, MainActivity.class);
                back2Main.putExtra("name", nameTextBox);
                startActivity(back2Main);
            }
        });

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMessage.show();

            }
        });
    }
}
