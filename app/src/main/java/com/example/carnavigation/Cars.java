package com.example.carnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.le.AdvertiseData;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.EditText;


public class Cars extends AppCompatActivity {

    public static int ADDResult = 1;
    public static int CNLResult = 2;
    EditText edtModelo;
    EditText edtMarca;
    EditText edtValor;
    boolean edit;
    int idcarro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        edtModelo = findViewById(R.id.editTextModelo);
        edtMarca = findViewById(R.id.editTextMarca);
        edtValor = findViewById(R.id.editTextValor);
        edit = false;

        if(getIntent().getExtras() != null){
            String modelo = (String)getIntent().getExtras().get("Modelo");
            String marca = (String)getIntent().getExtras().get("Marca");
            String valor = (String)getIntent().getExtras().get("Valor");
            idcarro = (int)getIntent().getExtras().get("id");
            edtModelo.setText(modelo);
            edtMarca.setText(marca);
            edtValor.setText(valor);
            edit = true;
        }
    }
    public void add(View view ) {
        Intent intent = new Intent();
        String modelo = edtModelo.getText().toString();
        String marca = edtMarca.getText().toString();
        String valor = edtValor.getText().toString();
        intent.putExtra("Modelo", modelo);
        intent.putExtra("Marca", marca);
        intent.putExtra("Valor", valor);

        if(edit) {
            intent.putExtra("id", idcarro);
        }
        setResult(ADDResult, intent);
        finish();
    }
    public void cnl(View view){
        setResult(CNLResult);
        finish();
        }


}