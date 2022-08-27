package com.example.quran_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ParahUrdu extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parah_urdu);

        QDH qdh = new QDH();

        String[] urduParah = qdh.ParahName;

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item_text,urduParah);

        listView = findViewById(R.id.paraUrdu);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int start = qdh.PSP[i];
                int end;
                QuranArabicText qat = new QuranArabicText();
                if (start == 5747) {
                    end = qat.QuranArabicText.length; // 6348
                }
                else{
                    end = qdh.PSP[i+1];
                }
                Intent intent = new Intent(ParahUrdu.this, Parah.class);
                intent.putExtra("start", start);
                intent.putExtra("end", end);
                startActivity(intent);
            }
        });
    }
}



