package com.example.nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main_alumnos_docentes extends AppCompatActivity {
    public Button button,button2;
    public static  final  String names = "nombre";

    TextView cajaBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alumnos_docentes);
        User logi= new User();
        cajaBienvenido=(TextView)findViewById(R.id.txtBienvenida);
        String login=getIntent().getStringExtra("nombre");
        cajaBienvenido.setText("¡bienvenido "+login+"!");

        button= (Button) findViewById(R.id.button);
        button2= (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Main_alumnos_docentes.this,encuesta.class);
                startActivity(intento);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Main_alumnos_docentes.this,perfil.class);
                //intento.putExtra(perfil.uss,login.getNombre());
                startActivity(intento);
            }
        });
    }
}