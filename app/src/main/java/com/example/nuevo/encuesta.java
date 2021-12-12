package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class encuesta extends AppCompatActivity {
    public Button button;
    RadioButton rd0pc1,rd0pc2;
    Button  btnSiguiente,btnSalir;
    TextView txtNpregunta, txtPregunta;
    int nota = 0;
    int Npregunta = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        rd0pc1 = (RadioButton) findViewById(R.id.rdBtnOpc1);
        rd0pc2 = (RadioButton) findViewById(R.id.rdBtnOpc2);

        txtNpregunta=(TextView) findViewById(R.id.txtNpregunta);
        txtPregunta=(TextView) findViewById(R.id.txtPregunta);

        btnSiguiente=(Button)findViewById(R.id.btnSiguiente);
        btnSalir=(Button)findViewById(R.id.btnSalir);
    }

    public void Siguiente (View v){
        //if por si no se marca ninguna opcion
        if (rd0pc1.isChecked() == false && rd0pc2.isChecked() == false){
            Toast.makeText(this,"Elija una Opción", Toast.LENGTH_SHORT).show();
        }else  if(Npregunta == 1 ){
            //se verifica la respuesta, si es correcta se agrega 2 puntos a la nota
            if (rd0pc2.isChecked()){
                nota = nota + 2;
            }
            //se le suma 1 al contador de la pregunta
            Npregunta = Npregunta +1;
            //Se setean los texto para la siguiente Pregunta
            txtNpregunta.setText("pregunta 2");
            txtPregunta.setText("Esta es la pregunto 2 , su respuesta correcta es la opcion 1");
            rd0pc1.setText("Opcion 1 p2");
            rd0pc2.setText("Opcion 2 p2");

            //se limpian los radio buttons par ala Siguiente Pregunta
            rd0pc1.setChecked(false);
            rd0pc2.setChecked(false);
        }else if(Npregunta == 2){
            //se verifica la respuesta, si es correcta se agrega 2 puntos a la nota
            if (rd0pc2.isChecked()){
                nota = nota + 2;
            }
            //se le suma 1 al contador de la pregunta
            Npregunta = Npregunta +1;
            //Se setean los texto para la siguiente Pregunta
            txtNpregunta.setText("pregunta 3");
            txtPregunta.setText("Esta es la pregunto 3 , su respuesta correcta es la opcion 1");
            rd0pc1.setText("Opcion 1 p3");
            rd0pc2.setText("Opcion 2 p3");

            //se limpian los radio buttons par ala Siguiente Pregunta
            rd0pc1.setChecked(false);
            rd0pc2.setChecked(false);
        }else if(Npregunta == 3){
            //se verifica la respuesta, si es correcta se agrega 2 puntos a la nota
            if (rd0pc2.isChecked()){
                nota = nota + 2;
            }
            //se le suma 1 al contador de la pregunta
            Npregunta = Npregunta +1;
            //Se setean los texto para la siguiente Pregunta
            txtNpregunta.setText("pregunta 4");
            txtPregunta.setText("Esta es la pregunto 4 , su respuesta correcta es la opcion 1");
            rd0pc1.setText("Opcion 1 p4");
            rd0pc2.setText("Opcion 2 p4");

            //se limpian los radio buttons par ala Siguiente Pregunta
            rd0pc1.setChecked(false);
            rd0pc2.setChecked(false);
        }else  if (Npregunta == 5){
            //se verifica la respuesta, si es correcta se agrega 2 puntos a la nota
            if (rd0pc2.isChecked()){
                nota = nota + 2;
            }
            //se setean los txt para el resultado de la nota
            txtNpregunta.setText("Nota Obtenida: "+nota);
            //if oara verificar si se ha aprobado o reprobado
            if (nota >= 6){
                txtPregunta.setText("Estado: Aprobado");
            }else{
                txtPregunta.setText("Estado: Reprobado");
            }
            // se ocultan las opciones que no se van a usar para ver la nota y resultado
            rd0pc1.setVisibility(View.GONE);
            rd0pc2.setVisibility(View.GONE);
            btnSiguiente.setVisibility(View.GONE);
        }
    }
    public void Salir(View v){
        finish();
    }
}