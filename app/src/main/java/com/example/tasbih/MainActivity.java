package com.example.tasbih;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText kalma, kalmaCount, darood, daroodCount, astaghfar, astaghfarCount;
    Button submit,data;
    EditText myDate;
    DbHandler db;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= new DbHandler(this);
        kalma= findViewById(R.id.kalma);
        kalmaCount= findViewById(R.id.kalmaCount);
        darood= findViewById(R.id.darood);
        daroodCount= findViewById(R.id.daroodCount);
        astaghfar= findViewById(R.id.astaghfar);
        astaghfarCount= findViewById(R.id.astaghfarCount);
        submit= findViewById(R.id.submit);
        data= findViewById(R.id.showData);
        myDate= findViewById(R.id.myDate);
        listView= findViewById(R.id.listView);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kalmaText= kalma.getText().toString();
                String kalmaCountText= kalmaCount.getText().toString();
                String daroodText= darood.getText().toString();
                String daroodCountText= daroodCount.getText().toString();
                String astaghfarText= astaghfar.getText().toString();
                String astaghfarCountText= astaghfarCount.getText().toString();
                String myDate= MainActivity.this.myDate.toString();


                if (kalmaText.isEmpty() || kalmaCountText.isEmpty() || daroodText.isEmpty() ||daroodCountText.isEmpty()||astaghfarText.isEmpty()||astaghfarCountText.isEmpty() ) {
                    Toast.makeText(MainActivity.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                    return;
                }

                Tasbih tasbih= new Tasbih(kalmaText,kalmaCountText,daroodText,daroodCountText,astaghfarText,astaghfarCountText,myDate);

                db.insertTasbih(tasbih);
                db.close();
                RefreshGrid();







            }
        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RefreshGrid();

            }
        });



    }
    public void RefreshGrid(){
        List<Tasbih> tasbih = db.selectAllTasbih();

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,tasbih);
        listView.setAdapter(arrayAdapter);

    }
}