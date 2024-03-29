package unithon.rucrazy.sms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import unithon.rucrazy.R;

/**
 * Created by Jinwoo on 2016-02-13.
 */
public class ShowSMSActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showsms);

        TextView smsDate = (TextView) findViewById(R.id.smsDate);
        TextView originNum = (TextView) findViewById(R.id.originNum);
        TextView originText = (TextView) findViewById(R.id.originText);

        Intent smsIntent = getIntent();

        String originNumber = smsIntent.getStringExtra("originNum");
        String originDate = smsIntent.getStringExtra("smsDate");
        String originSmsText = smsIntent.getStringExtra("originText");

        originNum.setText(originNumber);
        smsDate.setText(originDate);
        originText.setText(originSmsText);
    }
}
