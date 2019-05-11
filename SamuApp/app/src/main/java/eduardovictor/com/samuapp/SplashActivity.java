package eduardovictor.com.samuapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class SplashActivity extends Activity implements Runnable {

    public static int TEMPO_SPLASH = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(this, TEMPO_SPLASH);
    }

    public void run(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
