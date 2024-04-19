package com.coderhouse.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.coderhouse.Repository.ProductosRepository;
import com.coderhouse.models.Producto;

@Service
public class ProductoService {
	@Autowired
	public ProductosRepository productosRepository;
	
	public List<Producto> listarProductos() { 
	    return productosRepository.findAll();

	}
    @SuppressWarnings("null")
	public Producto mostrarProductoPorId(Long id) {
    	return productosRepository.findById(id).orElse(null);
    }
    @SuppressWarnings("null")
	public Producto agregarProducto(Producto producto) {
    	return productosRepository.save(producto);
    }
    @SuppressWarnings("null")
	public Producto editarProductoPorId(Long id, Producto producto) {
    	try {
    		if(productosRepository.existsById(id)){
    			producto.setId(id);
    			return productosRepository.save(producto);
    		}
    	}catch(EmptyResultDataAccessException e) {
    		return null;
    		}
    	return null;
    	
    }
    @SuppressWarnings("null")
	public boolean eliminarProductoPorId(Long id) {
    	try {
    		productosRepository.deleteById(id);
    		return true;
    	}catch(EmptyResultDataAccessException e ){//excepcion por si no le paso nada que devuelva false
    	return false;
        }
    }
}
