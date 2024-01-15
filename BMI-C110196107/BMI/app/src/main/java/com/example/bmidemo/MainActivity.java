package com.example.bmidemo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private EditText editTextHeight, editTextWeight;
    private float sum,height,weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.ShowResult);
        editTextHeight = findViewById(R.id.height);
        editTextWeight = findViewById(R.id.weight);
        Button calculate = findViewById(R.id.Calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                height = Float.valueOf(String.valueOf(editTextHeight.getText())) / 100;
                weight = Float.valueOf(String.valueOf(editTextWeight.getText()));

                sum = (float) (Math.round((weight / (height*height))*100)/100.0);
                if(sum<18.5){
                    result.setText("體重過輕!!\n"+String.valueOf(sum));
                } else if (sum >= 18.5 && sum < 24) {
                    result.setText("體重正常!!\n"+String.valueOf(sum));
                }
                else{
                    result.setText("體重過重!!\n"+String.valueOf(sum));
                }
            }
        });
    }
}