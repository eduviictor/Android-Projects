package com.example.cadastroprodutos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterProduto extends ArrayAdapter<Produto> {

    private final Context context;
    private final ArrayList<Produto> listaProdutos;

    public AdapterProduto(Context context, ArrayList<Produto> listaProdutos) {
        super(context, R.layout.linha, listaProdutos);
        this.context = context;
        this.listaProdutos= listaProdutos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linha = inflater.inflate(R.layout.linha, parent, false);
        TextView titulo = (TextView) linha.findViewById(R.id.nome);
        TextView preco = (TextView) linha.findViewById(R.id.preco);
        titulo.setText(listaProdutos.get(position).getNome());
        preco.setText("R$ " + listaProdutos.get(position).getPreco());
        return linha;
    }
}
