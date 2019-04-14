package eduardovictor.com.br.app03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private TextView resultado;
    private TextView sim_nao_campo;
    private Button button_sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        resultado = (TextView) findViewById(R.id.resultado_nome);
        sim_nao_campo = (TextView) findViewById(R.id.resultado_sim_nao);

        Intent intent = getIntent();
        String campo = intent.getStringExtra("campo_nome");
        String sim_nao = intent.getStringExtra("sim_nao");

        resultado.setText(campo);
        sim_nao_campo.setText(sim_nao);

        button_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
