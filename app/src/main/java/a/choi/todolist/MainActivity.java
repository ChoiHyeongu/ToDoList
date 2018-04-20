package a.choi.todolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout inLayout = (LinearLayout) findViewById(R.id.planLayout);
        Button btn = (Button) findViewById(R.id.addButton);

        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout planView = (LinearLayout) inflater.inflate(R.layout.plan_textview, null);
                inLayout.addView(planView);
            }
        });
    }
}
