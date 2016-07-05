package unithon.rucrazy.kakao;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.kakao.kakaolink.KakaoLink;
import com.kakao.kakaolink.KakaoTalkLinkMessageBuilder;
import com.kakao.util.KakaoParameterException;

/**
 * Created by Jinwoo on 2016-02-13.
 */
public class KAKAOActivity extends Activity {
    //kakaAPI
    private KakaoLink kakaoLink;
    private KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //Kkao API 이용하여 보내주는 부분(링크 전송)
        try {
            //kakao 객체를 초기화
            kakaoLink = KakaoLink.getKakaoLink(getApplicationContext());
            kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();

            //실제 메세지를 전송
            kakaoTalkLinkMessageBuilder.addText("http://192.168.0.250:8080/index.html");
            kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder, this);
            kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();

        } catch (KakaoParameterException e) {
            Log.e("error", e.getMessage());
        }
        finish();
    }
}
