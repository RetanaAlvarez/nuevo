package com.example.nuevo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class perfil extends AppCompatActivity {

    //set y get
    User login = new User();
    //variables y declariones que se van usar
    public Button button, buttonnsultar;
    public static final String uss = "nombre", numero = "numerodecontrol",apep = "apellidoP", apem = "apellidoM", edad = "edad", tel = "telefono",correo = "email", pwd = "pwd", no_de_seguro = "no_de_seguro", ID_privilegios = "ID_privilegios";
    TextView cajatextnombre, cajanumero, cajaapellp, cajaapellM, cajacorreo, cajapwd, cajaedad, cajatel, cajaseguro;

    Button btnCamara;
    ImageView Imaperfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfi);

        btnCamara = findViewById(R.id.btncamara);
        Imaperfil = findViewById(R.id.Imaperfil);
        buttonnsultar = (Button) findViewById(R.id.buttonnsultar);
        cajatextnombre = (TextView) findViewById(R.id.textnombre);
        cajanumero = (TextView) findViewById(R.id.textnumero);
        cajaapellp = (TextView) findViewById(R.id.textapellp);
        cajaapellM = (TextView) findViewById(R.id.textapellM);
        cajacorreo = (TextView) findViewById(R.id.textCorreo);
        cajapwd = (TextView) findViewById(R.id.textcontraseña);
        cajaedad = (TextView) findViewById(R.id.textedad);
        cajatel = (TextView) findViewById(R.id.textel);
        cajaseguro = (TextView) findViewById(R.id.no_de_seguro);
        /*
        buttonnsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {*/
                cajanumero.setText("numero de control: " + getIntent().getStringExtra("numerodecontrol"));
                cajatextnombre.setText("Nombre :" + getIntent().getStringExtra("nombre"));
                cajaapellp.setText("apellido P: " + getIntent().getStringExtra("apellidoP"));
                cajaapellM.setText("apellido M: " + getIntent().getStringExtra("apellidoM"));
                cajacorreo.setText("email: " + getIntent().getStringExtra("email"));
                cajapwd.setText("pwd: " + getIntent().getStringExtra("pwd"));
                cajaedad.setText("edad: " + getIntent().getStringExtra("edad"));
                cajatel.setText("telefono: " + getIntent().getStringExtra("telefono"));
                cajaseguro.setText("no de seguro: " + getIntent().getStringExtra("no_de_seguro"));
          /*  }
        });*/

        btnCamara.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                abrirCamara();
            }
        });

    }

    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent,1) ;
        }
    }
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 & resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            Imaperfil.setImageBitmap(imgBitmap);
        }
    }
        public void salir (View v){
            finish();
        }
}