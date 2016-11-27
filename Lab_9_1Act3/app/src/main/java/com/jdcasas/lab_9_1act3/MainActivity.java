package com.jdcasas.lab_9_1act3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView texto;
    TextView movimiento;
    private GestureDetector gestureDetector;
    private GestureDetector.SimpleOnGestureListener simpleOnGestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        texto = (TextView) findViewById(R.id.texto);
        movimiento = (TextView) findViewById(R.id.movimiento);
        GestureDetector.SimpleOnGestureListener
                simpleOnGestureListener =
                new GestureDetector.SimpleOnGestureListener(){
                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2,
                                           float velocityX, float velocityY) {
                        String swipe = "";
                        float sensitvity = 50;
                        if((e1.getX() - e2.getX()) > sensitvity){
                            swipe += "Swipe Left\n";
                        }else if((e2.getX() - e1.getX()) > sensitvity){
                            swipe += "Swipe Right\n";
                        }else{
                            swipe += "\n";
                        }
                        if((e1.getY() - e2.getY()) > sensitvity){
                            swipe += "Swipe Up\n";
                        }else if((e2.getY() - e1.getY()) > sensitvity){
                            swipe += "Swipe Down\n";
                        }else{
                            swipe += "\n";
                        }
                        movimiento.setText(swipe);
                        if (swipe.contains("Up")){
                            finish();
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                };

         gestureDetector = new GestureDetector(simpleOnGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
