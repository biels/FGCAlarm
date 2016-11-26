package com.fgcalarm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Declare a new thread to do a preference check
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                //  Create a new boolean and preference and set it to true
                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);
                //  If the activity has never started before...
                if (isFirstStart) {
                    //  Launch app intro
                    Intent i = new Intent(MainActivity.this, IntroActivity.class);
                    startActivity(i);
                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();
                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("firstStart", false);
                    //  Apply changes
                    e.apply();
                }
            }
        });

        // Start the thread
        t.start();

        //Intent intent = new Intent(this, IntroActivity.class);
        //startActivity(intent);
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
        mRecyclerView.setAdapter(new CustomAdapter(this.getApplicationContext()));
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