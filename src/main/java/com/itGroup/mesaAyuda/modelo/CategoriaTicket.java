/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itGroup.mesaAyuda.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author AlanHuerta
 */
@Entity
@Data
@Table(name = "categoria_ticket")
public class CategoriaTicket implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_cat")
    private String nombreCat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaTicket")
    @JsonIgnore
    private List<Serviciourgencia> serviciourgenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaTicket")
    @JsonIgnore
    private List<Servicioderivacion> servicioderivacionList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @OneToMany(mappedBy = "idCategoria")
    @JsonIgnore
    private List<Ticket> ticketList;

     
}
