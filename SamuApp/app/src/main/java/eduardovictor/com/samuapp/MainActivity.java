package eduardovictor.com.samuapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CardView card_historico;
    private CardView card_info;
    private CardView card_contato;
    private CardView card_viaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setTitle(getString(R.string.app_name));
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimary));

        card_historico = findViewById(R.id.card_historico);
        card_info = findViewById(R.id.card_info);
        card_contato = findViewById(R.id.card_contato);
        card_viaturas = findViewById(R.id.card_viaturas);

        card_historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Historico.class);
                startActivity(i);
            }
        });

        card_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Informacoes.class);
                startActivity(i);
            }
        });

        card_contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Contato.class);
                startActivity(i);
            }
        });

        card_viaturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Viaturas.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.sair){
            sair();
            return true;
        }else if(id == R.id.site){
            abrirSite();
            return true;
        }else if(id == R.id.sobre){
            mensagemSobre();
            return true;
        }else if(id == R.id.discar){
            discar();
            return true;
        }else if(id == R.id.compartilhar){
            compartilhar();
            return true;
        }else if(id == R.id.informacoes){
            mensagemInfo();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sair(){
        new AlertDialog.Builder(this)
                .setMessage("Deseja realmente sair?")
                .setCancelable(false)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Não", null)
                .show();

    }

    @Override
    public void onBackPressed(){
        sair();
    }

    public void abrirSite(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://samu.saude.sc.gov.br/"));
        startActivity(browserIntent);
    }

    public void mensagemSobre(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getString(R.string.menu_sobre));
        alertDialog.setMessage(getString(R.string.sobre));
        alertDialog.show();
    }

    public void mensagemInfo(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getString(R.string.menu_informacoes));
        alertDialog.setMessage(getString(R.string.mensagem_info));
        alertDialog.show();
    }

    public void discar(){
        Uri uri = Uri.parse("tel:192");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    public void compartilhar(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.app_name));
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getString(R.string.menu_compartilhar)));
    }

}