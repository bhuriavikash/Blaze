package com.ncrsoft.wizards;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.os.Handler;
import android.content.Intent;
import com.ncrsoft.R;
import com.ncrsoft.ui.SipHome;

/**
 * Created by admin on 2/2/2017.
 */

public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 2000;
    /*static float ht;
    static float wt;
*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       /* WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        ht = display.getHeight();
        wt = display.getWidth();*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, SipHome.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
