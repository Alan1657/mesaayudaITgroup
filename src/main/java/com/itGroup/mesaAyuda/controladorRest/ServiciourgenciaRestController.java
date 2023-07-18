/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.itGroup.mesaAyuda.controladorRest;

import com.itGroup.mesaAyuda.modelo.Serviciourgencia;
import com.itGroup.mesaAyuda.modelo.UrgenciaTicket;
import com.itGroup.mesaAyuda.servicio.serviciourgenciaServicio;
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
@RequestMapping("/serviciourgencia")
public class ServiciourgenciaRestController {

    @Autowired
    serviciourgenciaServicio serviciourgenciaservicio;

    @GetMapping()
    public ResponseEntity<List<Serviciourgencia>> list() {
        List<Serviciourgencia> servicios = serviciourgenciaservicio.listar();
        return ResponseEntity.ok(servicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serviciourgencia> get(@PathVariable String id) {
        Serviciourgencia servicio = serviciourgenciaservicio.buscar(Integer.parseInt(id));
        return ResponseEntity.ok(servicio);
    }
    
    @GetMapping("/{idUsuario}/{idCategoria}")
    public ResponseEntity<UrgenciaTicket> getUrgencia(@PathVariable String idUsuario,@PathVariable String idCategoria) {
        Serviciourgencia servicio = serviciourgenciaservicio.buscarIdUsuarioAndIdCategoria(Integer.parseInt(idUsuario),Integer.parseInt(idCategoria));
        UrgenciaTicket urgencia = servicio.getIdUrgenciaTicket();
        return ResponseEntity.ok(urgencia);
          }

    @PutMapping("/{id}")
    public ResponseEntity<Serviciourgencia> put(@PathVariable String id, @RequestBody Serviciourgencia input) {
        input.setIdServicioUrgencia(Integer.parseInt(id));
        serviciourgenciaservicio.guardar(input);
        return ResponseEntity.ok(input);
    }

    @PostMapping
    public ResponseEntity<Serviciourgencia> post(@RequestBody Serviciourgencia input) {
        Serviciourgencia servicionuevo = input;
        serviciourgenciaservicio.guardar(servicionuevo);
        return ResponseEntity.ok(servicionuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Serviciourgencia> delete(@PathVariable String id) {
        Serviciourgencia servicioeliminado=serviciourgenciaservicio.buscar(Integer.parseInt(id));
        serviciourgenciaservicio.eliminar(servicioeliminado);
        return ResponseEntity.ok(servicioeliminado);
    }

}
