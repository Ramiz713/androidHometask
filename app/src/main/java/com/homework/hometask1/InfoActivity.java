package com.homework.hometask1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        PlanetItem planetItem = intent.getParcelableExtra("Planet item");

        int image = planetItem.getImage();
        String name = planetItem.getName();
        int descrp = planetItem.getDescription();

        ImageView imageView = findViewById(R.id.image_info);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvDescrp = findViewById(R.id.tv_descrp);

        imageView.setImageResource(image);
        tvName.setText("Название:\n" + name);
        tvDescrp.setText("Описание: " + getString(descrp));
    }
}
