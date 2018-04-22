package a.choi.todolist;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateSet();

        //ListView
        ListView listview;
        final ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);

        //addButton Click
        ImageButton add = (ImageButton) findViewById(R.id.addButton);
        add.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v){
                adapter.addItem("GOGOGOOGO", ContextCompat.getDrawable(getApplicationContext(),R.drawable.erase_image));
            }
        });

    }

    public void dateSet() {

        TextView mood = (TextView) findViewById(R.id.moodView);
        Calendar today = Calendar.getInstance();
        int cal_month = (today.get(Calendar.MONTH) + 1);
        int cal_day_of_week = (today.get(Calendar.DAY_OF_WEEK));
        int day = (today.get(Calendar.DAY_OF_MONTH));
        String month = null, day_of_week = null;

        switch (cal_month) {

            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }

        switch (cal_day_of_week) {

            case 1:
                day_of_week = "Sunday";
                break;
            case 2:
                day_of_week = "Sunday";
                break;
            case 3:
                day_of_week = "Sunday";
                break;
            case 4:
                day_of_week = "Sunday";
                break;
            case 5:
                day_of_week = "Sunday";
                break;
            case 6:
                day_of_week = "Sunday";
                break;
            case 7:
                day_of_week = "Sunday";
                break;
        }

        mood.setText("Today is " + day_of_week + ", " + month + ", " + day + "\nI know you can do your ToDoList!");
    }
}