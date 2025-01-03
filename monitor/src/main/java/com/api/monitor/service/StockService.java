package com.api.monitor.service;

import com.api.monitor.model.Producto;
import com.api.monitor.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private ProductoRepository productoRepository;

    // Este método se ejecutará cada 5 minutos, actualizando la disponibilidad del producto
    @Scheduled(fixedRate = 300000)
    public void revisarStock() {
        List<Producto> productos = productoRepository.findAll();
        
        for (Producto producto : productos) {
            if (producto.getStock() < producto.getUmbral()) {
                alertar(producto);
            }
        }
    }

    private void alertar(Producto producto) {
        // Simulación de una alerta por consola
        System.out.println("ALERTA: El stock del producto '" + producto.getNombre() + "' está por debajo del umbral. Stock actual: " 
                            + producto.getStock() + ", Umbral: " + producto.getUmbral());
    }
}
