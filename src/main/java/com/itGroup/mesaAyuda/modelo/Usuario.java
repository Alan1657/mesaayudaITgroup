/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itGroup.mesaAyuda.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_usu")
    private String nombreUsu;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 150)
    @Column(name = "apellido_usu")
    private String apellidoUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNI_usu")
    private String dNIusu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_reg_usu")
    @Temporal(TemporalType.DATE)
    private Date fechaRegUsu;
    @Size(max = 100)
    @Column(name = "telefono_usu")
    private String telefonoUsu;
    @Size(max = 100)
    @Column(name = "correo_usu")
    private String correoUsu;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 100)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @JoinTable(name = "usuariotipo", joinColumns = {
        @JoinColumn(name = "usuarioId", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "tipoId", referencedColumnName = "id_tipo_us")})
    @ManyToMany
    private List<TipoUsuario> tipoUsuarioList;
    @OneToMany(mappedBy = "idUsuario")
    @JsonIgnore
    private List<Ticket> ticketList;
    @JoinColumn(name = "id_estado_usu", referencedColumnName = "id_estado_usu")
    @ManyToOne(optional = false)
    private EstadoUsu idEstadoUsu;

   
   
}
