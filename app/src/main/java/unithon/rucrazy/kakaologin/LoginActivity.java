package unithon.rucrazy.kakaologin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import unithon.rucrazy.R;
import unithon.rucrazy.kakaologin.common.BaseActivity;
import unithon.rucrazy.kakaologin.sign.SignupActivity;

//import javax.security.auth.login.LoginException;

public class LoginActivity extends BaseActivity {
    //add
    private SessionCallback callback;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);
        Session.getCurrentSession().checkAndImplicitOpen();

        presenter = new LoginPresenter(this);
        presenter.login();
    }

    public void showLogin() {
        setContentView(R.layout.kakao_login);
    }

    public void refreshActivity(){
        setContentView(R.layout.kakao_login);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void setUsernameError() {
        Toast.makeText(this, LoginException.USER_NAME_ERROR, Toast.LENGTH_LONG).show();
    }

    public void setPasswordError() {
        Toast.makeText(this, LoginException.PASSWORD_ERROR, Toast.LENGTH_LONG).show();
    }

    private class SessionCallback implements ISessionCallback {
        @Override
        public void onSessionOpened() {
            redirectSignupActivity();
        }
        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                Logger.e(exception);
            }
        }
    }

    public void redirectSignupActivity() {
        final Intent intent = new Intent(this, SignupActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }

    public void redirectDepartureActivity() {
        final Intent intent = new Intent(this, SignupActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

        startActivity(intent);
        finish();
    }
}