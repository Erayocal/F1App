package com.example.mobilprogramlama;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ExerciseDB";
    private static final int DATABASE_VERSION = 1;

    // Tablo ve kolon isimleri
    public static final String TABLE_EXERCISES = "exercises";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_VIDEO_URL = "video_url";
    public static final String COLUMN_CATEGORY = "category";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_EXERCISES + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_TITLE + " TEXT, "
            + COLUMN_DESCRIPTION + " TEXT, "
            + COLUMN_VIDEO_URL + " TEXT, "
            + COLUMN_CATEGORY + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        onCreate(db);
    }

    // Örnek verileri eklemek için yeni metod
    public void insertInitialData() {
        SQLiteDatabase db = this.getWritableDatabase();
        
        // Kategori 1
        ContentValues values1 = new ContentValues();
        values1.put(COLUMN_TITLE, "Formula 1 Araç Teknolojisi");
        values1.put(COLUMN_DESCRIPTION, "Formula 1 araçlarının teknik özellikleri ve en son teknolojik gelişmeler.");
        values1.put(COLUMN_VIDEO_URL, "https://www.youtube.com/watch?v=25uuxCT19AM&ab_channel=OvertakeFans"); // YouTube video ID
        values1.put(COLUMN_CATEGORY, "kategori1");
        db.insert(TABLE_EXERCISES, null, values1);

        // Kategori 2
        ContentValues values2 = new ContentValues();
        values2.put(COLUMN_TITLE, "Pit Stop Stratejileri");
        values2.put(COLUMN_DESCRIPTION, "Formula 1'de pit stop stratejileri ve önemi.");
        values2.put(COLUMN_VIDEO_URL, "aQs1h6bBC3U"); // YouTube video ID
        values2.put(COLUMN_CATEGORY, "kategori2");
        db.insert(TABLE_EXERCISES, null, values2);

        // Kategori 3
        ContentValues values3 = new ContentValues();
        values3.put(COLUMN_TITLE, "F1 Pilotluk Teknikleri");
        values3.put(COLUMN_DESCRIPTION, "Formula 1 pilotlarının kullandığı temel sürüş teknikleri.");
        values3.put(COLUMN_VIDEO_URL, "8h3t2h4ZQFY"); // YouTube video ID
        values3.put(COLUMN_CATEGORY, "kategori3");
        db.insert(TABLE_EXERCISES, null, values3);
    }
} // ... diğer importlar ...