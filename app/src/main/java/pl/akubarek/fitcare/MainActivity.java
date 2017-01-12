package pl.akubarek.fitcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Date currentDate;
    private TextView currentDatetxt;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        currentDatetxt = (TextView) findViewById(R.id.currentDatetxt);
        updateDatetxt();
        Log.d(TAG, "onCreate: "+ currentDate.getDay());
        Log.d(TAG, "onCreate: "+ currentDate.getMonth());
        Log.d(TAG, "onCreate: "+ currentDate.getYear());

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

    }

    public void logValuesFromPreferences () {
        int height;
        double weight;
        int age;
        String sex;
        String activityLevel;
        String goal;
        int numberOfMeals;
        boolean manualCaloriesInsert;
        int manualCaloriesLimit;

        height = Integer.valueOf(sharedPreferences.getString("EDITTEXT_HEIGHT", "-1"));
        Log.d(TAG, "logValuesFromPreferences: height = " + height);

        weight = Double.valueOf(sharedPreferences.getString("EDITTEXT_WEIGHT", "-1"));
        weight = BigDecimal.valueOf(weight).setScale(2, RoundingMode.HALF_UP).doubleValue();
        Log.d(TAG, "logValuesFromPreferences: weight = " + weight);

        age = Integer.valueOf(sharedPreferences.getString("EDITTEXT_AGE", "-1"));
        Log.d(TAG, "logValuesFromPreferences: age = " + age);

        sex = sharedPreferences.getString("LIST_SEX", "MALE");
        if (sex.equals("MALE")) {
            Log.d(TAG, "logValuesFromPreferences: sex = mężczyzna");
        } else {
            Log.d(TAG, "logValuesFromPreferences: sex = kobieta");
        }

        activityLevel = sharedPreferences.getString("LIST_ACTIVITY_LEVEL", "-1");
        switch (activityLevel) {
            case "NONE":
                Log.d(TAG, "logValuesFromPreferences: activity level is : " + activityLevel);
                break;
            case "LOW":
                Log.d(TAG, "logValuesFromPreferences: activity level is : " + activityLevel);
                break;
            case "MEDIUM":
                Log.d(TAG, "logValuesFromPreferences: activity level is : " + activityLevel);
                break;
            case "HIGH":
                Log.d(TAG, "logValuesFromPreferences: activity level is : " + activityLevel);
                break;
            case "EXTREME":
                Log.d(TAG, "logValuesFromPreferences: activity level is : " + activityLevel);
                break;
            default:
                Log.d(TAG, "logValuesFromPreferences: activity level is : not insert");
        }
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
        logValuesFromPreferences();
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
                Intent intentPref = new Intent (MainActivity.this, PreferencesActivity.class);
                startActivity(intentPref);
                return true;
            case R.id.calendar:
                Intent intentCal = new Intent (MainActivity.this, CalendarActivity.class);
                startActivity(intentCal);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
