package com.example.cadastroprodutos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "produtos.db";
    private static final int VERSAO_BANCO = 1;
    private Context context;
    private SQLiteDatabase dbInstancia = null;
    DBHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE produtos (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, preco TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS produtos");
        onCreate(db);
    }

    public void abrirDB() throws SQLException{
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

    public void insertProduto(Produto produto) throws SQLException{
        abrirDB();
        dbInstancia.insert("produtos", null, produto.getContentValues());
        Toast.makeText(context, produto.getNome() + " cadastrado.", Toast.LENGTH_LONG).show();
        fecharDB();
    }

    public ArrayList<Produto> getDBProdutos(){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        SQLiteDatabase banco = getReadableDatabase();
        Cursor query = banco.rawQuery("SELECT nome, preco FROM produtos ORDER BY nome", null);
        query.moveToFirst();
        while (!query.isAfterLast()){
            Log.d(query.getString(1), "query");
            Produto produto = new Produto(query.getString(0), query.getString(1));
            produtos.add(produto);
            query.moveToNext();
        }
        banco.close();
        query.close();
        return produtos;
    }

}
