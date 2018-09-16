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

    public static final int REQUEST_CODE_INFO = 111;
    public static final int REQUEST_CODE_SHARE = 222;

    private TextView textName;
    private TextView textEmail;
    private TextView textPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textName = findViewById(R.id.tv_name);
        textEmail = findViewById(R.id.tv_email);
        textPhone = findViewById(R.id.tv_phone);
        Button btnSettings = findViewById(R.id.btn_settings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivityForResult(intent, REQUEST_CODE_INFO);
            }
        });

        Button btnShare = findViewById(R.id.btn_share);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textName.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Введите свое имя", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, name);
                sendIntent.setType("text/plain");
                startActivityForResult(sendIntent, REQUEST_CODE_SHARE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_INFO) {
            if (resultCode == Activity.RESULT_OK) {
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
        if (requestCode == REQUEST_CODE_SHARE)
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Shared", Toast.LENGTH_SHORT).show();
            }
    }
}
