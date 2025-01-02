package com.example.mobilprogramlama;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NextActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next2);




        ListView listView = findViewById(R.id.listView);

        // Kategoriler
        String[] titles = {
            "Formula 1 Araç Teknolojisi",
            "Pit Stop Stratejileri",
            "F1 Pilotluk Teknikleri"
        };
        
        int[] images = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
        };

        CustomAdapter adapter = new CustomAdapter(this, titles, images);
        listView.setAdapter(adapter);

        // ListView tıklama olayı
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(NextActivity2.this, DetailActivity.class);
            String category = "kategori" + (position + 1);
            intent.putExtra("category", category);
            startActivity(intent);
        });
    }
}