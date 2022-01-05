package com.example.nuevo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class perfil extends AppCompatActivity {
    public Button button;
    public static final String uss = "nombre", numero = "numerodecontrol"
            ,apep= "apellidoP",apem="apellidoM",edad="edad",tel="telefono",
            correo="email",pwd="pwd";

    TextView cajatextnombre,cajanumero ,cajaapellp ,cajaapellM
            ,cajacorreo ,cajapwd ,cajaedad ,cajatel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        cajanumero=(TextView)findViewById(R.id.textnumero);
        String logi = getIntent().getStringExtra("numerodecontrol");
        cajanumero.setText("numero de control: "+logi);

        cajaapellp=(TextView)findViewById(R.id.textapellp);
        logi = getIntent().getStringExtra("apellidoP");
        cajaapellp.setText("apellido P: "+logi);

        cajaapellM=(TextView)findViewById(R.id.textapellM);
        logi = getIntent().getStringExtra("apellidoM");
        cajaapellM.setText("apellido M: "+logi);

        cajacorreo=(TextView)findViewById(R.id.textCorreo);
        logi = getIntent().getStringExtra("email");
        cajacorreo.setText("email: "+logi);

        cajapwd=(TextView)findViewById(R.id.textcontraseña);
        logi = getIntent().getStringExtra("pwd");
        cajapwd.setText("pwd: "+logi);

        cajaedad=(TextView)findViewById(R.id.textedad);
        logi = getIntent().getStringExtra("edad");
        cajaedad.setText("edad: "+logi);

        cajatel=(TextView)findViewById(R.id.textel);
        logi= getIntent().getStringExtra("telefono");
        cajatel.setText("telefono: "+logi);

    }
}