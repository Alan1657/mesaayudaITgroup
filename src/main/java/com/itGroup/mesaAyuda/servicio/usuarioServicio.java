/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import com.itGroup.mesaAyuda.modelo.Usuario;
import com.itGroup.mesaAyuda.repositorio.usuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usuarioServicio implements Iservicio<Usuario>{

    
    @Autowired
    usuarioDao usuariodao;
    
    
    @Override
    public List<Usuario> listar() {
        return usuariodao.findAll();
    }

    @Override
    public void guardar(Usuario item) {
        usuariodao.save(item);
    }

    @Override
    public void eliminar(Usuario item) {
        usuariodao.delete(item);
    }

    @Override
    public Usuario buscar(Usuario item) {
        return usuariodao.findById(item.getIdUsuario()).orElse(null);
    }

    @Override
    public Usuario buscar(Integer id) {
        return usuariodao.findById(id).orElse(null);
    }

    public Usuario buscarPorNombreUsuario(String username) {
        return usuariodao.findByCorreoUsu(username);
    }
    
}
