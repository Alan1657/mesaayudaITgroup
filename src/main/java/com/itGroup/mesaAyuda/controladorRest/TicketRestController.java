/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.itGroup.mesaAyuda.controladorRest;

import com.itGroup.mesaAyuda.modelo.Ticket;
import com.itGroup.mesaAyuda.servicio.ticketServicio;
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

/**
 *
 * @author AlanHuerta
 */
@RestController
@RequestMapping("/ticket")
public class TicketRestController {
    
    @Autowired
    ticketServicio ticketservicio;
    
    @GetMapping()
    public ResponseEntity<List<Ticket>> list() {
        List<Ticket> tickets=ticketservicio.listar();
        return ResponseEntity.ok(tickets);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> get(@PathVariable String id) {
        Ticket ticket = ticketservicio.buscar(Integer.parseInt(id));
        return ResponseEntity.ok(ticket);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> put(@PathVariable String id, @RequestBody Ticket input) {
        input.setIdTicket(Integer.parseInt(id));
        ticketservicio.guardar(input);
        return ResponseEntity.ok(input);
    }
    
    @PostMapping
    public ResponseEntity<Ticket> post(@RequestBody Ticket input) {
        Ticket ticketNuevo=input;
        ticketservicio.guardar(ticketNuevo);
        return ResponseEntity.ok(ticketNuevo);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Ticket> delete(@PathVariable String id) {
        Ticket ticketEliminar=ticketservicio.buscar(Integer.parseInt(id));
        ticketservicio.eliminar(ticketEliminar);
        return ResponseEntity.ok(ticketEliminar);
    }
    
}
