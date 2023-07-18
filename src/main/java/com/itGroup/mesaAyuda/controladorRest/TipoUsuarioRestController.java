/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.itGroup.mesaAyuda.controladorRest;

import com.itGroup.mesaAyuda.modelo.TipoUsuario;
import com.itGroup.mesaAyuda.servicio.tipoUsuarioServicio;
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
@RequestMapping("/tipoUsuario")
public class TipoUsuarioRestController {
    
    @Autowired
    tipoUsuarioServicio tipousuarioServicio;
    
    @GetMapping()
    public ResponseEntity<List<TipoUsuario>> list() {
        List<TipoUsuario> tipoUsuarios=tipousuarioServicio.listar();
        return ResponseEntity.ok(tipoUsuarios);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> get(@PathVariable String id) {
        TipoUsuario tipousuario=tipousuarioServicio.buscar(Integer.parseInt(id));
        return ResponseEntity.ok(tipousuario);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> put(@PathVariable String id, @RequestBody TipoUsuario input) {
        input.setIdTipoUs(Integer.parseInt(id));
        tipousuarioServicio.guardar(input);
        return ResponseEntity.ok(input);
    }
    
    @PostMapping
    public ResponseEntity<TipoUsuario> post(@RequestBody TipoUsuario input) {
       TipoUsuario nuevotipousuario=input;
       tipousuarioServicio.guardar(nuevotipousuario);
       return ResponseEntity.ok(nuevotipousuario);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<TipoUsuario> delete(@PathVariable String id) {
       TipoUsuario tipoUsuarioEliminar = tipousuarioServicio.buscar(Integer.parseInt(id));
        tipousuarioServicio.eliminar(tipoUsuarioEliminar);
        return ResponseEntity.ok(tipoUsuarioEliminar);
    }
    
}
