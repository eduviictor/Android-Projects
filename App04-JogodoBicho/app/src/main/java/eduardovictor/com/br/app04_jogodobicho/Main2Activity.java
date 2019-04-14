package eduardovictor.com.br.app04_jogodobicho;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private ImageView image;
    private TextView resultado_numero;
    private Button button_sair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String animais[] = new String[]{"Avestruz", "Águia", "Burro", "Borboleta", "Cachorro", "Cabra",
                "Carneiro", "Camelo", "Cobra", "Coelho", "Cavalo", "Elefante", "Galo", "Gato", "Jacaré",
                "Leão", "Macaco", "Porco", "Pavão", "Peru", "Touro", "Tigre", "Urso", "Veado", "Vaca"};

        int imagens[] = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4,
                R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9,
                R.drawable.img10, R.drawable.img11, R.drawable.img12, R.drawable.img13, R.drawable.img14,
                R.drawable.img15, R.drawable.img16, R.drawable.img17, R.drawable.img18, R.drawable.img19,
                R.drawable.img20, R.drawable.img21, R.drawable.img22, R.drawable.img23, R.drawable.img24,
                R.drawable.img25};

        Intent intent = getIntent();
        int numero_animal = intent.getIntExtra("numero_animal", 0);

        image = (ImageView) findViewById(R.id.image);

        image.setImageDrawable(getResources().getDrawable(imagens[numero_animal - 1]));

        resultado_numero = (TextView) findViewById(R.id.resultado_numero);

        resultado_numero.setText(Integer.toString(numero_animal));

        button_sair = (Button) findViewById(R.id.sair);

        button_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
