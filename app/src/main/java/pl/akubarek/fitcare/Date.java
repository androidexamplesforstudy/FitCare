package pl.akubarek.fitcare;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by BloodyFire on 09.01.2017.
 */

public class Date implements Serializable {

    private int day;
    private int month;
    private int year;

    public Date  () {
        Calendar calendar = Calendar.getInstance();
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH)+1;
        this.year = calendar.get(Calendar.YEAR);
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month+1;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month-1;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        String date;
        if (month > 9) {
            date = String.valueOf(day)+"-"+String.valueOf(month)+"-"+String.valueOf(year);
        } else {
            date = String.valueOf(day)+"-0"+String.valueOf(month)+"-"+String.valueOf(year);
        }
        return date;
    }
}
