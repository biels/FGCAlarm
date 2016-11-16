package com.fgcalarm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


public class CustomAdapterSelectorEstacions extends RecyclerView.Adapter<CustomAdapterSelectorEstacions.AdapterViewHolder>{

    ArrayList<Estacio> estacions = new ArrayList<>();
    Context ctx;

    CustomAdapterSelectorEstacions(Context context){
        ctx = context;

        /* TODO: DB
        LoginDataBaseAdapter loginDataBaseAdapter;
        loginDataBaseAdapter = new LoginDataBaseAdapter(context);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        String users[] = loginDataBaseAdapter.getAllUsers();
        int ranks[] = loginDataBaseAdapter.returnDescOrderedRanks();
        int nUsers = loginDataBaseAdapter.getNumberOfUsers();
        loginDataBaseAdapter.close();

        contactos = new ArrayList<>();
        for (int i = 0; i < nUsers-1; ++i) {
            contactos.add(new Contact(0,users[i],String.valueOf(ranks[i])));
        }*/

        // hardcoded: test

        estacions.add(new Estacio("Vallvidrera"));
        estacions.add(new Estacio("Vallvidrera"));
        estacions.add(new Estacio("Vallvidrera"));
        estacions.add(new Estacio("Vallvidrera"));
        estacions.add(new Estacio("Vallvidrera"));
        estacions.add(new Estacio("Vallvidrera"));
        estacions.add(new Estacio("Vallvidrera"));
        estacions.add(new Estacio("Vallvidrera"));
        estacions.add(new Estacio("Vallvidrera"));
    }


    @Override
    public CustomAdapterSelectorEstacions.AdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.row_layout_selector, viewGroup, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapterSelectorEstacions.AdapterViewHolder adapterViewholder, int position) {
        adapterViewholder.name.setText(estacions.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return estacions.size();
    }



    public class AdapterViewHolder extends RecyclerView.ViewHolder {


        public TextView name;
        public View v;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            final int x = itemView.getVerticalScrollbarPosition();
            this.v = itemView;
            this.name = (TextView) itemView.findViewById(R.id.name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Intent intent = new Intent(ctx, ActivadorActivity.class);
                    intent.putExtra("estacio", estacions.get(x).getName());
                    intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                    ctx.startActivity(intent);
                }
            });
        }

    }
}