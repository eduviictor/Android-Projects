package com.example.falatech;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Tela_Compartilhar extends AppCompatActivity {

    TextView compartilhar_descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__compartilhar);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Compartilhar frase");
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.app));

        compartilhar_descricao = findViewById(R.id.compartilhar_descricao);
        Intent i = getIntent();
        compartilhar_descricao.setText(i.getStringExtra("descricao"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_compartilhar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.share){
            compartilhar();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void compartilhar(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, compartilhar_descricao.getText().toString());
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getString(R.string.share)));
    }
}
