/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.itGroup.mesaAyuda.repositorio;

import com.itGroup.mesaAyuda.modelo.CategoriaTicket;
import com.itGroup.mesaAyuda.modelo.Servicioderivacion;
import com.itGroup.mesaAyuda.modelo.UrgenciaTicket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServicioderivacionDao extends JpaRepository<Servicioderivacion, Integer> {
    
    Servicioderivacion findByIdUrgenciaTicketAndIdCategoriaTicket(UrgenciaTicket urgencia,CategoriaTicket categoriaTicket);
}
