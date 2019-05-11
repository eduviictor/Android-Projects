package com.example.jogodobicho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jogodobicho.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView campo_milhar1;
    private TextView campo_milhar2;
    private TextView campo_milhar3;
    private TextView campo_milhar4;
    private TextView campo_milhar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo_milhar1 = (TextView) findViewById(R.id.campo_milhar1);
        campo_milhar2 = (TextView) findViewById(R.id.campo_milhar2);
        campo_milhar3 = (TextView) findViewById(R.id.campo_milhar3);
        campo_milhar4 = (TextView) findViewById(R.id.campo_milhar4);
        campo_milhar5 = (TextView) findViewById(R.id.campo_milhar5);

        String string_milhar1 = gerarMilhar();
        String string_milhar2 = gerarMilhar();
        String string_milhar3 = gerarMilhar();
        String string_milhar4 = gerarMilhar();
        String string_milhar5 = gerarMilhar();

        campo_milhar1.setText("1º: " + string_milhar1);
        campo_milhar2.setText("2º: " + string_milhar2);
        campo_milhar3.setText("3º: " + string_milhar3);
        campo_milhar4.setText("4º: " + string_milhar4);
        campo_milhar5.setText("5º: " + string_milhar5);

        int dezena_milhar1 = getDezena(string_milhar1);
        int dezena_milhar2 = getDezena(string_milhar2);
        int dezena_milhar3 = getDezena(string_milhar3);
        int dezena_milhar4 = getDezena(string_milhar4);
        int dezena_milhar5 = getDezena(string_milhar5);

        final int numero_animal1 = getNumeroAnimal(dezena_milhar1);
        final int numero_animal2 = getNumeroAnimal(dezena_milhar2);
        final int numero_animal3 = getNumeroAnimal(dezena_milhar3);
        final int numero_animal4 = getNumeroAnimal(dezena_milhar4);
        final int numero_animal5 = getNumeroAnimal(dezena_milhar5);

        campo_milhar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("numero_animal", numero_animal1);
                startActivity(intent);
            }
        });

        campo_milhar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("numero_animal", numero_animal2);
                startActivity(intent);
            }
        });

        campo_milhar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("numero_animal", numero_animal3);
                startActivity(intent);
            }
        });

        campo_milhar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("numero_animal", numero_animal4);
                startActivity(intent);
            }
        });

        campo_milhar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("numero_animal", numero_animal5);
                startActivity(intent);
            }
        });

//        campo_milhar.setText(number);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                intent.putExtra("numero_animal", numero_animal);
//                startActivity(intent);
//            }
//        });
    }

    public String gerarMilhar(){
        Random random = new Random();
        String number = Integer.toString(random.nextInt(9));
        number += Integer.toString(random.nextInt(9));
        number += Integer.toString(random.nextInt(9));
        number += Integer.toString(random.nextInt(9));
        return number;
    }

    public int getDezena(String number){
        char [] number_char = number.toCharArray();
        String number_dezena_string = Character.toString(number_char[2]);
        number_dezena_string += Character.toString(number_char[3]);
        int number_int = Integer.parseInt(number_dezena_string);
        return number_int;
    }

    public int getNumeroAnimal(int number_int){
        double number_double = (double) number_int;
        int numero_animal = (int) Math.ceil(number_double/4);
        return numero_animal;
    }




}
