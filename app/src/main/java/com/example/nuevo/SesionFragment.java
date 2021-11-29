package com.example.nuevo;

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
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SesionFragment extends Fragment implements  Response.Listener<JSONObject>, Response.ErrorListener {
    RequestQueue rq;
    JsonRequest jrq;


    EditText cajaemail,cajapwd;
    Button btnConsultar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
    }

    @Override
    public void onResponse(JSONObject response) {
        User login = new User();
        Toast.makeText(getContext(),"se ha encontrado el usuario. "+cajaemail.getText().toString(),Toast.LENGTH_SHORT).show();

        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObjectson= null;


        try {
            jsonObjectson= jsonArray.getJSONObject(0);
            login.setEmail(jsonObjectson.optString("email"));
            login.setPwd(jsonObjectson.optString("pwd"));
            login.setNombre(jsonObjectson.optString("nombre"));
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    private void iniciarSecion(){
        String url = "http://192.168.42.130/android/sesion.php?email="+cajaemail.getText().toString()+
                "&pwd="+cajapwd.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET ,url,null,this,this);
        rq.add(jrq);
    }
}