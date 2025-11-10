package com.example.act2_movil;

import android.os.Bundle;
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
        super.onCreate(salvadaInstanciaEstado);// constructo de una clase que hereda de appcompatactivity
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mesas);//Entiedo que busca en Res/recursos dentro de layout el xml
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),(vista, insets) -> {/*Recuadro, inserido, recuadro*/
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    /*
ajusta la ventana para que no se oculte detras de los insets como la barra de estado o noticaciones.*/

        //Botones para seleccionar mesa
        ImageButton boton_mesa1 = findViewById(R.id.mesa1);
        ImageButton boton_mesa2 = findViewById(R.id.mesa2);
        ImageButton boton_mesa3 = findViewById(R.id.mesa3);
        ImageButton boton_mesa4 = findViewById(R.id.mesa4);

        //Crear funcion para ejecutar una peticion POST y que acepte como parametro un numero (id de mesa)



    }
}