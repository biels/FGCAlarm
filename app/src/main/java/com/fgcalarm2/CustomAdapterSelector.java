package com.fgcalarm2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fgcalarm2.model.entities.Line;
import com.fgcalarm2.model.entities.Station;
import com.fgcalarm2.model.persistence.RepositoryManager;

import java.util.ArrayList;


public class CustomAdapterSelector extends RecyclerView.Adapter<CustomAdapterSelector.AdapterViewHolder>{

    Context ctx;
    Intent intent;
    ArrayList<Station> stations;
    int linia_id_p;
    Long hola;

    CustomAdapterSelector(Context context, int linia_id){
        ctx = context;
        intent = new Intent(ctx, ProxAlertActivity.class);
        linia_id_p = linia_id;


        stations = new ArrayList<>();
        Line line = RepositoryManager.getLineRepository().findAll().get(linia_id);
        hola = line.getId();
        Log.v("hola",String.valueOf(linia_id));
        for (int i = 0; i < line.getStations().size(); i++) {
            stations.add(line.getStations().get(i));
        }

    }


    @Override
    public CustomAdapterSelector.AdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.row_layout_selector, viewGroup, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapterSelector.AdapterViewHolder adapterViewholder, int position) {
       adapterViewholder.name.setText(stations.get(position).getName());
        adapterViewholder.position = position;

    }

    @Override
    public int getItemCount() {
        return stations.size();
    }



    public class AdapterViewHolder extends RecyclerView.ViewHolder {


        public int position;
        public ImageView icon;
        public TextView name;
        public View v;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            final int x = itemView.getVerticalScrollbarPosition();
            this.v = itemView;
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent.putExtra("estacio", stations.get(position).getName());
                    intent.putExtra("station_id",stations.get(position).getId());
                    intent.putExtra("pseudo_station_id",position);
                    intent.putExtra("linia_id",linia_id_p);
                    intent.putExtra("hola",hola);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ctx.startActivity(intent);
                }
            });
        }

    }
}