package com.example.applistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class SingleChoiceActivity extends AppCompatActivity {
    private ListView miLista;
    //private List<String> selecciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_choice);

        miLista  = findViewById(R.id.listaSingle);
        String[] datos = getResources().getStringArray(R.array.entidades_federativas);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice,datos);
        miLista.setAdapter(adaptador);
        miLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckedTextView checkedTextView = (CheckedTextView) view;
                if(checkedTextView.isChecked())
                    Toast.makeText(getApplicationContext(), parent.getAdapter().getItem(position).toString(), Toast.LENGTH_LONG).show();
            }
        } );


    }
}