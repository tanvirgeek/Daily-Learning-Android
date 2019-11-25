package com.tanvirgeek.everydaylearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Activity 2");
        Intent i = getIntent();
        final int number1 = i.getIntExtra("N1",0);
        final int number2 = i.getIntExtra("N2",0);

        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonSubstract = findViewById(R.id.button_substract);
        TextView numbersText = findViewById(R.id.numbers_text);
        numbersText.setText("Numbers: " + number1 + "," + number2);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 + number2;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",result);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
        buttonSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 - number2;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result",result);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
    }
}
