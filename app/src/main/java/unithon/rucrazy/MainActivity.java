package unithon.rucrazy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import unithon.rucrazy.gcm.GCMActivity;
import unithon.rucrazy.kakao.KAKAOActivity;
import unithon.rucrazy.kakaologin.LoginActivity;
import unithon.rucrazy.sms.SMSActivity;

public class MainActivity extends Activity {
    private Button KakaoBtn, SMSBtn, GCMBtn, LOGINBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KakaoBtn = (Button)findViewById(R.id.kakabtn);
        SMSBtn = (Button)findViewById(R.id.smbtn);
        GCMBtn = (Button)findViewById(R.id.gcmbtn);
        LOGINBtn = (Button)findViewById(R.id.loginbtn);

        KakaoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KAKAOActivity.class);
                startActivity(intent);
            }
        });

        SMSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SMSActivity.class);
                startActivity(intent);
            }
        });

        GCMBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GCMActivity.class);
                startActivity(intent);
            }
        });

        LOGINBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}