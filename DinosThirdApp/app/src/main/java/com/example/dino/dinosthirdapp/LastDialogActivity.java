package com.example.dino.dinosthirdapp;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class LastDialogActivity extends AppCompatActivity {

    private Button lastDialogButton, back2Main;

    private String nameTextBox;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_dialog);

        context = getApplicationContext();

        lastDialogButton = (Button) findViewById(R.id.lastDialogButton);
        back2Main = (Button) findViewById(R.id.back2Main);

        nameTextBox = getIntent().getStringExtra("name");

        final NotificationCompat.Builder NotifBuilder = new NotificationCompat.Builder(this);

        lastDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // something to show the last dialog
                int NOTIF_ID = 1234;

                NotifBuilder.setSmallIcon(R.mipmap.ic_launcher);
                NotifBuilder.setContentTitle("Important Notification");
                NotifBuilder.setContentText("This notification was created by " + nameTextBox);

                Intent notificationIntent = new Intent(LastDialogActivity.this, MainActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
                NotifBuilder.setContentIntent(contentIntent);

                NotificationManager MyNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                MyNotification.notify(NOTIF_ID, NotifBuilder.build());
            }
        });

        back2Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back2Main = new Intent(LastDialogActivity.this, MainActivity.class);
                back2Main.putExtra("name", nameTextBox);
                startActivity(back2Main);
            }
        });

    }
}
