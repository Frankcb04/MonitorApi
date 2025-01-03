package com.api.monitor.service;

import com.api.monitor.model.Producto;
import com.api.monitor.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    //Listar todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    //Listar producto por ID
    public Producto getProductoById(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElse(null);
    }

    //Crear un producto
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    //Actualizar un producto por ID
    public Producto updateProducto(Long id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setId(id);
            return productoRepository.save(producto);
        }
        return null;
    }

    //Eliminar un producto por ID
    public boolean deleteProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
