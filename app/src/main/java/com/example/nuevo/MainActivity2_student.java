package com.example.nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity2_student extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {
    User logi = new User();
    public Button button,button2;
    public static final String name = "nombre", numero = "numerodecontrol"
            ,apep= "apellidoP",apem="apellidoM",edad="edad",tel="telefono",
            correo="email",pwd="pwd";

    TextView cajaBienvenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_student);

        cajaBienvenido = (TextView) findViewById(R.id.textbienvenida);
        String login = getIntent().getStringExtra("nombre");
        cajaBienvenido.setText("¡bienvenido " + login + "!");

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
                /*intento.putExtra(perfil.numero,logi.getNumerodecontrol());
                intento.putExtra(perfil.apep,logi.getApellidoP());
                intento.putExtra(perfil.apem,logi.getApellidosM());
                intento.putExtra(perfil.correo,logi.getEmail());
                intento.putExtra(perfil.pwd,logi.getPwd());
                intento.putExtra(perfil.edad,logi.getEdad());
                intento.putExtra(perfil.tel,logi.getTelefono());*/
                startActivity(intento);

        }
    });
    }

    public void consulta(){
        String url = "http://controltesjo.000webhostapp.com/sesion.php?&email="+logi.getEmail().toString()+
                //String url = "https://192.168.1.142/sesion.php?&email="+cajaemail.getText().toString()+
                "&pwd="+logi.getPwd().toString();
/*
        jrq = new JsonObjectRequest(Request.Method.GET ,url,null,this,this);
        rq.add(jrq);*/
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObject = null;


        try {
            jsonObject = jsonArray.getJSONObject(0);
            logi.setNumerodecontrol(jsonObject.optString("numerodecontrol"));
            logi.setApellidoP(jsonObject.optString("apellidoP"));
            logi.setApellidosM(jsonObject.optString("apellidosM"));
            logi.setEmail(jsonObject.optString("email"));
            logi.setPwd(jsonObject.optString("pwd"));
            logi.setEdad(jsonObject.optString("edad"));
            logi.setTelefono(jsonObject.optString("telefono"));

            Intent intent = new Intent(this,perfil.class);
            intent.putExtra(perfil.numero,logi.getNumerodecontrol());
            startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}