package com.example.applistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UnAdaptador extends BaseAdapter {
    private Context context;
    private int layout;
    private List<String> estados;

    public UnAdaptador(Context context, int layout, List<String> estados){
        this.context = context;
        this.layout = layout;
        this.estados = estados;
    }

    @Override
    public int getCount() {
        return this.estados.size();
    }

    @Override
    public Object getItem(int position) {
        return this.estados.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //copiamos la vista
        View v = convertView;
        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_item,  null);
        //Valor actual segun la posicion
        String estado = estados.get(position);
        // Refrenciamos el elemento a modificar y lo rellenamos
        TextView textView = v.findViewById(R.id.tvTexto);
        textView.setText(estado);
        //Devolvemos la vista inflada
        return v;


    }
}
