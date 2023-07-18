/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.itGroup.mesaAyuda.controladorRest;

import com.itGroup.mesaAyuda.modelo.AreaCliente;
import com.itGroup.mesaAyuda.servicio.areaClienteServicio;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/areaCliente")
public class AreaClienteRestController {
    
    @Autowired
    areaClienteServicio areaclienteServicio;
    
    @GetMapping()
    public ResponseEntity<List<AreaCliente>> list() {
        List<AreaCliente> areaClientes=areaclienteServicio.listar();
        return ResponseEntity.ok(areaClientes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AreaCliente> get(@PathVariable String id) {
        AreaCliente areaCliente = areaclienteServicio.buscar(Integer.parseInt(id));
        return ResponseEntity.ok(areaCliente);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AreaCliente> put(@PathVariable String id, @RequestBody AreaCliente input) {
        input.setIdArea(Integer.parseInt(id));
        areaclienteServicio.guardar(input);
        return ResponseEntity.ok(input);
    }
    
    @PostMapping
    public ResponseEntity<AreaCliente> post(@RequestBody AreaCliente input) {
        AreaCliente areaClientenuevo = input;
        areaclienteServicio.guardar(areaClientenuevo);
        return ResponseEntity.ok(areaClientenuevo);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<AreaCliente> delete(@PathVariable String id) {
        AreaCliente areaClienteEliminar = areaclienteServicio.buscar(Integer.parseInt(id));
        areaclienteServicio.eliminar(areaClienteEliminar);
        return ResponseEntity.ok(areaClienteEliminar);
    }
    
}
