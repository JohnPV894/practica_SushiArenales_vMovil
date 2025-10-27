package com.example.act2_movil;

import android.os.Bundle;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class InicioActivity extends AppCompatActivity {

    /*
Propósito de la función: este código controla los insertos de ventana para ajustar correctamente el
diseño de la aplicación cuando los elementos de la interfaz de usuario del sistema (como la barra de estado,
la barra de navegación) están presentes. Esto garantiza que el contenido de la aplicación no se oculte detrás de
los elementos de la interfaz de usuario del sistema, como la barra de estado o la barra de navegación.*/

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
    }
    /*
   //CODIGO QUE GENERA EL IDE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //··················································

        //seleccion buttom al que le puse la id navegacion_segunda
        Button navegacion_irSegundo = findViewById(R.id.navegacion_segunda);//ID EN ACTIVITY_INICIO
        navegacion_irSegundo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View vista){
                Intent intent = new Intent(MainActivity.this, InicioActivity.class);
                startActivity(intent);
            }
        });
    }*/



}