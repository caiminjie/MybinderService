package cmj.com.mybinderservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by caiminjie on 2018/9/4.
 */

public class BackgroundService extends Service {

    private static String TAG = "BackgroundService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: ");
        return new MyBind();
    }

    class MyBind extends Binder {
        public void showToast(){
            Log.e(TAG, "showToast: " );
        }

        public void showList() {
            Log.e(TAG, "showList: ");
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: " );
        return super.onUnbind(intent);
    }
}
