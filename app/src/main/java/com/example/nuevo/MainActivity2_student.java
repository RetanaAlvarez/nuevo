package com.example.nuevo;
//cabeceras
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2_student extends AppCompatActivity {//implements Response.Listener<JSONObject>,Response.ErrorListener {
    //declaracion de set y get
    User login = new User();
    //declaracion de variable para los botones
    public Button button,button2,button3;
    //declaracion de extracion del nombre
    public static final String name = "nombre", numero = "numerodecontrol",apep = "apellidoP", apem = "apellidoM", edad = "edad", tel = "telefono",correo = "email", pwd = "pwd", no_de_seguro = "no_de_seguro", ID_privilegios = "ID_privilegios";
    //variable para el texto
    TextView cajaBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_student);
        //imprime el mensaje con el nombre
        cajaBienvenido = (TextView) findViewById(R.id.textbienvenida);
        String  numero_control= getIntent().getStringExtra("numerodecontrol");
        String  nombre = getIntent().getStringExtra("nombre");
        String  apellido_p= getIntent().getStringExtra("apellidoP");
        String  apellido_m= getIntent().getStringExtra("apellidoM");
        String  email= getIntent().getStringExtra("email");
        String  contra= getIntent().getStringExtra("pwd");
        String  edad= getIntent().getStringExtra("edad");
        String  tel= getIntent().getStringExtra("telefono");
        String  seguro= getIntent().getStringExtra("no_de_seguro");


        cajaBienvenido.setText("¡BIENVENID@ " + nombre + "!");
        //asignacion con las variables y las variables
        button= (Button) findViewById(R.id.Button_encuesta);
        button3=(Button)findViewById(R.id.button_lector);
        login.setNombre(nombre);
        login.setNumerodecontrol(numero_control);
        login.setApellidoM(apellido_m);
        login.setApellidoP(apellido_p);
        login.setEmail(email);
        login.setPwd(contra);
        login.setEdad(edad);
        login.setTelefono(tel);
        login.setNo_de_seguro(seguro);

        // si se pulsa el boton encuesta manda a esa plantilla
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity2_student.this,encuesta.class);
                startActivity(intento);
            }
        });
        //si se presiona el boton perfil manda esa plantilla
        button2= (Button) findViewById(R.id.button_perfil);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity2_student.this,perfil.class);
                //extracion de vairables especificas para la plantilla perfil
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
        //si se preciona el boton lector qr mandara la plantilla de lector qr
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity2_student.this,lector_qr.class);
                startActivity(intento);
            }
        });
    }

}