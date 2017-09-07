package com.example.dino.dinosthirdapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button compoundDialog, dialog, lastDialog, toast;
    private EditText nameTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextBox = (EditText) findViewById(R.id.nameTextBox);

        nameTextBox.setText(getIntent().getStringExtra("name"));

        compoundDialog = (Button) findViewById(R.id.main2CompoundDialog);
        compoundDialog.setOnClickListener(this);
        dialog = (Button) findViewById(R.id.main2Dialog);
        dialog.setOnClickListener(this);
        lastDialog = (Button) findViewById(R.id.main2LastDialog);
        lastDialog.setOnClickListener(this);
        toast = (Button) findViewById(R.id.main2Toast);
        toast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) { // a small event handler
        switch (v.getId()) {
            case R.id.main2CompoundDialog:
                Intent change2CompoundDialog = new Intent(MainActivity.this, CompoundDialogActivity.class);
                change2CompoundDialog.putExtra("name", nameTextBox.getText().toString());
                startActivity(change2CompoundDialog);
                break;
            case R.id.main2Dialog:
                Intent change2Dialog = new Intent(MainActivity.this, DialogActivity.class);
                change2Dialog.putExtra("name", nameTextBox.getText().toString());
                startActivity(change2Dialog);
                break;
            case R.id.main2LastDialog:
                Intent change2LastDialog = new Intent(MainActivity.this, LastDialogActivity.class);
                change2LastDialog.putExtra("name", nameTextBox.getText().toString());
                startActivity(change2LastDialog);
                break;
            case R.id.main2Toast:
                Intent change2Toast = new Intent(MainActivity.this, ToastActivity.class);
                change2Toast.putExtra("name", nameTextBox.getText().toString());
                startActivity(change2Toast);
                break;
            default:
                break;
        }
    }
}
