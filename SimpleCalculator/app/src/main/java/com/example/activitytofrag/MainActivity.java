package com.example.activitytofrag;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public EditText num1;
    public EditText num2;
    public Button sum;

    public Button diff;

    public Button product;

    public Button fraction;
    Fragment1 fragComp;

    int a;
    int b;

    int ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        fragComp = new Fragment1();

        if(savedInstanceState==null){
            //Bundle bundle = new Bundle();
            //bundle.putInt("key" , ans);
            getSupportFragmentManager().beginTransaction().replace(R.id.frag1,fragComp).commit();
        }


        sum = findViewById(R.id.add);
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(num1.getText().toString());
                b = Integer.parseInt(num2.getText().toString());
                ans=a+b;
                fragComp.getData(String.valueOf(ans));
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(num1.getWindowToken(), 0);
            }
        });

        diff = findViewById(R.id.sub);
        diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(num1.getText().toString());
                b = Integer.parseInt(num2.getText().toString());
                ans=a-b;
                fragComp.getData(String.valueOf(ans));
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(num1.getWindowToken(), 0);
            }
        });

        product = findViewById(R.id.multiply);
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(num1.getText().toString());
                b = Integer.parseInt(num2.getText().toString());
                ans=a*b;
                fragComp.getData(String.valueOf(ans));


                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(num1.getWindowToken(), 0);
            }
        });

        fraction = findViewById(R.id.divide);
        fraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Integer.parseInt(num1.getText().toString());
                float b = Integer.parseInt(num2.getText().toString());
                float ans=a/b;
                fragComp.getData(String.valueOf(ans));
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(num1.getWindowToken(), 0);
            }
        });



    }
}