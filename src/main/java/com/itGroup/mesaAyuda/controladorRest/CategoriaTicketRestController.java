/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.itGroup.mesaAyuda.controladorRest;

import com.itGroup.mesaAyuda.modelo.CategoriaTicket;
import com.itGroup.mesaAyuda.servicio.categoriaTicketServicio;
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
@RequestMapping("/categoriaTicket")
public class CategoriaTicketRestController {
    
    @Autowired
    categoriaTicketServicio categoriaticketServicio;
    
    @GetMapping()
    public ResponseEntity<List<CategoriaTicket>> list() {
        List<CategoriaTicket> categorias=categoriaticketServicio.listar();
        return ResponseEntity.ok(categorias);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaTicket> get(@PathVariable String id) {
        CategoriaTicket categoria=categoriaticketServicio.buscar(Integer.parseInt(id));
        return ResponseEntity.ok(categoria);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaTicket> put(@PathVariable String id, @RequestBody CategoriaTicket input) {
        input.setIdCategoria(Integer.parseInt(id));
        categoriaticketServicio.guardar(input);
        return ResponseEntity.ok(input);
    }
    
    @PostMapping
    public ResponseEntity<CategoriaTicket> post(@RequestBody CategoriaTicket input) {
        CategoriaTicket categorianueva=input;
        categoriaticketServicio.guardar(categorianueva);
        return ResponseEntity.ok(categorianueva);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaTicket> delete(@PathVariable String id) {
        CategoriaTicket categoriaEliminar=categoriaticketServicio.buscar(Integer.parseInt(id));
        categoriaticketServicio.eliminar(categoriaEliminar);
        return  ResponseEntity.ok(categoriaEliminar);
    }
    
}
