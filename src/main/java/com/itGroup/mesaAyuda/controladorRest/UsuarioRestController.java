/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.itGroup.mesaAyuda.controladorRest;

import com.itGroup.mesaAyuda.modelo.Usuario;
import com.itGroup.mesaAyuda.servicio.usuarioServicio;
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
@RequestMapping("/usuario")
public class UsuarioRestController {
    
    @Autowired
    usuarioServicio usuarioservicio;
    
    @GetMapping()
    public ResponseEntity<List<Usuario>> list() {
        List<Usuario> usuarios=usuarioservicio.listar();
        return ResponseEntity.ok(usuarios);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> get(@PathVariable String id) {
        Usuario usuario = usuarioservicio.buscar(Integer.parseInt(id));
        return ResponseEntity.ok(usuario);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> put(@PathVariable String id, @RequestBody Usuario input) {
        input.setIdUsuario(Integer.parseInt(id));
        usuarioservicio.guardar(input);
        return ResponseEntity.ok(input);
    }
    
    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody Usuario input) {
        Usuario usuarioNuevo = input;
        usuarioservicio.guardar(usuarioNuevo);
        return ResponseEntity.ok(usuarioNuevo);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable String id) {
        Usuario usuarioEliminar=usuarioservicio.buscar(Integer.parseInt(id));
        usuarioservicio.eliminar(usuarioEliminar);
        return ResponseEntity.ok(usuarioEliminar);
    }
    
    @GetMapping("/username/{username}")
    public ResponseEntity<Usuario> getByUsername(@PathVariable String username) {
        Usuario usuario = usuarioservicio.buscarPorNombreUsuario(username);
        return ResponseEntity.ok(usuario);
    }
    
}
