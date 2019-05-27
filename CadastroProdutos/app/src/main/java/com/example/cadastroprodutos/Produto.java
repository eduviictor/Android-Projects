package com.example.cadastroprodutos;

import android.content.ContentValues;

public class Produto {
    private String nome;
    private String preco;

    public Produto(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPreco() {
        return preco;
    }
    public void setPreco(String preco) {
        this.preco = preco;
    }

    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        cv.put("nome", this.nome);
        cv.put("preco", this.preco);
        return cv;
    }
}
