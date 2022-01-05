package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class encuesta extends AppCompatActivity {
    //Se declaran los objetos para usarlos
    RadioButton rdBtnOpc1,rdBtnOpc2;
    TextView txtNpregunta, txtPregunta;
    Button  button_siguente,button_salir;
    Button button;
    //se declara las vairables para modificar la pregunta y las  opciones , y para calcular la puntuacion
    int nota = 0;int Npregunta = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        //Se le asigna a cada objeto el id de los que va a usar
        rdBtnOpc1 = (RadioButton) findViewById(R.id.rdBtnOpc1);
        rdBtnOpc2 = (RadioButton) findViewById(R.id.rdBtnOpc2);

        txtNpregunta=(TextView) findViewById(R.id.txtNpregunta);
        txtPregunta=(TextView) findViewById(R.id.txtPregunta);

        button_siguente=(Button)findViewById(R.id.button_siguente);
        button_salir=(Button)findViewById(R.id.button_salir);
    }

    public void Siguiente (View v){
        //if por si no se marca ninguna opcion
        if (rdBtnOpc1.isChecked() == false && rdBtnOpc2.isChecked() == false){
            Toast.makeText(this,"Elija una Opción", Toast.LENGTH_SHORT).show();
        }else  if(Npregunta == 1 ){
            //se verifica la respuesta, si es correcta se agrega 2 puntos a la nota
            if (rdBtnOpc2.isChecked()){
                nota = nota + 2;
            }
            //se le suma 1 al contador de la pregunta
            Npregunta = Npregunta +1;
            //Se setean los texto para la siguiente Pregunta
            txtNpregunta.setText("pregunta 2");
            txtPregunta.setText("Esta es la pregunto 2 , su respuesta correcta es la opcion 1");
            rdBtnOpc1.setText("Opcion 1 p2");
            rdBtnOpc2.setText("Opcion 2 p2");

            //se limpian los radio buttons par ala Siguiente Pregunta
            rdBtnOpc1.setChecked(false);
            rdBtnOpc2.setChecked(false);
        }else if(Npregunta == 2){
            //se verifica la respuesta, si es correcta se agrega 2 puntos a la nota
            if (rdBtnOpc2.isChecked()){
                nota = nota + 2;
            }
            //se le suma 1 al contador de la pregunta
            Npregunta = Npregunta +1;
            //Se setean los texto para la siguiente Pregunta
            txtNpregunta.setText("pregunta 3");
            txtPregunta.setText("Esta es la pregunto 3 , su respuesta correcta es la opcion 1");
            rdBtnOpc1.setText("Opcion 1 p3");
            rdBtnOpc2.setText("Opcion 2 p3");

            //se limpian los radio buttons par ala Siguiente Pregunta
            rdBtnOpc1.setChecked(false);
            rdBtnOpc2.setChecked(false);
        }else if(Npregunta == 3){
            //se verifica la respuesta, si es correcta se agrega 2 puntos a la nota
            if (rdBtnOpc2.isChecked()){
                nota = nota + 2;
            }
            //se le suma 1 al contador de la pregunta
            Npregunta = Npregunta +1;
            //Se setean los texto para la siguiente Pregunta
            txtNpregunta.setText("pregunta 4");
            txtPregunta.setText("Esta es la pregunto 4 , su respuesta correcta es la opcion 1");
            rdBtnOpc1.setText("Opcion 1 p4");
            rdBtnOpc2.setText("Opcion 2 p4");

            //se limpian los radio buttons par ala Siguiente Pregunta
            rdBtnOpc1.setChecked(false);
            rdBtnOpc2.setChecked(false);
        }else  if (Npregunta == 5){
            //se verifica la respuesta, si es correcta se agrega 2 puntos a la nota
            if (rdBtnOpc2.isChecked()){
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
            rdBtnOpc1.setVisibility(View.GONE);
            rdBtnOpc2.setVisibility(View.GONE);
            button_siguente.setVisibility(View.GONE);
        }
    }
    public void Salir(View v){

        finish();
    }
}