package com.example.nuevo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class SesionFragment extends Fragment implements  Response.Listener<JSONObject>, Response.ErrorListener {
    User login = new User();
    RequestQueue rq;
    JsonRequest jrq;


    EditText cajaemail,cajapwd;
    Button btnConsultar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sesion, container, false);
        View vista  = inflater.inflate(R.layout.fragment_sesion,container,false);

        cajaemail=(EditText) vista.findViewById(R.id.txtUser);
        cajapwd=(EditText) vista.findViewById(R.id.txtpwd);
        btnConsultar= (Button) vista.findViewById(R.id.btnSesion);

        rq = Volley.newRequestQueue(getContext());

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iniciarSecion();

            }
        }
        );
        return vista;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No se encontro el usuario "+ error.toString(),Toast.LENGTH_SHORT).show();
        error.printStackTrace();

    }

    @Override
    public void onResponse(JSONObject response) {

        Toast.makeText(getContext(),"se ha encontrado el usuario. "+cajaemail.getText().toString(),Toast.LENGTH_SHORT).show();

        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObject= null;


        try {
            jsonObject= jsonArray.getJSONObject(0);
            login.setEmail(jsonObject.optString("email"));
            login.setPwd(jsonObject.optString("pwd"));
            login.setNombre(jsonObject.optString("nombre"));
            login.setNumerodecontrol(jsonObject.optString("numerodecontrol"));
            login.setApellidoP(jsonObject.optString("apellidoP"));
            login.setApellidosM(jsonObject.optString("apellidosM"));
            login.setEdad(jsonObject.optString("edad"));
            login.setNo_de_seguro(jsonObject.optString("no_de_seguro"));
            login.setTelefono(jsonObject.optString("telefono"));

           if(jsonObject.optString("ID_privilegios").equals("3")){
               Intent intento = new Intent(getContext(),MainActivity2_student.class);
               intento.putExtra(MainActivity2_student.name,login.getNombre());
               startActivity(intento);

               intento.putExtra(perfil.uss,login.getNombre());
               intento.putExtra(perfil.apep,login.getApellidoP());
               intento.putExtra(perfil.apem,login.getApellidosM());
               intento.putExtra(perfil.correo,login.getEmail());
               intento.putExtra(perfil.pwd,login.getPwd());
               intento.putExtra(perfil.edad,login.getEdad());
               intento.putExtra(perfil.tel,login.getTelefono());
               intento.putExtra(perfil.no_de_seguro,login.getNo_de_seguro());


            }else if(jsonObject.optString("ID_privilegios").equals ("1") ||
                        jsonObject.optString("ID_privilegios").equals("2")  ){
               Intent intento = new Intent(getContext(),Main_alumnos_docentes.class );
               intento.putExtra(Main_alumnos_docentes.names,login.getNombre());
               startActivity(intento);
               intento.putExtra(perfil.uss,login.getNombre());
               intento.putExtra(perfil.apep,login.getApellidoP());
               intento.putExtra(perfil.apem,login.getApellidosM());
               intento.putExtra(perfil.correo,login.getEmail());
               intento.putExtra(perfil.pwd,login.getPwd());
               intento.putExtra(perfil.edad,login.getEdad());
               intento.putExtra(perfil.tel,login.getTelefono());
               intento.putExtra(perfil.no_de_seguro,login.getNo_de_seguro());

            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    public void iniciarSecion(){
        String url = "http://controltesjo.000webhostapp.com/sesion.php?&email="+cajaemail.getText().toString()+
        //String url = "https://192.168.1.142/sesion.php?&email="+cajaemail.getText().toString()+
                "&pwd="+cajapwd.getText().toString();

        jrq = new JsonObjectRequest(Request.Method.GET ,url,null,this,this);
        rq.add(jrq);

    }
}