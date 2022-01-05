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

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.json.JSONObject;


public class qr extends AppCompatActivity  implements  Response.Listener<JSONObject>, Response.ErrorListener {

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


        txtBienvenida = (TextView) findViewById(R.id.txtBienvenida);//txtDatos=(TextView)findViewById(R.id.txtBienvenida);
        String login = "2018150480810";


        btnGenera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//                    User logi= new User();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(login
                            , BarcodeFormat.QR_CODE, 750, 750);
                    imgQr.setImageBitmap(bitmap);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    return  inflater.inflate(R.layout.activity_qr, container , false);
    }

    public void Salir(View v) {
        finish();
    }



    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }

}

