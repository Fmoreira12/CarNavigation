package com.example.carnavigation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class Begin extends AppCompatActivity {
    public static int ADDRequest = 1;
    public static int EDTRequest = 2;

    ArrayList<Vehicles> carros;
    ArrayAdapter adapter;
    ListView list;
    int s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        s = -1;
        carros = new ArrayList<Vehicles>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, carros);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setSelector(android.R.color.holo_red_light);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Toast.makeText(Begin.this, "" + carros.get(position).toString(), Toast.LENGTH_SHORT).show();
                s = position;
            }
        });
    }
    public void addclique(View view){
        Intent intent = new Intent(this, Cars.class);
        startActivityForResult( intent, ADDRequest );

    }
    public void edtclique(View view){
        Intent intent = new Intent(this, Cars.class);

        Vehicles vehicles = carros.get( s );
        intent.putExtra("id", vehicles.getId());
        intent.putExtra("Modelo", vehicles.getModelo());
        intent.putExtra("Marca", vehicles.getMarca());
        intent.putExtra("Valor", vehicles.getValor());
        startActivityForResult( intent, EDTRequest );

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADDRequest && resultCode == Cars.ADDResult) {
            String modelo = (String) data.getExtras().get("Modelo");
            String marca = (String) data.getExtras().get("Marca");
            String valor = (String) data.getExtras().get("Valor");
            Vehicles vehicles = new Vehicles(modelo, marca, valor);
            carros.add(vehicles);
            adapter.notifyDataSetChanged();

        }

        else if (requestCode == EDTRequest && resultCode == Cars.ADDResult) {

            String modelo = (String) data.getExtras().get("Modelo");
            String marca = (String) data.getExtras().get("Marca");
            String valor = (String) data.getExtras().get("Valor");
            int idedt = (int)data.getExtras().get("id");

            for(Vehicles vehicles: carros){
                if(vehicles.getId() == idedt) {
                    vehicles.setModelo(modelo);
                    vehicles.setMarca(marca);
                    vehicles.setValor(valor);
                }
            }


            adapter.notifyDataSetChanged();

        } else if(resultCode == Cars.CNLResult){
            Toast.makeText(this, "Evento cancelado",
                    Toast.LENGTH_LONG).show();
        }
    }
}