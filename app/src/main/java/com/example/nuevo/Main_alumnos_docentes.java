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
    public static final String name = "nombre", numero = "numerodecontrol",apep = "apellidoP", apem = "apellidoM", edad = "edad", tel = "telefono",correo = "email", pwd = "pwd", no_de_seguro = "no_de_seguro", ID_privilegios = "ID_privilegios";
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

        String  numero_control= getIntent().getStringExtra("numerodecontrol");
        String  nombre = getIntent().getStringExtra("nombre");
        String  apellido_p= getIntent().getStringExtra("apellidoP");
        String  apellido_m= getIntent().getStringExtra("apellidoM");
        String  email= getIntent().getStringExtra("email");
        String  contra= getIntent().getStringExtra("pwd");
        String  edad= getIntent().getStringExtra("edad");
        String  tel= getIntent().getStringExtra("telefono");
        String  seguro= getIntent().getStringExtra("no_de_seguro");
        cajaBienvenido.setText("¡BIENVENID@ "+nombre+"!");
        //declarando variable con la funciones de la plantilla
        button= (Button) findViewById(R.id.button);
        button2= (Button) findViewById(R.id.button2);

        login.setNombre(nombre);
        login.setNumerodecontrol(numero_control);
        login.setApellidoM(apellido_m);
        login.setApellidoP(apellido_p);
        login.setEmail(email);
        login.setPwd(contra);
        login.setEdad(edad);
        login.setTelefono(tel);
        login.setNo_de_seguro(seguro);

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
                Intent intento = new Intent(Main_alumnos_docentes.this,perfil.class);
                intento.putExtra("numerodecontrol",login.getNumerodecontrol());
                intento.putExtra("nombre",login.getNombre());
                intento.putExtra("apellidoP",login.getApellidoP());
                intento.putExtra("apellidoM",login.getApellidoM());
                intento.putExtra("email",login.getEmail());
                intento.putExtra("pwd",login.getPwd());
                intento.putExtra("edad",login.getEdad());
                intento.putExtra("telefono",login.getTelefono());
                intento.putExtra("no_de_seguro",login.getNo_de_seguro());
                startActivity(intento);
            }
        });
    }
}