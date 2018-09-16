package com.homework.hometask1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceFragment;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editEmail;
    private EditText editPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });

        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editPhone = findViewById(R.id.edit_phone);

        Button btnConfirm = findViewById(R.id.btn_confirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", editName.getText().toString());
                intent.putExtra("email", editEmail.getText().toString());
                intent.putExtra("phone", editPhone.getText().toString());
                if (!editName.getText().toString().matches(".*\\w.*"))
                    editName.setError("Name is required!");
                else {
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
