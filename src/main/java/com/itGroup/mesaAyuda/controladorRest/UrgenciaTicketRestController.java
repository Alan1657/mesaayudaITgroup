/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.itGroup.mesaAyuda.controladorRest;

import com.itGroup.mesaAyuda.modelo.UrgenciaTicket;
import com.itGroup.mesaAyuda.servicio.urgenciaTicketServicio;
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
@RequestMapping("/urgenciaTicket")
public class UrgenciaTicketRestController {
    
    
    @Autowired
    urgenciaTicketServicio urgenciaticketServicio;
    
    @GetMapping()
    public ResponseEntity<List<UrgenciaTicket>> list() {
        List<UrgenciaTicket> listUrgencia=urgenciaticketServicio.listar();
        return ResponseEntity.ok(listUrgencia);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UrgenciaTicket> get(@PathVariable String id) {
        UrgenciaTicket urgencia=urgenciaticketServicio.buscar(Integer.parseInt(id));
        return ResponseEntity.ok(urgencia);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UrgenciaTicket> put(@PathVariable String id, @RequestBody UrgenciaTicket input) {
        input.setIdUrgencia(Integer.parseInt(id));
        urgenciaticketServicio.guardar(input);
        return ResponseEntity.ok(input);
    }
    
    @PostMapping
    public ResponseEntity<UrgenciaTicket> post(@RequestBody UrgenciaTicket input) {
        UrgenciaTicket urgenciaNuevo=input;
        urgenciaticketServicio.guardar(urgenciaNuevo);
        return ResponseEntity.ok(urgenciaNuevo);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<UrgenciaTicket> delete(@PathVariable String id) {
        UrgenciaTicket urgenciaEliminar=urgenciaticketServicio.buscar(Integer.parseInt(id));
        urgenciaticketServicio.eliminar(urgenciaEliminar);
        return ResponseEntity.ok(urgenciaEliminar);
    }
    
}
