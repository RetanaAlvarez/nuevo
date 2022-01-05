package com.example.nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class lector_qr extends AppCompatActivity {
 public Button btnScanner,salir;
 public TextView tvBarCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lector_qr);

        btnScanner = findViewById(R.id.salir);
        tvBarCode = findViewById(R.id.textView5);
        salir = findViewById(R.id.escanear);

        salir.setOnClickListener(mOnClickListener);


    }
    public void btnScanner (View v){
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result != null)
            if (result.getContents() != null){
                tvBarCode.setText("El codigo de QR es:\n"+result.getContents());
            }else {
                tvBarCode.setText("Error al escanear el codigo ");
            }
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
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