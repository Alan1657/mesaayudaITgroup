/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.itGroup.mesaAyuda.repositorio;

import com.itGroup.mesaAyuda.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

public interface usuarioDao extends JpaRepository<Usuario, Integer> {
    
    @Transactional
    Usuario findByCorreoUsu(String username);
    
}
