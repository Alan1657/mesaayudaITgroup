/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import com.itGroup.mesaAyuda.modelo.EstadoUsu;
import com.itGroup.mesaAyuda.repositorio.estadoUsuDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class estadoUsuServicio implements Iservicio <EstadoUsu>{

    
    @Autowired
    estadoUsuDao estadousuDao;
    
    @Override
    public List<EstadoUsu> listar() {
        return estadousuDao.findAll();
    }

    @Override
    public void guardar(EstadoUsu item) {
        estadousuDao.save(item);
    }

    @Override
    public void eliminar(EstadoUsu item) {
        estadousuDao.delete(item);
    }

    @Override
    public EstadoUsu buscar(EstadoUsu item) {
        return estadousuDao.findById(item.getIdEstadoUsu()).orElse(null);
    }

    @Override
    public EstadoUsu buscar(Integer id) {
        return estadousuDao.findById(id).orElse(null);
    }
    
}
