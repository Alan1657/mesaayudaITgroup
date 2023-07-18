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
@Table(name = "servicioderivacion")
public class Servicioderivacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_categoria_ticket", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    @JsonIgnore
    private CategoriaTicket idCategoriaTicket;
    @JoinColumn(name = "id_urgencia_ticket", referencedColumnName = "id_urgencia")
    @ManyToOne(optional = false)
    @JsonIgnore
    private UrgenciaTicket idUrgenciaTicket;
    @JoinColumn(name = "id_tipo_usuario", referencedColumnName = "id_tipo_us")
    @ManyToOne(optional = false)
    @JsonIgnore
    private TipoUsuario idTipoUsuario;

   
    
}
