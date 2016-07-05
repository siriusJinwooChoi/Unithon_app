package unithon.rucrazy.kakaologin.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jinwoo on 2016-02-16.
 */
public class dbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mykakao.db";
    private static final int DATABASE_VERSION =1;

    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE kakaodb (_id INTEGER PRIMARY KEY AUTOINCREMENT, kakaoToken TEXT, kakaoId TEXT, nickname TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS kakaodb");
        onCreate(db);
    }
}