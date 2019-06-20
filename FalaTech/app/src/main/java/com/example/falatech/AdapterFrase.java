package com.example.falatech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterFrase extends ArrayAdapter<Frase> {

    private final Context context;
    private final ArrayList<Frase> listaFrases;

    public AdapterFrase(Context context, ArrayList<Frase> listaFrases){
        super(context, R.layout.linha, listaFrases);
        this.context = context;
        this.listaFrases = listaFrases;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linha = inflater.inflate(R.layout.linha, parent, false);
        TextView descricao = linha.findViewById(R.id.descricao);
        descricao.setText(listaFrases.get(position).getDescricao());
        linha.setId(Integer.parseInt(listaFrases.get(position).getId()));
        return linha;
    }

}
