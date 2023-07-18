/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import com.itGroup.mesaAyuda.modelo.CategoriaTicket;
import com.itGroup.mesaAyuda.repositorio.categoriaTicketDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class categoriaTicketServicio implements Iservicio <CategoriaTicket>{

    @Autowired
    categoriaTicketDao categoriaticketDao;
    
    @Override
    public List<CategoriaTicket> listar() {
        return categoriaticketDao.findAll();
    }

    @Override
    public void guardar(CategoriaTicket item) {
        categoriaticketDao.save(item);
    }

    @Override
    public void eliminar(CategoriaTicket item) {
        categoriaticketDao.delete(item);
    }

    @Override
    public CategoriaTicket buscar(CategoriaTicket item) {
        return categoriaticketDao.findById(item.getIdCategoria()).orElse(null);
    }

    @Override
    public CategoriaTicket buscar(Integer id) {
        return categoriaticketDao.findById(id).orElse(null);
    }
    
}
