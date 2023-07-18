/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.itGroup.mesaAyuda.controladorRest;

import com.itGroup.mesaAyuda.modelo.Cliente;
import com.itGroup.mesaAyuda.servicio.clienteServicio;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/cliente")
public class ClienteControladorRest {
    
    @Autowired
    private clienteServicio clienteservicio;
    
    @GetMapping
    public ResponseEntity<List<Cliente>> list() {
        List<Cliente> clientes= clienteservicio.listar();
        return ResponseEntity.ok(clientes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable String id) {
        
        Cliente cliente=clienteservicio.buscar(Integer.parseInt(id));
        return ResponseEntity.ok(cliente);
    }
    
    //actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> put(@PathVariable String id, @RequestBody Cliente input) {
        input.setIdCliente(Integer.parseInt(id));
        clienteservicio.guardar(input);
        return ResponseEntity.ok(input);
    }
    
    @PostMapping
    public ResponseEntity<Cliente> post(@RequestBody Cliente input) {
        Cliente clienteNuevo = input;
        clienteservicio.guardar(clienteNuevo);
        return ResponseEntity.ok(clienteNuevo);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable String id) {
        clienteservicio.eliminar(clienteservicio.buscar(Integer.parseInt(id)));
        return ResponseEntity.ok(clienteservicio.buscar(Integer.parseInt(id)));
        
    }
    
}
