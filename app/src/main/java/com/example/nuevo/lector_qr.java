package com.example.nuevo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;//enca
public class lector_qr extends AppCompatActivity {
    private Button salir; //declaracion de variable button
    private TextView tvBarCode;//declaracion de variable texto
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lector_qr);//declarion de funciones y lo de la plantilla
        salir = findViewById(R.id.salir);
        tvBarCode = findViewById(R.id.textView5);
        salir.setOnClickListener(mOnClickListener);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);//manda hacer un llamada para que tengamos las funciones del lector
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result != null) //indica que result es nulo prosiga , en lo contrario  no
            if (result.getContents() != null){//comparativa si lo escanio y tiene algo manda msj del contenido
                tvBarCode.setText("El codigo de QR es: \n"+result.getContents());
            }else {//manda mensaje de un error
                tvBarCode.setText("Error al escanear el codigo ");
            }
    }
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { //metodo de que el boton salir es para escanear (es declaro alrevez el nombre)
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.salir:
                    new IntentIntegrator(lector_qr.this).initiateScan();
                    break;
            }
        }
    };
}