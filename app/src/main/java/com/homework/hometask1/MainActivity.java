package com.homework.hometask1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textName;
    private TextView textEmail;
    private TextView textPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSettings = findViewById(R.id.btn_settings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        Button btnShare = findViewById(R.id.btn_share);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textName == null) {
                    Toast.makeText(MainActivity.this, "Введите свое имя", Toast.LENGTH_SHORT).show();
                    return;
                }
                String name = textName.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, name);
                sendIntent.setType("text/plain");
                startActivityForResult(sendIntent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                textName = findViewById(R.id.name);
                textEmail = findViewById(R.id.email);
                textPhone = findViewById(R.id.phone);
                if (data != null) {
                    Toast.makeText(this, "Confirmed", Toast.LENGTH_SHORT).show();
                    textName.setText(data.getStringExtra("name"));
                    textEmail.setText(data.getStringExtra("email"));
                    textPhone.setText(data.getStringExtra("phone"));
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == 2)
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Shared", Toast.LENGTH_SHORT).show();
            }
    }
}