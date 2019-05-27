package com.example.cadastroprodutos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {

    private EditText nome_produto;
    private EditText preco_produto;
    private Button submit;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Adicionar Produto");

        nome_produto = findViewById(R.id.nome_produto);
        preco_produto = findViewById(R.id.preco_produto);
        submit = findViewById(R.id.submit);
        db = new DBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto produto = new Produto(nome_produto.getText().toString(), preco_produto.getText().toString());
                try{
                    db.insertProduto(produto);
                    finish();
                }catch (Exception e){
                    Toast.makeText(Formulario.this, "Erro na gravação!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
