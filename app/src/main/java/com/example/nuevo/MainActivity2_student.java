package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2_student extends AppCompatActivity {

    public static  final  String name = "nombre";

    TextView cajaBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_student);

        cajaBienvenido=(TextView)findViewById(R.id.textbienvenida);
        String login=getIntent().getStringExtra("nombre");
        cajaBienvenido.setText("¡bienvenido "+login+"!");
    }
}