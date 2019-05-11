package com.example.contatos_app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton call;
    private TextView texto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call = findViewById(R.id.call);
        texto2 = findViewById(R.id.texto2);

        AdapterContato adapter = new AdapterContato(this, gerarDados());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Contato contatoSelecionado = (Contato) adapterView.getItemAtPosition(i);
                Toast.makeText(MainActivity.this, contatoSelecionado.getNome()+
                        '\n'+contatoSelecionado.getNumero(), Toast.LENGTH_LONG).show();

//                call.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        contatoSelecionado.discar();
//                    }
//                });
            }
        });

//        listView.



    }

    private ArrayList<Contato> gerarDados() {
        ArrayList<Contato> items = new ArrayList<Contato>();
        items.add(new Contato("Aome 1 ","1"));
        items.add(new Contato("Eome 2","2"));
        items.add(new Contato("Iome 3","3"));
        items.add(new Contato("Oome 4","4"));
        items.add(new Contato("Uome 5","5"));
        items.add(new Contato("Rome 6","6"));
        items.add(new Contato("Eome 7","7"));
        items.add(new Contato("Dome 8","8"));
        items.add(new Contato("Tome 9","9"));
        items.add(new Contato("Eduardo 10","999402424"));
        return items;
    }


}
