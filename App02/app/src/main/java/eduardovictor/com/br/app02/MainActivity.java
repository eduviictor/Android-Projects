package eduardovictor.com.br.app02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button start_second_activity;
    private Button button_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast("onCreate");
        Log.i("information", "onCreate");

        start_second_activity = findViewById(R.id.start_second_activity);
        button_exit = findViewById(R.id.button_exit);

        start_second_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void showToast(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart");
        Log.i("information", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("onRestart");
        Log.i("information", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume");
        Log.i("information", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause");
        Log.i("information", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop");
        Log.i("information", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy");
        Log.i("information", "onDestroy");
    }
}
