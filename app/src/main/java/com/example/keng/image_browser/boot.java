package com.example.keng.image_browser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by keng on 2016/5/17.
 */
public class boot extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.boot_layout);
        Handler boot_handler = new Handler();
        boot_handler.postDelayed(new lunchhandler(),3000);
    }

    private class lunchhandler implements Runnable {
        @Override
        public void run() {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            boot.this.finish();
        }
    }
}
