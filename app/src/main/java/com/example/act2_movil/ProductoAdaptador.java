package com.example.act2_movil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

// 1. Clase principal renombrada a ProductoAdaptador
public class ProductoAdaptador extends RecyclerView.Adapter<ProductoAdaptador.VistaProductoHolder> {

    private List<Producto> listaProductos;
    private Context contexto;

    // 2. Constructor ajustado
    public ProductoAdaptador(List<Producto> listaProductos, Context contexto) {
        this.listaProductos = listaProductos;
        this.contexto = contexto;
    }

    @NonNull
    @Override

    public VistaProductoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(contexto)
                .inflate(R.layout.producto, parent, false);
        return new VistaProductoHolder(vista);
    }

    @Override
    // Referencia del ViewHolder corregida
    public void onBindViewHolder(@NonNull VistaProductoHolder holder, int position) {
        Producto productoActual = listaProductos.get(position);

        // Asignación de texto
        holder.textoNombre.setText(productoActual.getNombre());
        holder.textoDescripcion.setText(productoActual.getDescripcion());

        // Formateo de precio (asumiendo que precio es un int y queremos un formato €/$)
        holder.textoPrecio.setText(String.format("$%.2f", (double) productoActual.getPrecio() ));

        // Cargar la imagen con Glide
        Glide.with(contexto)
                .load(productoActual.getUrlImagen())
                // añade una imagen de error para el usuario
                .error(R.drawable.error_imagen)
                .into(holder.imagenProducto);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    // Función adicional en español para actualizar los datos
    public void actualizarListaProductos(List<Producto> nuevosProductos) {
        this.listaProductos = nuevosProductos;
        notifyDataSetChanged();
    }

    // 5. Clase ViewHolder renombrada y ajustada
    public static class VistaProductoHolder extends RecyclerView.ViewHolder {

        // Declaración de variables en español
        TextView textoNombre, textoDescripcion, textoPrecio;
        ImageView imagenProducto;

        public VistaProductoHolder(@NonNull View vistaItem) {
            super(vistaItem);

            // Definiciones (asegúrate de que estos IDs existan en item_producto.xml)
            textoNombre = vistaItem.findViewById(R.id.txtNombre);
            textoDescripcion = vistaItem.findViewById(R.id.txtDescripcion);
            textoPrecio = vistaItem.findViewById(R.id.txtPrecio);
            imagenProducto = vistaItem.findViewById(R.id.imgProducto);
        }
    }
}