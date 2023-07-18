/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.itGroup.mesaAyuda.controladorRest;

import com.itGroup.mesaAyuda.modelo.EstadoTicket;
import com.itGroup.mesaAyuda.servicio.estadoTicketServicio;
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
@RequestMapping("/estadoTicket")
public class EstadoTicketRestController {
    
    @Autowired
    estadoTicketServicio estadoticketServicio;
    
    @GetMapping()
    public ResponseEntity<List<EstadoTicket>> list() {
        List<EstadoTicket> estados = estadoticketServicio.listar();
        return ResponseEntity.ok(estados);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EstadoTicket> get(@PathVariable String id) {
        EstadoTicket estado=estadoticketServicio.buscar(Integer.parseInt(id));
        return ResponseEntity.ok(estado);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EstadoTicket> put(@PathVariable String id, @RequestBody EstadoTicket input) {
        input.setIdEstado(Integer.parseInt(id));
        estadoticketServicio.guardar(input);
        return ResponseEntity.ok(input);
    }
    
    @PostMapping
    public ResponseEntity<EstadoTicket> post(@RequestBody EstadoTicket input) {
        EstadoTicket estadoNuevo=input;
        estadoticketServicio.guardar(estadoNuevo);
        return ResponseEntity.ok(estadoNuevo);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<EstadoTicket> delete(@PathVariable String id) {
        EstadoTicket estadoEliminar=estadoticketServicio.buscar(Integer.parseInt(id));
        estadoticketServicio.eliminar(estadoEliminar);
        return ResponseEntity.ok(estadoEliminar);
    }
    
}
