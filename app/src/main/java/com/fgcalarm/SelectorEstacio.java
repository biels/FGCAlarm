package com.fgcalarm;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;



public class SelectorEstacio extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("linia");
            //The key argument here must match that used in the other activity
        }

        setContentView(R.layout.activity_selector);

        /*LoginDataBaseAdapter loginDataBaseAdapter;
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        loginDataBaseAdapter.insertEntry("Usuari1", "123",0);
        loginDataBaseAdapter.insertEntry("Usuari2", "123",3);
        loginDataBaseAdapter.insertEntry("Usuari3", "123",1);
        loginDataBaseAdapter.getAllUsers();
        Log.v("users", Arrays.toString(loginDataBaseAdapter.getAllUsers()));
        loginDataBaseAdapter.close();*/


        //findViewById del layout activity_main
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);

       /* mRecyclerView.addOnItemTouchListener((new RecyclerItemClickListener(this,
                new OnItemClickListener())));*/

        //LinearLayoutManager necesita el contexto de la Activity.
        //El LayoutManager se encarga de posicionar los items dentro del recyclerview
        //Y de definir la politica de reciclaje de los items no visibles.
        mLinearLayout = new LinearLayoutManager(this);

        //Asignamos el LinearLayoutManager al recycler:
        mRecyclerView.setLayoutManager(mLinearLayout);


        //El adapter se encarga de  adaptar un objeto definido en el c�digo a una vista en xml
        //seg�n la estructura definida.
        //Asignamos nuestro custom Adapter
        mRecyclerView.setAdapter(new CustomAdapterSelectorEstacions(this.getApplicationContext()));
    }

    /*private class OnItemClickListener extends RecyclerItemClickListener.SimpleOnItemClickListener {

        @Override
        public void onItemClick(View childView, int position) {
            // Do something when an item is clicked, or override something else.
            final Intent intent = new Intent(childView.getContext(), SelectorEstacio.class);
            switch (position) {
                case 0:
                    break;
                case 1:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            intent.putExtra("linia",Linies position);
            startActivity(intent);
        }

    }*/

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ranking_menu, menu);
        return true;
    }*

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}