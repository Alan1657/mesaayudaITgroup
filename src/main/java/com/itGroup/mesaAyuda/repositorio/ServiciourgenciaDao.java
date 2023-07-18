/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.itGroup.mesaAyuda.repositorio;

import com.itGroup.mesaAyuda.modelo.AreaCliente;
import com.itGroup.mesaAyuda.modelo.CategoriaTicket;
import com.itGroup.mesaAyuda.modelo.Serviciourgencia;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiciourgenciaDao extends JpaRepository<Serviciourgencia, Integer> {
    
   Serviciourgencia findByIdAreaAndIdCategoriaTicket(AreaCliente areaCliente,CategoriaTicket categoriaTicket); 
    
}
