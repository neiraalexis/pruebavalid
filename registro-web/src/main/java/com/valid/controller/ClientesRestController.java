package com.valid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valid.model.Cliente;
import com.valid.service.ClientService;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author neira
 */
@RestController
public class ClientesRestController {

    @Autowired
    private ClientService serviceClient;

    /**
     *
     * @return All clients
     */
    @GetMapping("/clientes")
    public List getClients() {
        return serviceClient.findAll();
    }

    /**
     * Find a client by id
     * @param id the id client
     * @return the Client in wrapped protocol
     */
    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity getCliente(@PathVariable("clienteId") Integer id) {

        Cliente cliente = serviceClient.findById(id);
        if (cliente == null) {
            return new ResponseEntity("Cliente no encontrado " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    /**
     * Creates a client in database
     * @param cliente
     * @return The new  Client in wrapped protocol
     */
    @PostMapping(value = "/clientes")
    public ResponseEntity create(@RequestBody Cliente cliente) {
        cliente.setId(serviceClient.create(cliente));
        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    /**
     * Process the clients based in list id
     * @param ids The list of id´s clients
     * @return
     */
    @PutMapping(value = "/clientes/procesar")
    public ResponseEntity procesar(@RequestBody List<Integer> ids) {
        serviceClient.processBatch(ids);
        return new ResponseEntity(ids, HttpStatus.OK);
    }

}
