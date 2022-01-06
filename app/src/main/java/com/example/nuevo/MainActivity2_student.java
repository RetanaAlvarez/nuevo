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
    public static final String name = "nombre";
    //variable para el texto
    TextView cajaBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_student);
        //imprime el mensaje con el nombre
        cajaBienvenido = (TextView) findViewById(R.id.textbienvenida);
        String logi = getIntent().getStringExtra("nombre");
        cajaBienvenido.setText("¡bienvenido " + logi + "!");
        //asignacion con las variables y las variables
        button= (Button) findViewById(R.id.Button_encuesta);
        button3=(Button)findViewById(R.id.button_lector);
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
                intento.putExtra(perfil.uss,login.getNombre());
                intento.putExtra(perfil.apep,login.getApellidoP());
                intento.putExtra(perfil.apem,login.getApellidosM());
                intento.putExtra(perfil.correo,login.getEmail());
                intento.putExtra(perfil.pwd,login.getPwd());
                intento.putExtra(perfil.edad,login.getEdad());
                intento.putExtra(perfil.tel,login.getTelefono());
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