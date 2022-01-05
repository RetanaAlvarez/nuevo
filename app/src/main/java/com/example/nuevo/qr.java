package com.example.nuevo;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class qr extends AppCompatActivity {
    //inicializar variables
    EditText etInput;
    Button btGenerate;
    ImageView ivOutput;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        User login = new User();

        //asignacion de variable

        etInput= findViewById(R.id.et_input);
        btGenerate=findViewById(R.id.bt_generate);
        ivOutput=findViewById(R.id.iv_output);

        btGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get salida valor de editar texto
                String sText=login.getNumerodecontrol();
                 sText = etInput.getText().toString().trim();
                //inicializa multi forma excritura
                MultiFormatWriter writer = new MultiFormatWriter();
                try{
                    //inicializar bit matriz
                    BitMatrix matrix = writer.encode(sText, BarcodeFormat.QR_CODE
                    ,350,350);
                    //inicializar barcode encoder
                    BarcodeEncoder encoder = new BarcodeEncoder();
                    //inicializar bitmap
                    Bitmap bitmap = encoder.createBitmap(matrix);
                    //set bitmap en imagen view
                    ivOutput.setImageBitmap(bitmap);
                    //inicializar salir manager
                    InputMethodManager manager = (InputMethodManager)  getSystemService(
                            Context.INPUT_METHOD_SERVICE
                    );
                    //hide soft keyboard
                    manager.hideSoftInputFromWindow(etInput.getApplicationWindowToken(),1);
                }catch (WriterException e){
                    e.printStackTrace();
                }

            }
        });
    }
    public void Salir(View v){
        finish();
    }
}