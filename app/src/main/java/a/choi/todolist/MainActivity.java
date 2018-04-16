package a.choi.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox add = (CheckBox)findViewById(R.id.addButton);
        add.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
    }
}
