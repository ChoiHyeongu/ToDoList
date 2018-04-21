package a.choi.todolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstButton();

        final LinearLayout inLayout = (LinearLayout) findViewById(R.id.planLayout);
        final LinearLayout planView = (LinearLayout) findViewById(R.id.planLayout);
        ImageButton add = (ImageButton) findViewById(R.id.addButton);

        add.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count >= 5){}else {
                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.plan_textview, planView, true);
                    count++;
                }
            }
        });
    }

    public void firstButton() {
        final LinearLayout planView = (LinearLayout) findViewById(R.id.planLayout);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.plan_textview, planView, true);
    }
}