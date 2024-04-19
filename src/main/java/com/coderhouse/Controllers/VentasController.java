package com.coderhouse.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.Service.VentasService;
import com.coderhouse.models.Ventas;

@RestController
@RequestMapping("/ventas")
public class VentasController {
	@Autowired
	public VentasService ventasService;
	
	@GetMapping(value="/", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Ventas>> listarVentas(){
		try {
			List<Ventas>ventas =ventasService.listarVentas();
			return new ResponseEntity<>(ventas, HttpStatus.OK); //ccodigo 200
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//errorr 500
			}
	}
	
	

}
