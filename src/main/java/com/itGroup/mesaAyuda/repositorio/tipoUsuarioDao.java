/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.itGroup.mesaAyuda.repositorio;

import com.itGroup.mesaAyuda.modelo.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tipoUsuarioDao extends JpaRepository<TipoUsuario, Integer> {
    
}
