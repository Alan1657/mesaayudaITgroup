/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itGroup.mesaAyuda.servicio;

import java.util.List;

public interface Iservicio<T>  {
    
    public List<T> listar();

    public void guardar(T item);

    public void eliminar(T item);

    public T buscar(T item);
    
    public T buscar(Integer id);
    
}
