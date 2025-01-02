package com.example.mobilprogramlama;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mobilprogramlama.model.VideoItem;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<VideoItem> videoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liste başlatılıyor
        videoItems = new ArrayList<>();

        // RecyclerView ayarları
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Video verilerini ekle
        addVideoData();

        // Adapter'ı ayarla
        VideoAdapter adapter = new VideoAdapter(videoItems, this);
        recyclerView.setAdapter(adapter);
    }

    private void addVideoData() {
        // Mercedes video
        videoItems.add(new VideoItem(
                "YzcuuUZWqxc",  // Mercedes W15 2024 Launch Highlights
                "Mercedes 2024 Lansmanı",
                "Mercedes-AMG Petronas Formula 1 Takımı'nın 2024 sezonu için hazırladığı W15 aracının lansmanı.",
                "Mercedes-AMG Petronas F1",
                getResources().getColor(R.color.mercedes_color),
                R.drawable.mercedes_logo,
                "2023 Sezon Performansı:\n" +
                "• Konstruktörler Şampiyonası: 3. sıra\n" +
                "• Lewis Hamilton: 3. sıra\n" +
                "• George Russell: 8. sıra"
        ));

        // Ferrari video
        videoItems.add(new VideoItem(
                "IL9GgLzsXq4",  // Ferrari SF-24 2024 Launch
                "Ferrari 2024 Lansmanı",
                "Scuderia Ferrari'nin 2024 Formula 1 sezonu için hazırladığı SF-24 aracının lansmanı.",
                "Scuderia Ferrari",
                getResources().getColor(R.color.ferrari_color),
                R.drawable.ferrari_logo,
                "2023 Sezon Performansı:\n" +
                "• Konstruktörler Şampiyonası: 3. sıra\n" +
                "• Charles Leclerc: 5. sıra\n" +
                "• Carlos Sainz: 7. sıra"
        ));

        // Red Bull video
        videoItems.add(new VideoItem(
                "8_nuR_d6fVU",  // Red Bull RB20 2024 Launch
                "Red Bull 2024 Lansmanı",
                "Oracle Red Bull Racing'in 2024 Formula 1 sezonu için hazırladığı RB20 aracının lansmanı.",
                "Oracle Red Bull Racing",
                getResources().getColor(R.color.redbull_color),
                R.drawable.redbull_logo,
                "2023 Sezon Performansı:\n" +
                "• Konstruktörler Şampiyonası: 1. sıra\n" +
                "• Max Verstappen: 1. sıra\n" +
                "• Sergio Perez: 2. sıra"
        ));
    }
}