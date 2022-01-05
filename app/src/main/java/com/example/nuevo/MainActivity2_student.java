package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;


public class MainActivity2_student extends AppCompatActivity {
    public Button button,button2;
    public static  final  String name = "nombre";

    TextView cajaBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_student);

        cajaBienvenido = (TextView) findViewById(R.id.textbienvenida);
        String login = getIntent().getStringExtra("nombre");
        cajaBienvenido.setText("¡bienvenido " + login + "!");

        User logi = new User();

        button= (Button) findViewById(R.id.Button_encuesta);
        button2= (Button) findViewById(R.id.button_perfil);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity2_student.this,encuesta.class);
                startActivity(intento);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intento = new Intent(MainActivity2_student.this,perfil.class);
            String login = getIntent().getStringExtra("nombre");
            intento.putExtra(perfil.uss,login);
            startActivity(intento);
        }
    });
    }
}