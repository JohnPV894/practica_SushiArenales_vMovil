package com.example.act2_movil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCliente {

    private static Retrofit retrofit = null;
    private static String localhost_en_moviles = "http://10.0.2.2:3000/";

    public static ApiServicio getApi() {
        if (retrofit == null) {
            // Inicializar Retrofit
            retrofit = new Retrofit.Builder()
                    .baseUrl(localhost_en_moviles)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiServicio.class);
    }


}
