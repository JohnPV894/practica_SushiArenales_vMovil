package com.example.act2_movil;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle salvadaInstanciasEstado){
        super.onCreate(salvadaInstanciasEstado);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_platos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.platos),(vista,insets)->{
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }   
}
