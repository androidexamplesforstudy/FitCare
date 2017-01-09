package pl.akubarek.fitcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Date currentDate;
    private TextView currentDatetxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //  Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        currentDatetxt = (TextView) findViewById(R.id.currentDatetxt);
        updateDatetxt();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();

    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    public void updateDatetxt () {
        Intent receiverFromCalendar = getIntent();
        int year = receiverFromCalendar.getIntExtra("YEAR", -1);
        int month = receiverFromCalendar.getIntExtra("MONTH", -1);
        int day = receiverFromCalendar.getIntExtra("DAY", -1);

        if (year != -1 && month != -1 &&  day != -1) {
            currentDate = new Date(day, month, year);
        } else {
            currentDate = new Date();
        }
        currentDatetxt.setText(currentDate.toString());
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
        switch (id) {
            case R.id.preferences:
                return true;
            case R.id.calendar:
                Intent intent = new Intent (MainActivity.this, CalendarActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
