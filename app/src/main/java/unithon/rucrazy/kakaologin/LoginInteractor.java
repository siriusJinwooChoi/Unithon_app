package unithon.rucrazy.kakaologin;

import android.content.Context;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

//import javax.security.auth.login.LoginException;

public class LoginInteractor {
    private SessionCallback callback;
    private OnLoginListener listener;
   // private UserManager userManager;
   // private Gson gson;

    public LoginInteractor(OnLoginListener listener, Context context) {
        this.listener = listener;
    //    this.userManager = UserManager.getInstance(context);
   //     gson = new Gson();
    }

    public void setup() {
        callback = new SessionCallback(listener);
        Session.getCurrentSession().addCallback(callback);
        if (Session.getCurrentSession().checkAndImplicitOpen()) {
            if (isLogin()) {
                saveUserManage();
                listener.redirectDepartureActivity();
            } else {
                throw new LoginException(LoginException.CONNECT_ERROR);
            }
        }
    }

    private void saveUserManage() {
        UserManagement.requestMe(new MeResponseCallback() {
            @Override
            public void onNotSignedUp() {
                // TODO
                listener.refreshActivity();
            }

            @Override
            public void onFailure(ErrorResult errorResult) {
                String message = "failed to get user info. msg=" + errorResult;
                Logger.e(message);
            }
            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                // TODO
                listener.refreshActivity();
            }

            @Override
            public void onSuccess(UserProfile userProfile) {
                Logger.i("succeeded to get user profile");
                if (userProfile != null) {
       //             String userProfileStr = gson.toJson(userProfile);
       //             userManager.putString(UserManager.USER_PROFILE.getName(), userProfileStr);
                }
            }
        });
    }

    public void destroy() {
        Session.getCurrentSession().removeCallback(callback);
    }

    private boolean isLogin() {
        String token = Session.getCurrentSession().getAccessToken();
        // TODO
        System.out.println("token="+token);
        return true;
    }

    /**
     * 카카오 로그인 세션
     */
    private class SessionCallback implements ISessionCallback {
        private OnLoginListener listener;

        public SessionCallback(OnLoginListener listener) {
            this.listener = listener;
        }

        @Override
        public void onSessionOpened() {
            if (isLogin()) {
                saveUserManage();
                listener.redirectDepartureActivity();
            } else {
                listener.redirectSignupActivity();
            }
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if (exception != null) {
                Logger.e(exception);
            }
            listener.refreshActivity();
        }
    }
}
