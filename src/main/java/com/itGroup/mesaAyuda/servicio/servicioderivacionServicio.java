/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import com.itGroup.mesaAyuda.modelo.AreaCliente;
import com.itGroup.mesaAyuda.modelo.CategoriaTicket;
import com.itGroup.mesaAyuda.modelo.Servicioderivacion;
import com.itGroup.mesaAyuda.modelo.UrgenciaTicket;
import com.itGroup.mesaAyuda.repositorio.ServicioderivacionDao;
import com.itGroup.mesaAyuda.repositorio.categoriaTicketDao;
import com.itGroup.mesaAyuda.repositorio.clienteDao;
import com.itGroup.mesaAyuda.repositorio.ticketDao;
import com.itGroup.mesaAyuda.repositorio.urgenciaTicketDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class servicioderivacionServicio implements Iservicio<Servicioderivacion>{

    @Autowired
    ServicioderivacionDao Servicioderivaciondao;
    
    @Autowired
    urgenciaTicketDao urgenciaticketDao;
    
    @Autowired
    ticketDao ticketdao;
    
    @Autowired
    categoriaTicketDao categoriaticketDao;
        
    @Override
    public List<Servicioderivacion> listar() {
        return Servicioderivaciondao.findAll();
    }

    @Override
    public void guardar(Servicioderivacion item) {
        Servicioderivaciondao.save(item);
    }

    @Override
    public void eliminar(Servicioderivacion item) {
        Servicioderivaciondao.delete(item);
    }

    @Override
    public Servicioderivacion buscar(Servicioderivacion item) {
        return Servicioderivaciondao.findById(item.getId()).orElse(null);
    }

    @Override
    public Servicioderivacion buscar(Integer id) {
        return Servicioderivaciondao.findById(id).orElse(null);
    }
    
   public Servicioderivacion buscarIdUsuarioAndIdCategoria(Integer IdUrgencia,Integer IdCategoria){
        
        UrgenciaTicket urgenciaTicket=urgenciaticketDao.findById(IdUrgencia).get();
        CategoriaTicket categoriaTicket=categoriaticketDao.findById(IdCategoria).get();
           
        return Servicioderivaciondao.findByIdUrgenciaTicketAndIdCategoriaTicket(urgenciaTicket,categoriaTicket);
    
   }
}
