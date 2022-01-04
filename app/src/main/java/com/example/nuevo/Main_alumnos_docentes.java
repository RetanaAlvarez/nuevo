package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class Main_alumnos_docentes extends AppCompatActivity {
    public Button button;
    public static  final  String names = "nombre";

    TextView cajaBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alumnos_docentes);

        cajaBienvenido=(TextView)findViewById(R.id.txtBienvenida);
        String login=getIntent().getStringExtra("nombre");
        cajaBienvenido.setText("¡bienvenido "+login+"!");
/*
        button= (Button) findViewById(R.id.Button_encuesta);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Main_alumnos_docentes.this,encuesta.class);
                startActivity(intento);
            }
        });*/
    }
}