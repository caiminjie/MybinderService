package cmj.com.mybinderservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        closeBtn = (Button)findViewById(R.id.close_btn);

        final Intent intent = new Intent(this, BackgroundService.class);

        bindService(intent, conn, BIND_AUTO_CREATE);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(conn);
            }
        });
    }

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BackgroundService.MyBind myBind = (BackgroundService.MyBind)iBinder;
            myBind.showList();
            myBind.showToast();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
