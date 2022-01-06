package com.example.nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main_alumnos_docentes extends AppCompatActivity {
    //creacion de botones variables
    public Button button,button2;
    //creacion de extracion del nombre
    public static  final  String names = "nombre";
    //variable del texto
    TextView cajaBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alumnos_docentes);
        //llamado de los get y set
        User login= new User();
        cajaBienvenido=(TextView)findViewById(R.id.txtBienvenida);
        //extracion y colocacion del nombre del usuario
        String logi=getIntent().getStringExtra("nombre");
        cajaBienvenido.setText("¡bienvenido "+logi+"!");
        //declarando variable con la funciones de la plantilla
        button= (Button) findViewById(R.id.button);
        button2= (Button) findViewById(R.id.button2);
        //intrucciones que si el button de izquierda se da nos ridicionara a la plantalla de encuesta
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Main_alumnos_docentes.this,encuesta.class);
                startActivity(intento);
            }
        });
        //intrucciones que si el button de Derecha se da nos ridicionara a la plantalla de perfil
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_alumnos_docentes.this,perfil.class);
                intent.putExtra(perfil.uss,login.getNombre());
                intent.putExtra(perfil.numero,login.getNumerodecontrol());
                startActivity(intent);
            }
        });
    }
}