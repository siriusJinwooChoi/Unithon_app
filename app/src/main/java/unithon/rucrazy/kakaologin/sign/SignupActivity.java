package unithon.rucrazy.kakaologin.sign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import unithon.rucrazy.R;
import unithon.rucrazy.kakaologin.common.BaseActivity;
import unithon.rucrazy.kakaologin.db.kakaoDBActivity;

public class SignupActivity extends BaseActivity implements View.OnClickListener {
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignup = (Button) findViewById(R.id.btn_sign_up);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sign_up :
                //UserProfile userProfile = UserProfile.loadFromCache();

                Intent intent = new Intent(SignupActivity.this, kakaoDBActivity.class);
                startActivity(intent);

                

                /* 이곳에 id, token, nickname을 DB에 저장해 놓으면 될듯함.
                    Token은 앱을 실행할 때마다 계속 갱신됨
                    어차피 백그라운드로 돌고있을 것이므로, 종료하지 않는 이상은
                    그 사용자는 항상 하나의 토큰을 사용하게 됨
                 */
                break;
        }
    }

    public void redirectDepartureActivity() {
    //    final Intent intent = new Intent(this, DepartureActivity.class);
    //    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
     //   startActivity(intent);
    //    finish();
    }
}
