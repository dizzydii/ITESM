package com.example.dino.dinosthirdapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private Button showDialog, back2Main;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        context = getApplicationContext();


        showDialog = (Button) findViewById(R.id.dialogButton);
        back2Main = (Button) findViewById(R.id.back2Main);

        final String nameTextBox = getIntent().getStringExtra("name");

        final AlertDialog.Builder dialogConfig = new AlertDialog.Builder(this);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something to show the dialog
                dialogConfig.setTitle("A simple dialog");
                dialogConfig.setMessage("This dialog was initiated by : " + nameTextBox);
                dialogConfig.setIcon(R.mipmap.ic_launcher);

                dialogConfig.setNeutralButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog , int id) {
                        Toast.makeText(context, "Dialog closed.", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog simpleDialog = dialogConfig.create();
                simpleDialog.show();
            }
        });




        back2Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back2Main = new Intent(DialogActivity.this, MainActivity.class);
                back2Main.putExtra("name", nameTextBox);
                startActivity(back2Main);
            }
        });

    }
}
