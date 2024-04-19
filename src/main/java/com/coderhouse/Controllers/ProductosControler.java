package com.coderhouse.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.Service.ProductoService;
import com.coderhouse.models.Producto;

@RestController
@RequestMapping("/productos")
public class ProductosControler {
	@Autowired ProductoService productoService;
	
	@GetMapping(value="/", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Producto>> listarProductos(){
		try {
			List<Producto> producto = productoService.listarProductos();
			return new ResponseEntity<>(producto, HttpStatus.OK); // Codigo 200

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
	}
	
	@PostMapping(value = "/agregar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> agregarProducto(@RequestBody Producto nuevoProducto) {
		Producto cursoGuardado = productoService.agregarProducto(nuevoProducto);
		return new ResponseEntity<>(cursoGuardado, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}/eliminar")
	public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Long id) {
		boolean eliminado = productoService.eliminarProductoPorId(id);
		if (eliminado) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Codigo 204
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Producto> mostrarProductoPorId(@PathVariable("id") Long id) {
		try {
		 Producto producto = productoService.mostrarProductoPorId(id);
			if (producto != null) {
				return new ResponseEntity<>(producto, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(producto, HttpStatus.NOT_FOUND); // Codigo 404
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}
	
	@PutMapping(value = "/{id}/editar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Producto> editarProducto(@PathVariable("id") Long id, @RequestBody Producto producto) {
		Producto productoEditado = productoService.editarProductoPorId(id, producto);
		if (productoEditado != null) {
			return new ResponseEntity<>(productoEditado, HttpStatus.OK); // Codigo 200
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}
	}
	
	

}
