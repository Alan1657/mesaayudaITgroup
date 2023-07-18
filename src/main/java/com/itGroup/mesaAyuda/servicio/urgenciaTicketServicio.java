/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import com.itGroup.mesaAyuda.modelo.UrgenciaTicket;
import com.itGroup.mesaAyuda.repositorio.urgenciaTicketDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class urgenciaTicketServicio implements Iservicio <UrgenciaTicket>{

    @Autowired
    urgenciaTicketDao urgenciaticketDao;
    
    @Override
    public List<UrgenciaTicket> listar() {
        return urgenciaticketDao.findAll();
    }

    @Override
    public void guardar(UrgenciaTicket item) {
        urgenciaticketDao.save(item);
    }

    @Override
    public void eliminar(UrgenciaTicket item) {
        urgenciaticketDao.delete(item);
    }

    @Override
    public UrgenciaTicket buscar(UrgenciaTicket item) {
        return urgenciaticketDao.findById(item.getIdUrgencia()).orElse(null);
    }

    @Override
    public UrgenciaTicket buscar(Integer id) {
        return urgenciaticketDao.findById(id).orElse(null);
    }
    
}
