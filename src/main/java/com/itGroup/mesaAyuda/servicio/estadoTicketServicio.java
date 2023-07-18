/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import com.itGroup.mesaAyuda.modelo.EstadoTicket;
import com.itGroup.mesaAyuda.repositorio.estadoTicketDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class estadoTicketServicio implements Iservicio <EstadoTicket>{

    @Autowired
    estadoTicketDao estadoticketDao;
    
    
    @Override
    public List<EstadoTicket> listar() {
        return estadoticketDao.findAll();
    }

    @Override
    public void guardar(EstadoTicket item) {
        estadoticketDao.save(item);
    }

    @Override
    public void eliminar(EstadoTicket item) {
        estadoticketDao.delete(item);
    }

    @Override
    public EstadoTicket buscar(EstadoTicket item) {
        return estadoticketDao.findById(item.getIdEstado()).orElse(null);
    }

    @Override
    public EstadoTicket buscar(Integer id) {
        return estadoticketDao.findById(id).orElse(null);
    }
    
}
