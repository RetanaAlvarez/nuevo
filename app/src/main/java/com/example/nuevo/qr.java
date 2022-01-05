package com.example.nuevo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.google.zxing.MultiFormatWriter;
import androidx.appcompat.app.AppCompatActivity;




public class qr extends AppCompatActivity {
    //inicializar variables
    EditText etInput;
    Button btGenerate;
    ImageView ivOutput;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);


        //asignacion de variable

        etInput= findViewById(R.id.et_input);
        btGenerate=findViewById(R.id.bt_generate);
        ivOutput=findViewById(R.id.iv_output);

        btGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get salida valor de editar texto
                String sText = etInput.getText().toString().trim();
                //inicializa multi forma excritura
                MultiFormatWriter writer = new MultiFormatWriter();
            }
        });
    }
}