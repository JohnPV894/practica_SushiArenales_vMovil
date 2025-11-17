package com.example.act2_movil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//Http

import java.net.*;
import java.io.*;

public class InicioActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle salvadaInstanciaEstado){
        super.onCreate(salvadaInstanciaEstado);// constructor de una clase que hereda de appcompatactivity
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mesas);//Entiendo que busca en Res/recursos dentro de layout el xml
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),(vista, insets) -> {/*Recuadro, inserido, recuadro*/
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    /*
ajusta la ventana para que no se oculte detras de los insets como la barra de estado o noticaciones.*/

        //Boton para volver al inicio
        ImageButton btn_volver_inicio = findViewById(R.id.volver_inicio);
        btn_volver_inicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View vista){
                Intent intent = new Intent(InicioActivity.this, MainActivity.class);//De donde vengo y hacia donde voy
                startActivity(intent);
            }
        });

        //Botones para seleccionar mesa
        ImageButton boton_mesa1 = findViewById(R.id.mesa1);
        ImageButton boton_mesa2 = findViewById(R.id.mesa2);
        ImageButton boton_mesa3 = findViewById(R.id.mesa3);
        ImageButton boton_mesa4 = findViewById(R.id.mesa4);

        //Crear funcion para ejecutar una peticion POST y que acepte como parametro un numero (id de mesa)
        boton_mesa1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View vista){
                //Logica para hacer la peticion POST

                //FIN
                Intent intent = new Intent(InicioActivity.this, PlatosActivity.class);//De donde vengo y hacia donde voy
                startActivity(intent);
            }
        });


    }
}