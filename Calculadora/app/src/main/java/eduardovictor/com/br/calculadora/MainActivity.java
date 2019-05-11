package eduardovictor.com.br.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button botao_0;
    private Button botao_1;
    private Button botao_2;
    private Button botao_3;
    private Button botao_4;
    private Button botao_5;
    private Button botao_6;
    private Button botao_7;
    private Button botao_8;
    private Button botao_9;
    private Button botao_ad;
    private Button botao_sub;
    private Button botao_mul;
    private Button botao_div;
    private Button botao_calc;
    private TextView tela;
    private String[] operacoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurarButtons();
        operacoes = new String[]{"+", "-", "*", "/"};

        botao_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '0';
                tela.setText(telaTemp);
            }
        });

        botao_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '1';
                tela.setText(telaTemp);
            }
        });

        botao_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '2';
                tela.setText(telaTemp);
            }
        });

        botao_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '3';
                tela.setText(telaTemp);
            }
        });

        botao_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '4';
                tela.setText(telaTemp);
            }
        });

        botao_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '5';
                tela.setText(telaTemp);
            }
        });

        botao_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '6';
                tela.setText(telaTemp);
            }
        });

        botao_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '7';
                tela.setText(telaTemp);
            }
        });

        botao_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '8';
                tela.setText(telaTemp);
            }
        });

        botao_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '9';
                tela.setText(telaTemp);
            }
        });

        botao_ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '+';
                tela.setText(telaTemp);
            }
        });

        botao_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '-';
                tela.setText(telaTemp);
            }
        });

        botao_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '*';
                tela.setText(telaTemp);
            }
        });

        botao_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                telaTemp = telaTemp + '/';
                tela.setText(telaTemp);
            }
        });

        botao_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telaTemp = (String) tela.getText();
                String[] parts = telaTemp.split("[\\W]");;
                ArrayList<String> operacoes = pegarOperacoes(telaTemp);
                // for(String c : operacoes) {
                //   System.out.println(c);
                // }
                // for(int i = 0; i < parts.length; i++){
                //     System.out.println(parts[i]);
                // }

                int t = 1;
                int i = 0;
                ArrayList<String> array = new ArrayList<String>();
                while(t != 0){
                    // System.out.println(i);
                    if(i < parts.length){
                        array.add(parts[i]);
                    }
                    if(i < operacoes.size()){
                        array.add(operacoes.get(i));
                    }
                    i++;
                    if(i >= parts.length && i >= operacoes.size()){
                        t = 0;
                    }
                }
                // array.remove(4);
                // for(String c : array) {
                //     System.out.print(c);
                // }
                // array.set(0, "10");
                // System.out.print("\n");
                // for(String c : array) {
                //     System.out.print(c);
                // }




                boolean verificacao = false;
                //   5 * 7 + 2
                while(verificacao != true){
                    for(int z = 0; z < array.size(); z++){
                        if(array.get(0).charAt(0) == '-'){
                            String posicao_1 = array.get(0);
                            String posicao_3 = array.get(2);
                            posicao_1 = posicao_1.replace("-", "");
                            array.set(0, posicao_3);
                            array.set(1, "-");
                            array.set(2, posicao_1);
                        }else if(array.get(0).charAt(0) == '-' && array.get(0).charAt(1) == '0'){
                        array.set(0, "0");
                        }
                        if(!Character.isDigit(array.get(z).charAt(0))){
                            double anterior;
                            double proximo;
                            // System.out.println("Operacao");
                            if(array.get(z).charAt(0) == '/'){
//                                System.out.println("Entrei na div /");
                                anterior = Double.parseDouble(array.get(z - 1));
                                proximo = Double.parseDouble(array.get(z + 1));
                                double resultado = anterior / proximo;
                                array.set(z, Double.toString(resultado));
                                array.remove(z + 1);
                                array.remove(z - 1);
                            }else if(array.get(z).charAt(0) == '*'){
//                                System.out.println("Entrei na mult *");
                                anterior = Double.parseDouble(array.get(z - 1));
                                proximo = Double.parseDouble(array.get(z + 1));
                                double resultado = anterior * proximo;
                                array.set(z - 1, Double.toString(resultado));
                                array.remove(z);
                                array.remove(z);
                            }else if(array.get(z).charAt(0) == '+'){
//                                System.out.println("Entrei na adicao +");
                                anterior = Double.parseDouble(array.get(z - 1));
                                proximo = Double.parseDouble(array.get(z + 1));
                                double resultado = anterior + proximo;
                                array.set(z - 1, Double.toString(resultado));
                                array.remove(z);
                                array.remove(z);
                            }else if(array.get(z).charAt(0) == '-'){
//                                System.out.println("Entrei na sub -");
                                anterior = Double.parseDouble(array.get(z - 1));
                                proximo = Double.parseDouble(array.get(z + 1));
                                double resultado = anterior - proximo;
                                array.set(z - 1, Double.toString(resultado));
                                array.remove(z);
                                array.remove(z);
                            }
                        }
//                        else{
//                            System.out.println("Sou numero");
//                        }
//                        for(String c : array) {
//                            System.out.print(c);
//                        }
//                        System.out.println("\n");
                    }

                    verificacao = verificarApenasNumeros(array);
                };
                tela.setText(array.get(0));
            }
        });

        tela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tela.setText("");
            }
        });
    }

    public static ArrayList<String> pegarOperacoes(String str){
        ArrayList<String> operacoes = new ArrayList<String>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/'){
                operacoes.add(Character.toString(c));
            }
        }
        return operacoes;
    }

    public static boolean verificarApenasNumeros(ArrayList<String> string){
        if(string.get(0).charAt(0) == '-' && string.size() == 1){
            return true;
        }
        if(string == null || string.size() == 0){
            return false;
        }
        for(String c : string){
            if(!Character.isDigit(c.charAt(0))){
                return false;
            }
        }
        return true;
    }

    public void configurarButtons(){
        botao_0 = findViewById(R.id.button_zero);
        botao_1 = findViewById(R.id.button_um);
        botao_2 = findViewById(R.id.button_dois);
        botao_3 = findViewById(R.id.button_tres);
        botao_4 = findViewById(R.id.button_quatro);
        botao_5 = findViewById(R.id.button_cinco);
        botao_6 = findViewById(R.id.button_seis);
        botao_7 = findViewById(R.id.button_sete);
        botao_8 = findViewById(R.id.button_oito);
        botao_9 = findViewById(R.id.button_nove);
        botao_ad = findViewById(R.id.button_soma);
        botao_sub = findViewById(R.id.button_subtracao);
        botao_mul = findViewById(R.id.button_multiplicacao);
        botao_div = findViewById(R.id.button_divisao);
        botao_calc = findViewById(R.id.button_calcular);
        tela = findViewById(R.id.tela);
    }
}
