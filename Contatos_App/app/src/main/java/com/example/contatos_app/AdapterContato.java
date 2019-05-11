package com.example.contatos_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterContato extends ArrayAdapter<Contato> {

    private final Context context;
    private final ArrayList<Contato> listaContatos;

    public AdapterContato(Context context, ArrayList<Contato> listaContatos) {
        super(context, R.layout.linha, listaContatos);
        this.context = context;
        this.listaContatos = listaContatos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View linha = inflater.inflate(R.layout.linha, parent, false);
        TextView titulo = (TextView) linha.findViewById(R.id.texto1);
        TextView autor = (TextView) linha.findViewById(R.id.texto2);
        TextView letra = (TextView) linha.findViewById(R.id.letra);
        titulo.setText(listaContatos.get(position).getNome());
        autor.setText(listaContatos.get(position).getNumero());
        letra.setText(listaContatos.get(position).getLetra());
        return linha;
    }
}
