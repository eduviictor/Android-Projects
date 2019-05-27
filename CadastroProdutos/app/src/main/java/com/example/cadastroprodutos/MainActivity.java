package com.example.cadastroprodutos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setTitle(getString(R.string.app_name));
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimary));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Formulario.class);
                startActivity(i);
            }
        });
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                final Produto contatoSelecionado = (Produto) adapterView.getItemAtPosition(i);
//                Toast.makeText(MainActivity.this, contatoSelecionado.getNome()+
//                        '\n'+contatoSelecionado.getPreco(), Toast.LENGTH_LONG).show();
//            }
//        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        db = new DBHelper(this);
        ArrayList<Produto> produtos = db.getDBProdutos();
//        ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(R.id.listView, produtos);
        AdapterProduto adapter = new AdapterProduto(this, db.getDBProdutos());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
