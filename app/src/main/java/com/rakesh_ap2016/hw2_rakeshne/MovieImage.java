package com.rakesh_ap2016.hw2_rakeshne;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by rakeshh91 on 2/1/2016.
 */
public class MovieImage extends AppCompatActivity {

    MovieData movieData = null;
    ImageView imageView;
    SeekBar seekBar;
    GestureDetectorCompat mDetector;
    int i = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie_data);
        setTitle("Task 4");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = (ImageView) findViewById(R.id.movieImageView);
        movieData = new MovieData();
        HashMap movie = movieData.getItem(0);
        int imageId = (Integer) movie.get("image");
        final String movieName = (String) movie.get("name");
        imageView.setImageResource(imageId);
        seekBar = (SeekBar) findViewById(R.id.imageSeekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                params.width = progress * 10;
                params.height = progress * 10;
                imageView.setLayoutParams(params);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int progress = 50;
                seekBar.setProgress(progress);
                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                params.height = progress * 10;
                params.width = progress * 10;
                imageView.setLayoutParams(params);
                return true;
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "The Movie Name is " + movieName, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 310);
                toast.show();
                Snackbar snackbar = Snackbar.make(v, "The Movie Name is " + movieName, Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(Color.rgb(255, 160, 0));
                snackbar.show();
            }
        });

        mDetector = new GestureDetectorCompat(this, new GestureDetector.SimpleOnGestureListener() {

            private static final int SWIPE_MIN_DISTANCE = 120;
            private static final int SWIPE_THRESHOLD_VELOCITY = 200;

            @Override
            public boolean onDown(MotionEvent e) {
                return super.onDown(e);
            }

            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    if (i < movieData.getSize() - 1) {
                        i++;
                        HashMap movie = movieData.getItem(i);
                        int imageId = (Integer) movie.get("image");
                        imageView.setImageResource(imageId);
                    }
                    return true;
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

                    if (i > 0) {
                        i--;
                        HashMap movie = movieData.getItem(i);
                        int imageId = (Integer) movie.get("image");
                        imageView.setImageResource(imageId);
                    }
                    return true;
                }
                return true;
            }
        });
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
