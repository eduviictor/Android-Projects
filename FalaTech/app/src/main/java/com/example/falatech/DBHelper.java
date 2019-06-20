package com.example.falatech;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "frases.db";
    private static final int VERSAO_BANCO = 3;
    private Context context;
    private SQLiteDatabase dbInstancia = null;

    DBHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE frases (id INTEGER PRIMARY KEY AUTOINCREMENT, descricao TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS frases");
        onCreate(db);
    }

    public void abrirDB() throws SQLException {
        if(this.dbInstancia == null){
            this.dbInstancia = this.getWritableDatabase();
        }
    }

    public void fecharDB() throws SQLException{
        if(this.dbInstancia != null){
            if(this.dbInstancia.isOpen()){
                this.dbInstancia.close();
            }
        }
    }

    public void insertFrase(Frase frase) throws SQLException{
        abrirDB();
        dbInstancia.insert("frases", null, frase.getContentValues());
        Toast.makeText(context, frase.getDescricao() + " cadastrado.", Toast.LENGTH_LONG).show();
        fecharDB();
    }

    public ArrayList<Frase> getDBFrases(){
        ArrayList<Frase> frases = new ArrayList<Frase>();
        SQLiteDatabase banco = getReadableDatabase();
        Cursor query = banco.rawQuery("SELECT descricao, id FROM frases", null);
        query.moveToFirst();
        while (!query.isAfterLast()){
            Log.d(query.getString(0), query.toString());
            Frase frase = new Frase(query.getString(0));
            frase.setId(query.getString(1));
            frases.add(frase);
            query.moveToNext();
        }
        banco.close();
        query.close();
        return frases;
    }

    public void delete(int id){
        abrirDB();
        try{
            dbInstancia.delete("frases",  "id = " + id, null);
        }catch (Exception e){
            Log.d("error delete", e.toString());
        }
        Toast.makeText(context, "Item deletado.", Toast.LENGTH_LONG).show();
        fecharDB();
    }

    public void updateFrase(Frase frase, int id){
        abrirDB();

        try{
            dbInstancia.update("frases", frase.getContentValues(), "id = " + id, null);
        }catch (Exception e){
            Log.d("error delete", e.toString());
        }
        Toast.makeText(context, "Item Atualizado.", Toast.LENGTH_LONG).show();
        fecharDB();
    }
}
