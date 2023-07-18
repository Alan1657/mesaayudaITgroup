/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import com.itGroup.mesaAyuda.modelo.Cliente;
import com.itGroup.mesaAyuda.repositorio.clienteDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clienteServicio implements Iservicio <Cliente>{

    @Autowired
    clienteDao clienteDao;
    
    @Override
    public List<Cliente> listar() {
        return clienteDao.findAll();
    }

    @Override
    public void guardar(Cliente item) {
        clienteDao.save(item);
    }

    @Override
    public void eliminar(Cliente item) {
        clienteDao.delete(item);
    }

    @Override
    public Cliente buscar(Cliente item) {
        return clienteDao.findById(item.getIdCliente()).orElse(null);
    }

    @Override
    public Cliente buscar(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }
    
}
