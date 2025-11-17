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
    public void onBindViewHolder(@NonNull VistaProductoHolder holder, int position) {
        Producto productoActual = listaProductos.get(position);

        holder.textoNombre.setText(productoActual.getNombre());
        holder.textoDescripcion.setText(productoActual.getDescripcion());

        holder.textoPrecio.setText(String.format("$%.2f", (double) productoActual.getPrecio() ));

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

    public void actualizarListaProductos(List<Producto> nuevosProductos) {
        this.listaProductos = nuevosProductos;
        notifyDataSetChanged();
    }

    public static class VistaProductoHolder extends RecyclerView.ViewHolder {

        TextView textoNombre, textoDescripcion, textoPrecio;
        ImageView imagenProducto;

        public VistaProductoHolder(@NonNull View vistaItem) {
            super(vistaItem);

            textoNombre = vistaItem.findViewById(R.id.txtNombre);
            textoDescripcion = vistaItem.findViewById(R.id.txtDescripcion);
            textoPrecio = vistaItem.findViewById(R.id.txtPrecio);
            imagenProducto = vistaItem.findViewById(R.id.imgProducto);
        }
    }
}