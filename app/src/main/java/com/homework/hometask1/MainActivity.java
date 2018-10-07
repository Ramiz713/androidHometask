package com.homework.hometask1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlanetsAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<PlanetItem> planetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createPlanets();

        recyclerView = findViewById(R.id.rv_planets);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new PlanetsAdapter(planetList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PlanetsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("Planet item", planetList.get(position));
                startActivity(intent);
            }
        });
    }

    private void createPlanets(){
        planetList = new ArrayList<>();
        planetList.add(new PlanetItem(R.drawable.mercury, "Меркурий", R.string.merc_descrp));
        planetList.add(new PlanetItem(R.drawable.venus, "Венера", R.string.venus_descrp));
        planetList.add(new PlanetItem(R.drawable.earth, "Земля", R.string.earth_descrp));
        planetList.add(new PlanetItem(R.drawable.mars, "Марс", R.string.mars_descrp));
        planetList.add(new PlanetItem(R.drawable.jupiter, "Юпитер", R.string.jupiter_descrp));
        planetList.add(new PlanetItem(R.drawable.saturn, "Сатурн", R.string.saturn_descrp));
    }
}
