package com.fgcalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

import static com.fgcalarm.R.drawable.s1;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.AdapterViewHolder>{

    ArrayList<Linia> linies;
    Context ctx;
    Intent intent;

    CustomAdapter(Context context){
        ctx = context;
        intent = new Intent(ctx, SelectorEstacio.class);

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
        ArrayList<Estacio> estacions = new ArrayList<>();
        estacions.add(new Estacio("Test"));

        linies = new ArrayList<>();
        linies.add(new Linia(0,"Plaça Catalunya - Terrassa Nacions Unides",estacions));
        linies.add(new Linia(1,"Plaça Catalunya - Sabadell Rambla",estacions));
        linies.add(new Linia(2,"Plaça Catalunya - Rubí",estacions));
        linies.add(new Linia(3,"Plaça Catalunya - Universitat Autònoma",estacions));
        linies.add(new Linia(4,"Plaça Espanya - Can Ros",estacions));
        linies.add(new Linia(5,"Plaça Espanya - Olesa de Montserrat",estacions));
        linies.add(new Linia(6,"Plaça Espanya - Martorell Enllaç",estacions));
        linies.add(new Linia(7,"Plaça Espanya - Manresa",estacions));
        linies.add(new Linia(8,"Plaça Espanya - Manresa",estacions));
        linies.add(new Linia(9,"Plaça Espanya - Igualada",estacions));
        linies.add(new Linia(10,"Plaça Espanya - Igualada",estacions));
        linies.add(new Linia(11, "Lleida Pirineus - La Pobla de Segur",estacions));
    }


    @Override
    public CustomAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.row_layout, viewGroup, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.AdapterViewHolder adapterViewholder, int position) {
        int iconLayout = linies.get(position).getIcon();
        switch (iconLayout){
            case 0:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s1));
                break;
            case 1:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s2));
                break;
            case 2:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s5));
                break;
            case 3:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s55));
                break;
            case 4:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s33));
                break;
            case 5:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s4));
                break;
            case 6:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.s8));
                break;
            case 7:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.r5));
                break;
            case 8:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.r50));
                break;
            case 9:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.r6));
                break;
            case 10:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.r60));
                break;
            case 11:
                adapterViewholder.icon.setImageDrawable(adapterViewholder.v.getResources().getDrawable(R.drawable.ca7));

        }
        adapterViewholder.name.setText(linies.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return linies.size();
    }



    public class AdapterViewHolder extends RecyclerView.ViewHolder {


        public ImageView icon;
        public TextView name;
        public View v;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            final int x = itemView.getVerticalScrollbarPosition();
            this.v = itemView;
            this.icon = (ImageView) itemView.findViewById(R.id.icon);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    intent.putExtra("linia", linies.get(x).getName());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ctx.startActivity(intent);
                }
            });
        }

    }
}