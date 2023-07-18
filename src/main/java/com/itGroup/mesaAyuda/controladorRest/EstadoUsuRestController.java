/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.itGroup.mesaAyuda.controladorRest;

import com.itGroup.mesaAyuda.modelo.EstadoUsu;
import com.itGroup.mesaAyuda.servicio.estadoUsuServicio;
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
@RequestMapping("/estadoUsuario")
public class EstadoUsuRestController {
    
    @Autowired
    estadoUsuServicio estadousuServicio;
    
    @GetMapping()
    public ResponseEntity<List<EstadoUsu>> list() {
        List<EstadoUsu> estados=estadousuServicio.listar();
        return ResponseEntity.ok(estados);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EstadoUsu> get(@PathVariable String id) {
        EstadoUsu estado=estadousuServicio.buscar(Integer.parseInt(id));
        return ResponseEntity.ok(estado);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EstadoUsu> put(@PathVariable String id, @RequestBody EstadoUsu input) {
        input.setIdEstadoUsu(Integer.parseInt(id));
        estadousuServicio.guardar(input);
        return ResponseEntity.ok(input);
    }
    
    @PostMapping
    public ResponseEntity<EstadoUsu> post(@RequestBody EstadoUsu input) {
        EstadoUsu estadoNuevo=input;
        estadousuServicio.guardar(estadoNuevo);
        return ResponseEntity.ok(estadoNuevo);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<EstadoUsu> delete(@PathVariable String id) {
        EstadoUsu estadoEliminar=estadousuServicio.buscar(Integer.parseInt(id));
        estadousuServicio.eliminar(estadoEliminar);
        return ResponseEntity.ok(estadoEliminar);
    }
    
}
