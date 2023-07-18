/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import com.itGroup.mesaAyuda.modelo.TipoUsuario;
import com.itGroup.mesaAyuda.repositorio.tipoUsuarioDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class tipoUsuarioServicio implements Iservicio <TipoUsuario>{

    @Autowired
    tipoUsuarioDao tipousuarioDao;
    
    @Override
    public List<TipoUsuario> listar() {
        return tipousuarioDao.findAll();
    }

    @Override
    public void guardar(TipoUsuario item) {
        tipousuarioDao.save(item);
    }

    @Override
    public void eliminar(TipoUsuario item) {
        tipousuarioDao.delete(item);
    }

    @Override
    public TipoUsuario buscar(TipoUsuario item) {
        return tipousuarioDao.findById(item.getIdTipoUs()).orElse(null);
    }

    @Override
    public TipoUsuario buscar(Integer id) {
        return tipousuarioDao.findById(id).orElse(null);
    }
    
}
