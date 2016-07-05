package unithon.rucrazy.kakaologin.sign;

import com.kakao.auth.Session;
import com.kakao.usermgmt.response.model.UserProfile;

public class SignupInteractor {
    private OnSignupListener listener;

    public SignupInteractor(OnSignupListener listener) {
        this.listener = listener;
    }

    public void signup(String name, String age, String gender) {
        UserProfile userProfile = UserProfile.loadFromCache();
        long kakaoId = userProfile.getId();
        String kakaoToken = Session.getCurrentSession().getAccessToken();
        String nickname = userProfile.getNickname();

        System.out.println("kakaoToken:"+kakaoToken);
        System.out.println("kakaoLoginId:"+kakaoId);
        System.out.println("kakaonicname:"+nickname);

        /*
        UserCondition condition = new UserCondition(String.valueOf(kakaoId), kakaoToken, name, 0, 0);
        AuthResult result = request.register(condition);
*/
        // TODO accessToken 등록
    }
}
