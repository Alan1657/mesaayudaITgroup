/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itGroup.mesaAyuda.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Entity
@Data
@Table(name = "serviciourgencia")
public class Serviciourgencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Servicio_Urgencia")
    private Integer idServicioUrgencia;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    @JsonIgnore
    private AreaCliente idArea;
    @JoinColumn(name = "id_urgencia_ticket", referencedColumnName = "id_urgencia")
    @ManyToOne(optional = false)
    @JsonIgnore
    private UrgenciaTicket idUrgenciaTicket;
    @JoinColumn(name = "id_categoria_ticket", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    @JsonIgnore
    private CategoriaTicket idCategoriaTicket;

    
    
}
