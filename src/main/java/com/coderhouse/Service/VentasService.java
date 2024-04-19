package com.coderhouse.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.Repository.VentasRepository;
import com.coderhouse.models.Ventas;

@Service
public class VentasService {
	@Autowired VentasRepository ventasRepository;
	
	public List<Ventas> listarVentas(){
		return ventasRepository.findAll();
	}


}
