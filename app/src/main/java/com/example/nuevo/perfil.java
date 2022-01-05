package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;

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
        String logn = getIntent().getStringExtra("numerodecontrol");
        cajanumero.setText("numerodecontrol:_"+logn);

        cajatextnombre=(TextView)findViewById(R.id.textnom);
        String login = getIntent().getStringExtra("nombre");
        cajatextnombre.setText("nombres:_"+login);

        cajaapellp=(TextView)findViewById(R.id.textapellp);
        String log = getIntent().getStringExtra("apellidoP");
        cajaapellp.setText("apellidoP:_"+log);

        cajaapellM=(TextView)findViewById(R.id.textapellM);
        String lo = getIntent().getStringExtra("apellidoM");
        cajaapellM.setText("apellidoM:_"+lo);

        cajacorreo=(TextView)findViewById(R.id.textCorreo);
        String l = getIntent().getStringExtra("email");
        cajacorreo.setText("email:_"+l);

        cajapwd=(TextView)findViewById(R.id.textcontraseña);
        String ogin = getIntent().getStringExtra("pwd");
        cajapwd.setText("pwd:_"+ogin);

        cajaedad=(TextView)findViewById(R.id.textedad);
        String gin = getIntent().getStringExtra("edad");
        cajaedad.setText("edad:_"+gin);

        cajatel=(TextView)findViewById(R.id.textel);
        String in = getIntent().getStringExtra("telefono");
        cajatel.setText("telefono:_"+in);



    }
}