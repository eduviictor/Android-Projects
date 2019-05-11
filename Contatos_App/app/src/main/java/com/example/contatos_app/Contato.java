package com.example.contatos_app;

import android.content.Intent;
import android.net.Uri;

public class Contato {

    private String nome;
    private String numero;
    private String letra;

    public Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
        this.letra = nome.substring(0, 1);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getLetra() {
        return letra;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Intent discar(){
        Uri uri = Uri.parse("tel:" + numero);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        return intent;
    }
}
