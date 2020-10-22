package com.example.applistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> estados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        //estados=Arrays.asList(getResources().getStringArray(R.array.entidades_federativas));
        estados = Arrays.asList("Campeche","Zacatecas","Michoacan","Jalisco","Durango","Veracruz");
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, estados);
        UnAdaptador adapter = new UnAdaptador(this, R.layout.list_item, estados);
        listView.setAdapter(adapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String texto = (String) parent.getAdapter().getItem(position);
                Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show();
            }
        });

    }
}