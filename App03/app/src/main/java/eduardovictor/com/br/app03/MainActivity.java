package eduardovictor.com.br.app03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button botao_sim;
    private Button botao_nao;
    private EditText campo_nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao_sim = (Button) findViewById(R.id.button_sim);
        botao_nao = (Button) findViewById(R.id.button_nao);
        campo_nome = (EditText) findViewById(R.id.campo_nome);

        botao_sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = campo_nome.getText().toString();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("campo_nome", texto);
                intent.putExtra("sim_nao", "SIM");
                startActivity(intent);
            }
        });

        botao_nao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = campo_nome.getText().toString();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("campo_nome", texto);
                intent.putExtra("sim_nao", "NÃO");
                startActivity(intent);
            }
        });

    }
}