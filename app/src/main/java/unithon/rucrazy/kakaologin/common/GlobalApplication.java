package unithon.rucrazy.kakaologin.common;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.kakao.auth.KakaoSDK;
import com.kakao.util.helper.log.Logger;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;

public class GlobalApplication extends Application {
    private static volatile GlobalApplication instance = null;
    private static volatile Activity currentActivity = null;
    private ImageLoader imageLoader;

    public static Activity getCurrentActivity() {
        Logger.d("++ currentActivity : " + (currentActivity != null ? currentActivity.getClass().getSimpleName() : ""));
        return currentActivity;
    }

    public static void setCurrentActivity(Activity currentActivity) {
        GlobalApplication.currentActivity = currentActivity;
    }

    /**
     * singleton 애플리케이션 객체를 얻는다.
     *
     * @return singleton 애플리케이션 객체
     */
    public static GlobalApplication getGlobalApplicationContext() {
        if (instance == null)
            throw new IllegalStateException("this application does not inherit GlobalApplication");
        return instance;
    }

    /**
     * 이미지 로더, 이미지 캐시, 요청 큐를 초기화한다.
     * 어플리케이션에서 쿠키매니저를 만들고 쿠키를 등록
     */
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        // 카카오 설정
        KakaoSDK.init(new KakaoSDKAdapter());

        // 이미지?
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
            final LruCache<String, Bitmap> imageCache = new LruCache<String, Bitmap>(3);

            @Override
            public void putBitmap(String key, Bitmap value) {
                imageCache.put(key, value);
            }

            @Override
            public Bitmap getBitmap(String key) {
                return imageCache.get(key);
            }
        };
        imageLoader = new ImageLoader(requestQueue, imageCache);

        // 쿠키 설정?
        CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     * 이미지 로더를 반환한다.
     *
     * @return 이미지 로더
     */
    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    /**
     * 애플리케이션 종료시 singleton 어플리케이션 객체 초기화한다.
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
}
