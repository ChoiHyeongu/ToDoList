package a.choi.todolist;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.addLayout);

        Button addButton=(Button)findViewById(R.id.addButton);
        addButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                ConstraintLayout plan_textVview=(ConstraintLayout)inflater.inflate(R.layout.plan_textview,null);
                layout.addView(plan_textVview);
            }
        });
    }
}
