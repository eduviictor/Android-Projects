package com.example.falatech;

import android.content.ContentValues;

public class Frase {

    private String descricao;
    private String id;

    public Frase(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        cv.put("descricao", this.descricao);
        return cv;
    }
}
