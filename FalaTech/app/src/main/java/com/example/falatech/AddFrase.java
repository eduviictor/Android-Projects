package com.example.falatech;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddFrase extends AppCompatActivity {

    private EditText input_frase;
    private DBHelper db;
    private int putID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_frase);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Registro da frase");
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.app));

        input_frase = findViewById(R.id.input_frase);
        db = new DBHelper(this);
        Intent i = getIntent();
        putID = i.getIntExtra("id", -1);
        String putString = i.getStringExtra("descricao");
        input_frase.setText(putString);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.submit){
            Frase frase = new Frase(input_frase.getText().toString());
            Log.i("frase", frase.getDescricao());
            if(putID == -1){
                try{
                    db.insertFrase(frase);
                    finish();
                }catch (Exception e){
                    Log.e("MYAPP", "exception", e);
                    Toast.makeText(AddFrase.this, "Erro na gravação!", Toast.LENGTH_LONG).show();
                }
            }else{
                try{
                    db.updateFrase(frase, putID);
                    finish();
                }catch (Exception e){
                    Log.e("MYAPP", "exception", e);
                    Toast.makeText(AddFrase.this, "Erro na gravação!", Toast.LENGTH_LONG).show();
                }
            }

            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
