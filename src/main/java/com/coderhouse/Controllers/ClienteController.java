//lo importante en el controller es que se comunique bien con el service y que devuelva alguno status


package com.coderhouse.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.coderhouse.Service.ClienteService;
import com.coderhouse.models.Cliente;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired // para ver o usar todos los metodos
	private ClienteService clienteService;
	
	@GetMapping(value="/", produces= {MediaType.APPLICATION_JSON_VALUE})// que queres o en donde queres acceder
    public ResponseEntity<List<Cliente>> listarClientes(){
		try {
			List<Cliente> clientes=clienteService.listarClientes();
			return new ResponseEntity<>(clientes,HttpStatus.OK);// codigo200
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//Error 500
		}
	}
	
	
	public ResponseEntity<Cliente> mostrarClientePorId(@PathVariable("id") Long id) {
		try {
			Cliente cliente = clienteService.mostrarClientePorId(id);
			if (cliente != null) {
				return new ResponseEntity<>(cliente, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND); // Codigo 404
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}	

	
}
