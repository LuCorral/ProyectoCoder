package com.coderhouse.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.Repository.ClienteRepository;
import com.coderhouse.models.Cliente;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente mostrarClientePorId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElse(null);
    }
}
