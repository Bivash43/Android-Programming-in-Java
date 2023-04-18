package com.example.activitytofrag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText text;
    public Button btn_act;
    Fragment1 fragComp;

    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = findViewById(R.id.edittext_act);
        btn_act = findViewById(R.id.button_act);

        fragComp = new Fragment1();

        if(savedInstanceState==null){
            Bundle bundle = new Bundle();
            bundle.putString("key" , value);
            getSupportFragmentManager().beginTransaction().replace(R.id.frag1,fragComp).commit();
        }

        btn_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = text.getText().toString();
                fragComp.getData(value);
            }
        });


    }
}