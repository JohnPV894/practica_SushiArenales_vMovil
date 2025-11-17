package com.example.act2_movil;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlatosActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProductos;

    // Este es el que maneja la lista de platos en la pantalla
    private ProductoAdaptador productoAdaptador;
    // Y este es el "mensajero" que habla con el servidor
    private ApiServicio apiServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_platos);

        // 1. Configuración de Insets (lo que toca hacer con el EdgeToEdge para que no se pegue a los bordes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.platos), (vista, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            vista.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2. Aquí es donde inicializamos todo
        // Conseguimos la instancia de nuestro cliente Retrofit
        apiServicio = ApiCliente.getApi();
        // Llamamos a la función que arma la lista
        armarListaDePlatos();

        // 3. ¡A cargar los datos!
        cargarProductosDesdeApi();
    }

    /**
     * Lo armamos con calma: agarramos el RecyclerView y le metemos el Adaptador.
     */
    private void armarListaDePlatos() {
        recyclerViewProductos = findViewById(R.id.recycler_productos);

        productoAdaptador = new ProductoAdaptador(new ArrayList<>(), this);

        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProductos.setAdapter(productoAdaptador);
    }

    //Pedimos los platos al servidor.

    private void cargarProductosDesdeApi() {
        Call<List<Producto>> llamada = apiServicio.obtenerProductos();

        llamada.enqueue(new Callback<List<Producto>>() {

            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                if (response.isSuccessful() && response.body() != null) {

                    List<Producto> productos = response.body();

                    productoAdaptador.actualizarListaProductos(productos);

                    Log.d("PlatosActivity",
                            "Productos cargados: " + productos.size());
                }
                else {
                    Log.e("PlatosActivity", "Error de servidor: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.e("PlatosActivity", "ERROR CONEXIÓN: " + t.getMessage());
            }
        });
    }
}