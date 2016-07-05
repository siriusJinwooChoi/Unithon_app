package unithon.rucrazy.gcm;

import android.content.Intent;
import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by Jinwoo on 2016-02-13.
 */
public class MyInstanceIDListenerService extends InstanceIDListenerService {
    private static final String TAG = "MyInstanceIDLS";

    @Override
    public void onTokenRefresh() {
        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }
}