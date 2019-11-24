package com.tanvirgeek.everydaylearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    private EditText number1EditText;
    private EditText number2EditText;
    private Button activity2Button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1EditText = findViewById(R.id.number1_edit_text);
        number2EditText = findViewById(R.id.number2_edit_text);
        activity2Button = findViewById(R.id.activity_2_Button);

        activity2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(number1EditText.getText().toString().equals("") || number2EditText.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Please Insert numbers",Toast.LENGTH_SHORT).show();
                }else {
                    int number1 = Integer.parseInt(number1EditText.getText().toString());
                    int number2 = Integer.parseInt(number2EditText.getText().toString());
                    Intent intentActivity2 = new Intent();
                    intentActivity2.putExtra("N1", number1);
                    intentActivity2.putExtra("N2",number2);
                }

            }
        });


        recyclerView = findViewById(R.id.recycler_view);
        //Create Integer Array
        Integer[] LangLogo = {R.drawable.crystal,R.drawable.csharp,R.drawable.go,R.drawable.html,R.drawable.python};

        //Create String Array
        String[] LangName = {"Crystal","Csharp","Go","Html","Python"};

        //initialize ArrayList
        mainModels = new ArrayList<>();
        for(int i=0;i<LangLogo.length;i++){
            MainModel model = new MainModel(LangLogo[i], LangName[i]);
            mainModels.add(model);
        }
        //Design Horizontal Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //initialize main Adapter
        mainAdapter = new MainAdapter(MainActivity.this, mainModels);
        //Set Main adapter to recyclerView
        recyclerView.setAdapter(mainAdapter);
    }
}
