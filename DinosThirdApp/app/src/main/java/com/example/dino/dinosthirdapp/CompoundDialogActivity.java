package com.example.dino.dinosthirdapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CompoundDialogActivity extends AppCompatActivity {

    private Button back2Main, compoundDialogButton;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_dialog);

        back2Main = (Button) findViewById(R.id.back2Main);
        compoundDialogButton = (Button) findViewById(R.id.compundDialogButton);

        final String nameTextBox = getIntent().getStringExtra("name");

        final AlertDialog.Builder dialogConfig = new AlertDialog.Builder(this);


        back2Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back2Main = new Intent(CompoundDialogActivity.this, MainActivity.class);
                back2Main.putExtra("name", nameTextBox);
                startActivity(back2Main);
            }
        });

        compoundDialogButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v){
                //something to show the compound dialog
               context = getApplicationContext();
               dialogConfig.setTitle("A compound dialog");
               dialogConfig.setMessage("This dialog was initiated by : " + nameTextBox);
               dialogConfig.setIcon(R.mipmap.ic_launcher);

               dialogConfig.setNeutralButton("Close", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog , int id) {
                       Toast.makeText(context, "Dialog closed.", Toast.LENGTH_SHORT).show();
                   }
               });

               dialogConfig.setPositiveButton("Yes",
                       new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                               Toast.makeText(context, nameTextBox + " answered with Yes.", Toast.LENGTH_LONG).show();

                           }
                       });

               dialogConfig.setNegativeButton("No",
                       new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int id) {
                               Toast.makeText(context, nameTextBox + " answered with No.", Toast.LENGTH_LONG).show();
                           }
                       });

               AlertDialog simpleDialog = dialogConfig.create();
               simpleDialog.show();
           }
        });
    }
}
