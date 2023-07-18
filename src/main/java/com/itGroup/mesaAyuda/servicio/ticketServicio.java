/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import com.itGroup.mesaAyuda.modelo.Ticket;
import com.itGroup.mesaAyuda.repositorio.ticketDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AlanHuerta
 */
@Service
public class ticketServicio implements Iservicio <Ticket>{

    @Autowired
    ticketDao ticketdao;
    
    @Override
    public List<Ticket> listar() {
        return ticketdao.findAll();
    }

    @Override
    public void guardar(Ticket item) {
        ticketdao.save(item);
    }

    @Override
    public void eliminar(Ticket item) {
        ticketdao.delete(item);
    }

    @Override
    public Ticket buscar(Ticket item) {
        return ticketdao.findById(item.getIdTicket()).orElse(null);
    }

    @Override
    public Ticket buscar(Integer id) {
        return ticketdao.findById(id).orElse(null);
    }
    
}
