package com.example.act2_movil;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.Path;

public interface ApiServicio {

    //  @Peticion es donde indico que peticion es (@GET,@POST,@PUT,@DELETE).
    // ("string") es el endpoint (ruta) específico de la API.
    // Call<List<producto>> indica que esperamos una lista de objetos Plato

    @GET("productos")
    Call<List<Producto>> obtenerProductos();
    @GET("mesas")
    Call<List<Mesa>> obtenerMesas();
    @GET("Pedido")
    Call<List<Pedido>> obtenerPedidos();



    // POST - Enviando ID como Parámetro de URL
    @POST("mesas/{id}/ocupar")
    Call<Mesa> ocuparMesaPorId(@Path("id") String id);

    @POST("mesas/{id}/liberar")
    Call<Mesa> liberarMesaPorId(@Path("id") String id);
}
