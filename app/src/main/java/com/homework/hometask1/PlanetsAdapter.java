package com.homework.hometask1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.PlanetsHolder> {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private ArrayList<PlanetItem> planetList;
    private OnItemClickListener listener;

    public PlanetsAdapter(ArrayList<PlanetItem> list) {
        planetList = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlanetsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planet, parent, false);
        return new PlanetsHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetsHolder holder, int position) {
        PlanetItem item = planetList.get(position);
        holder.bind(item.getName(), item.getImage());
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public class PlanetsHolder extends RecyclerView.ViewHolder {
        private ImageView planetImage;
        private TextView planetName;

        public PlanetsHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            planetImage = itemView.findViewById(R.id.planet_image);
            planetName = itemView.findViewById(R.id.planet_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

        public void bind(String name, int image) {
            planetName.setText(name);
            planetImage.setImageResource(image);
        }
    }
}
