package com.example.falatech;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DBHelper db;
    private ListView listView;
    AdapterFrase adapter;
    private Boolean confirm;
    private AlertDialog alerta;
    private Button positive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        confirm = false;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Excluir");
        builder.setMessage("Deseja realmente excluir?");
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        builder.setPositiveButton("Sim", null);


        alerta = builder.create();

        ActionBar ab = getSupportActionBar();
        ab.setTitle(getString(R.string.app_name));
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.app));

        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
                view.findViewById(R.id.trash).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alerta.show();
                        positive = alerta.getButton(DialogInterface.BUTTON_POSITIVE);
                        positive.setId(DialogInterface.BUTTON_POSITIVE);
                        positive.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                excluirItem(position, parent);
                                alerta.cancel();
                            }
                        });
                    }
                });

                view.findViewById(R.id.edit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AdapterFrase adapter = new AdapterFrase(MainActivity.this, db.getDBFrases());
                        View t = adapter.getView(position, null, parent);
                        Intent i = new Intent(MainActivity.this, AddFrase.class);
                        TextView tv_descricao = t.findViewById(R.id.descricao);
                        i.putExtra("descricao", tv_descricao.getText().toString());
                        i.putExtra("id", t.getId());
                        startActivity(i);
                    }
                });

                view.findViewById(R.id.descricao).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AdapterFrase adapter = new AdapterFrase(MainActivity.this, db.getDBFrases());
                        View t = adapter.getView(position, null, parent);
                        Intent i = new Intent(MainActivity.this, Tela_Compartilhar.class);
                        TextView tv_descricao = t.findViewById(R.id.descricao);
                        i.putExtra("descricao", tv_descricao.getText().toString());
                        startActivity(i);
                    }
                });
            }
        });
    }

    public void excluirItem(int position, AdapterView<?> parent){
        AdapterFrase adapter = new AdapterFrase(MainActivity.this, db.getDBFrases());
        View t = adapter.getView(position, null, parent);
        db.delete(t.getId());
        onStart();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_inicial, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add){
            Intent i = new Intent(this, AddFrase.class);
            i.putExtra("descricao", "");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        db = new DBHelper(this);
        ArrayList<Frase> produtos = db.getDBFrases();
        adapter = new AdapterFrase(this, db.getDBFrases());
        listView.setAdapter(adapter);
    }
}
