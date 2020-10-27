package com.example.applistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MultipleChoiceActivity extends AppCompatActivity {
    private ListView miLista;
    private List<String> selecciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);

        selecciones = new ArrayList<>();
        miLista  = findViewById(R.id.listaMultiple);
        String[] datos = getResources().getStringArray(R.array.entidades_federativas);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice,datos);
        miLista.setAdapter(adaptador);
        miLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = parent.getAdapter().getItem(position).toString();
                ListView lista = (ListView) parent;
                if (lista.isItemChecked(position))
                    selecciones.add(seleccion);
                else
                    selecciones.remove(seleccion);
                if (!selecciones.isEmpty())
                    Toast.makeText(getApplicationContext(),selecciones.toString(),Toast.LENGTH_LONG).show();
            }
        } );


    }
}