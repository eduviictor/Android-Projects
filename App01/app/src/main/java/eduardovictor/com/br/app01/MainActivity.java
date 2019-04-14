package eduardovictor.com.br.app01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button submit_button;
    private TextView number1;
    private TextView number2;
    private EditText input_number;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit_button = (Button) findViewById(R.id.submit_button);
        number1 = (TextView) findViewById(R.id.number1);
        number2 = (TextView) findViewById(R.id.number2);
        input_number = (EditText) findViewById(R.id.input_number);
        result = (TextView) findViewById(R.id.result);
        generateNumbers();

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1_string = (String) number1.getText();
                String number2_string = (String) number2.getText();
                int int_number1 = Integer.parseInt(number1_string);
                int int_number2 = Integer.parseInt(number2_string);
                int input_number_int = (int) Integer.parseInt(String.valueOf(input_number.getText()));
                if((int_number1 + int_number2) == input_number_int){
                    result.setText("Acertou Miseravi!");
                    generateNumbers();
                }else{
                    result.setText("Tente novamente");
                }

            }
        });

    }

    public void generateNumbers(){
        Random random = new Random();
        int num_random_1 = random.nextInt(100);
        int num_random_2 = random.nextInt(100);
        number1.setText(Integer.toString(num_random_1));
        number2.setText(Integer.toString(num_random_2));
    }

    

}
