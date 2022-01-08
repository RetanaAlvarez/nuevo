package com.example.nuevo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;
public class qr extends AppCompatActivity  {
    public static final String numeros = "numerodecontrol";
    EditText txtDatos;
    TextView txtBienvenida;
    Button btnGenera;
    ImageView imgQr;
    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        txtDatos = findViewById(R.id.txtDatos);
        btnGenera = findViewById(R.id.btnGenerar);
        imgQr = findViewById(R.id.imagen);
        txtBienvenida = (TextView) findViewById(R.id.txtBienvenida);
        String login = "Esta en condiciones para presentar a la escuela este Usuario";
        btnGenera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(login
                            , BarcodeFormat.QR_CODE, 750, 750);
                    imgQr.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_qr, container, false); }
    public void Salir(View v) {
        finish();
    }
}