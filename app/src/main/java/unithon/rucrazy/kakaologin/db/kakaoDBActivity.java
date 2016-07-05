package unithon.rucrazy.kakaologin.db;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.kakao.auth.Session;
import com.kakao.usermgmt.response.model.UserProfile;

import unithon.rucrazy.R;

public class kakaoDBActivity extends Activity {
    dbHelper helper;
    SQLiteDatabase db;
    EditText kakaodbview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        UserProfile userProfile = UserProfile.loadFromCache();

        final long kakaoId = userProfile.getId();
        final String kakaoToken = Session.getCurrentSession().getAccessToken();
        final String nickname = userProfile.getNickname();

        System.out.println("kakaoToken:"+kakaoToken);
        System.out.println("kakaoLoginId:" + kakaoId);
        System.out.println("kakaonicname:" + nickname);
       
        helper = new dbHelper(this);
        try {
            db = helper.getWritableDatabase();
            //데이터베이스 객체를 얻기 위하여 getWritableDatabse()를 호출
        } catch (SQLiteException e) {
            db = helper.getReadableDatabase();
        }

        kakaodbview = (EditText) findViewById(R.id.dbview);

        //db 에 추가
        db.execSQL("INSERT INTO kakaodb VALUES(null, '" + kakaoToken + "','" + kakaoId + "','" + nickname + "');");

        //검색 버튼
        findViewById(R.id.query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor;
                String str = "";

                cursor = db.rawQuery("select * from kakaodb", null);
                while(cursor.moveToNext()) {
                    str += cursor.getInt(0)
                            + " : kakaoToken "
                            + cursor.getString(1)
                            + ", kakaoId = "
                            + cursor.getInt(2)
                            + ", nickname = "
                            + cursor.getString(3)
                            + "\n";
                }
                kakaodbview.setText(str);
            }
        });
    }
}