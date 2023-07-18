/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.itGroup.mesaAyuda.controladorRest;

import com.itGroup.mesaAyuda.modelo.Servicioderivacion;
import com.itGroup.mesaAyuda.modelo.TipoUsuario;
import com.itGroup.mesaAyuda.servicio.servicioderivacionServicio;
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
@RequestMapping("/servicioderivacion")
public class ServicioderivacionRestController {
    
    @Autowired
    servicioderivacionServicio servicioderivacionServicio;
    
    @GetMapping()
    public ResponseEntity<List<Servicioderivacion>> list() {
        List<Servicioderivacion> servicios=servicioderivacionServicio.listar();
        return ResponseEntity.ok(servicios);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Servicioderivacion> get(@PathVariable String id) {
        Servicioderivacion servicio=servicioderivacionServicio.buscar(Integer.parseInt(id));
        return ResponseEntity.ok(servicio);
    }
    
    @GetMapping("/{idCategoriaTicket}/{idUrgencia}")
    public ResponseEntity<TipoUsuario> getTipoUsuario(@PathVariable String idCategoriaTicket,@PathVariable String idUrgencia) {
        Servicioderivacion servicio=servicioderivacionServicio.buscarIdUsuarioAndIdCategoria(Integer.parseInt(idUrgencia),Integer.parseInt(idCategoriaTicket));
        TipoUsuario tipoUsuario=servicio.getIdTipoUsuario();
        return ResponseEntity.ok(tipoUsuario);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Servicioderivacion> put(@PathVariable String id, @RequestBody Servicioderivacion input) {
        input.setId(Integer.parseInt(id));
        servicioderivacionServicio.guardar(input);
        return ResponseEntity.ok(input);
    }
    
    @PostMapping
    public ResponseEntity<Servicioderivacion> post(@RequestBody Servicioderivacion input) {
        Servicioderivacion servicionuevo=input;
        servicioderivacionServicio.guardar(servicionuevo);
        return ResponseEntity.ok(servicionuevo);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Servicioderivacion> delete(@PathVariable String id) {
         Servicioderivacion servicioEliminar=servicioderivacionServicio.buscar(Integer.parseInt(id));
        servicioderivacionServicio.eliminar(servicioEliminar);
        return ResponseEntity.ok(servicioEliminar);
    }
    
}
