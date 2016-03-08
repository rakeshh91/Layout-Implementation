package com.rakesh_ap2016.hw2_rakeshne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CalculatorLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator_layout);
        setTitle("Task 3");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==R.id.coverPage){
            Intent i = new Intent(this,com.rakesh_ap2016.hw2_rakeshne.MainActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.task1) {
            Intent i = new Intent(this, com.rakesh_ap2016.hw2_rakeshne.LinearLayout.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.task2) {
            Intent i = new Intent(this, com.rakesh_ap2016.hw2_rakeshne.GridLayout.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.task3) {
            Intent i = new Intent(this, com.rakesh_ap2016.hw2_rakeshne.CalculatorLayout.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.task4) {
            Intent i = new Intent(this, com.rakesh_ap2016.hw2_rakeshne.MovieImage.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
