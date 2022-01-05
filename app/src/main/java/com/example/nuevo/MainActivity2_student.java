package com.example.nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2_student extends AppCompatActivity {//implements Response.Listener<JSONObject>,Response.ErrorListener {
    User login = new User();
    public Button button,button2;
    public static final String name = "nombre";

    TextView cajaBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_student);

        cajaBienvenido = (TextView) findViewById(R.id.textbienvenida);
        String logi = getIntent().getStringExtra("nombre");
        cajaBienvenido.setText("¡bienvenido " + logi + "!");

        button= (Button) findViewById(R.id.Button_encuesta);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity2_student.this,encuesta.class);
                startActivity(intento);
            }
        });
        button2= (Button) findViewById(R.id.button_perfil);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity2_student.this,perfil.class);
               // intento.putExtra(perfil.uss,login.getNombre());
                /*intento.putExtra(perfil.apep,logi.getApellidoP());
                intento.putExtra(perfil.apem,logi.getApellidosM());
                intento.putExtra(perfil.correo,logi.getEmail());
                intento.putExtra(perfil.pwd,logi.getPwd());
                intento.putExtra(perfil.edad,logi.getEdad());
                intento.putExtra(perfil.tel,logi.getTelefono());*/
                startActivity(intento);

        }
    });
    }

}