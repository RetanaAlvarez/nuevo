package com.example.nuevo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class perfil extends AppCompatActivity {
    public Button button, buttonnsultar;
    public static final String uss = "nombre", numero = "numerodecontrol", apep = "apellidoP", apem = "apellidoM", edad = "edad", tel = "telefono", correo = "email", pwd = "pwd", no_de_seguro = "no_de_seguro", ID_privilegios = "ID_privilegios";

    TextView cajatextnombre, cajanumero, cajaapellp, cajaapellM, cajacorreo, cajapwd, cajaedad, cajatel, cajaseguro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        buttonnsultar = (Button) findViewById(R.id.buttonnsultar);
        cajatextnombre = (TextView) findViewById(R.id.textnombre);
        cajanumero = (TextView) findViewById(R.id.textnumero);
        cajaapellp = (TextView) findViewById(R.id.textapellp);
        cajaapellM = (TextView) findViewById(R.id.textapellM);
        cajacorreo = (TextView) findViewById(R.id.textCorreo);
        cajapwd = (TextView) findViewById(R.id.textcontraseña);
        cajaedad = (TextView) findViewById(R.id.textedad);
        cajatel = (TextView) findViewById(R.id.textel);
        cajaseguro = (TextView) findViewById(R.id.no_de_seguro);

        buttonnsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    consultar();
            }
        });

    }

    public void consultar(){



        String logi = getIntent().getStringExtra("numerodecontrol");
        cajanumero.setText("numero de control: " + logi);

         logi = getIntent().getStringExtra("nombre");
        cajatextnombre.setText("Nombre :" + logi );

        logi = getIntent().getStringExtra("apellidoP");
        cajaapellp.setText("apellido P: " + logi);

        logi = getIntent().getStringExtra("apellidoM");
        cajaapellM.setText("apellido M: " + logi);

        logi = getIntent().getStringExtra("email");
        cajacorreo.setText("email: " + logi);

        ;
        logi = getIntent().getStringExtra("pwd");
        cajapwd.setText("pwd: " + logi);

        logi = getIntent().getStringExtra("edad");
        cajaedad.setText("edad: " + logi);

        logi = getIntent().getStringExtra("telefono");
        cajatel.setText("telefono: " + logi);

        logi = getIntent().getStringExtra("no");
        cajatel.setText("telefono: " + logi);
    }
        public void salir (View v){
            finish();
        }

}