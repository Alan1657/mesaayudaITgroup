/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import com.itGroup.mesaAyuda.modelo.AreaCliente;
import com.itGroup.mesaAyuda.modelo.CategoriaTicket;
import com.itGroup.mesaAyuda.modelo.Servicioderivacion;
import com.itGroup.mesaAyuda.modelo.Serviciourgencia;
import com.itGroup.mesaAyuda.repositorio.ServiciourgenciaDao;
import com.itGroup.mesaAyuda.repositorio.categoriaTicketDao;
import com.itGroup.mesaAyuda.repositorio.clienteDao;
import com.itGroup.mesaAyuda.repositorio.ticketDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciourgenciaServicio implements Iservicio<Serviciourgencia>{

    
    @Autowired
    ServiciourgenciaDao Serviciourgenciadao;
    
    @Autowired
    clienteDao clientedao;
    
    @Autowired
    ticketDao ticketdao;
    
    @Autowired
    categoriaTicketDao categoriaticketDao;
    
    @Override
    public List<Serviciourgencia> listar() {
        return Serviciourgenciadao.findAll();
    }

    @Override
    public void guardar(Serviciourgencia item) {
        Serviciourgenciadao.save(item);
    }

    @Override
    public void eliminar(Serviciourgencia item) {
        Serviciourgenciadao.delete(item);
    }

    @Override
    public Serviciourgencia buscar(Serviciourgencia item) {
        return Serviciourgenciadao.findById(item.getIdServicioUrgencia()).orElse(null);
    }

    @Override
    public Serviciourgencia buscar(Integer id) {
        return Serviciourgenciadao.findById(id).orElse(null);
    }
    
     public Serviciourgencia buscarIdUsuarioAndIdCategoria(Integer IdUsuario,Integer IdCategoria){
        
         AreaCliente areaCliente=clientedao.findById(IdUsuario).get().getIdArea();
        CategoriaTicket categoriaTicket=categoriaticketDao.findById(IdCategoria).get();
           
        return Serviciourgenciadao.findByIdAreaAndIdCategoriaTicket(areaCliente,categoriaTicket);
        
    }
    
}
