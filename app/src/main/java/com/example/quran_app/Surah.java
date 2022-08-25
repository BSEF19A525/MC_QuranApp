package com.example.quran_app;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Surah extends AppCompatActivity  {

    QuranArabicText qat=new QuranArabicText();
    ListView listView;
    ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);


        listView=findViewById(R.id.surahView);

        Intent intent = getIntent();
        int start = intent.getIntExtra("start", 0);
        int end = intent.getIntExtra("end", 0);


        for (int i = start; i < end - 1; i++) {
            data.add(qat.QuranArabicText[i]);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,data);
        listView.setAdapter(arrayAdapter);

    }

}