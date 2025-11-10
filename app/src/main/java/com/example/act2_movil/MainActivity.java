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

public class MainActivity extends AppCompatActivity {
    //CODIGO QUE GENERA EL IDE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.inicio), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //·················································· FIN IDE CODIGO

        //seleccion buttom/imagebutton al que le puse la id navegacion_segunda
        ImageButton navegacion_irSegundo = findViewById(R.id.navegacion_segunda);//ID EN ACTIVITY_INICIO
        navegacion_irSegundo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View vista){
                Intent intent = new Intent(MainActivity.this, InicioActivity.class);//De donde vengo y hacia donde voy
                startActivity(intent);
            }
        });
    }
}
