/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import com.itGroup.mesaAyuda.modelo.AreaCliente;
import com.itGroup.mesaAyuda.repositorio.areaClienteDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class areaClienteServicio implements Iservicio<AreaCliente>{

    @Autowired
    areaClienteDao areaclienteDao;
    
    @Override
    public List<AreaCliente> listar() {
        return areaclienteDao.findAll();
    }

    @Override
    public void guardar(AreaCliente item) {
        areaclienteDao.save(item);
    }

    @Override
    public void eliminar(AreaCliente item) {
        areaclienteDao.delete(item);
    }

    @Override
    public AreaCliente buscar(AreaCliente item) {
        return areaclienteDao.findById(item.getIdArea()).orElse(null);
    }

    @Override
    public AreaCliente buscar(Integer id) {
        return areaclienteDao.findById(id).orElse(null);
    }
    
}
