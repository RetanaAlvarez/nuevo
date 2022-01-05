package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class encuesta extends AppCompatActivity {
    //Se declaran los objetos para usarlos
    RadioButton rdOpc2,rdOpc1;
    TextView txtNpregunta, txtPregunta;
    Button  btnSiguiente,btnSalir;
    //se declara las vairables para modificar la pregunta y las  opciones , y para calcular la puntuacion
    int nota = 0;int Npregunta = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        //Se le asigna a cada objeto el id de los que va a usar
        rdOpc1 = (RadioButton) findViewById(R.id.rdBtnOpc1);
        rdOpc2 = (RadioButton) findViewById(R.id.rdBtnOpc2);

        txtNpregunta = (TextView) findViewById(R.id.txtNpregunta);
        txtPregunta = (TextView) findViewById(R.id.txtPregunta);

        btnSiguiente = (Button) findViewById(R.id.button_siguente);
        btnSalir = (Button) findViewById(R.id.button_salir);

    }
    public void Siguiente(View v){
        //if por si no se marca ninguna opcion
        if(rdOpc1.isChecked() == false && rdOpc2.isChecked() == false ){
            Toast.makeText(this, "Elija una opción", Toast.LENGTH_SHORT).show();
        }else if(Npregunta == 1){
            if(rdOpc2.isChecked()){
                nota = nota + 2;
            }else{
                nota = nota + 0;
            }
            //Se le suma 1 al contador de la pregunta
            Npregunta = Npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            txtNpregunta.setText("Pregunta 2");
            txtPregunta.setText("¿Presentas sintomas de fiebre?");
            rdOpc1.setText("SÍ");
            rdOpc2.setText("NO");
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota

            //Se limpian los Radio buttons para la siguiente pregunta
            rdOpc1.setChecked(false);
            rdOpc2.setChecked(false);
        }else if(Npregunta == 2) {
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (rdOpc2.isChecked()) {
                nota = nota + 2;
            }else{
                nota = nota + 0;
            }
            //Se le suma 1 al contador de la pregunta
            Npregunta = Npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            txtNpregunta.setText("Pregunta 3");
            txtPregunta.setText("¿Presentas sintomas de cansancio?");
            rdOpc1.setText("SÍ");
            rdOpc2.setText("NO");
            //Se limpian los Radio buttons para la siguiente pregunta
            rdOpc1.setChecked(false);
            rdOpc2.setChecked(false);
        }else if(Npregunta == 3) {
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (rdOpc2.isChecked()) {
                nota = nota + 2;
            }else {
                nota = nota + 0;
            }
            //Se le suma 1 al contador de la pregunta
            Npregunta = Npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            txtNpregunta.setText("Pregunta 4");
            txtPregunta.setText("¿Presentas sintomas de cansancio Pérdida del gusto o del olfato?");
            rdOpc1.setText("SÍ");
            rdOpc2.setText("NO");
            //Se limpian los Radio buttons para la siguiente pregunta
            rdOpc1.setChecked(false);
            rdOpc2.setChecked(false);
        }else if(Npregunta == 4) {
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (rdOpc2.isChecked()) {
                nota = nota + 2;
            } else  {
                nota = nota + 0;
            }
            //Se le suma 1 al contador de la pregunta
            Npregunta = Npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            txtNpregunta.setText("Pregunta 5");
            txtPregunta.setText("¿Presentas con dolor de cabeza?");
            rdOpc1.setText("SÍ");
            rdOpc2.setText("NO");
            //Se limpian los Radio buttons para la siguiente pregunta
            rdOpc1.setChecked(false);
            rdOpc2.setChecked(false);
        }else if(nota ==7 || nota ==5 || nota ==6) {

            txtNpregunta.setText("Nota obtenida: " + nota);
            txtPregunta.setText("Estado: Preventivo. ¡Deberias cuidate o checar un doctor!");
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota

            //Se le suma 1 al contador de la pregunta
            Npregunta = Npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (rdOpc1.isChecked()) {
                nota = nota + 2;
            } else{
                nota = nota + 0;
            }
            txtNpregunta.setText("Pregunta 6");
            txtPregunta.setText("¿Has realizado una prueba de covid? (si los has hecho y saliste negativo dar 'si' en lo contrario 'no'");
            rdOpc1.setText("SÍ");
            rdOpc2.setText("NO");
            //Se limpian los Radio buttons para la siguiente pregunta
            rdOpc1.setChecked(false);
            rdOpc2.setChecked(false);

        }else{
            //Se setean los textos para el resultado de la nota
            if (rdOpc2.isChecked()) {
                nota = nota + 2;
            } else{
                nota = nota + 0;
            }
            Npregunta = Npregunta + 1;
            txtNpregunta.setText("Nota obtenida: "+nota);
            //IF para verificar si se ha aprobado o reprobado
            if(nota >=8) {
                txtPregunta.setText("Estado: ¡Estas En buenas Condiciones!");
            }else if(nota <=4){
                txtPregunta.setText("Estado: ¡Precautivo.! ¡No debes asistir al colegio!");
            }
            //Se ocultan las opciones que no se van a usar para ver la nota y resultado
            rdOpc1.setVisibility(View.GONE);
            rdOpc2.setVisibility(View.GONE);
            btnSiguiente.setVisibility(View.GONE);
        }
    }
    public void Salir(View v){
        finish();
    }
}