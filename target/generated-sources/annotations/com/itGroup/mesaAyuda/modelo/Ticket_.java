package com.itGroup.mesaAyuda.modelo;

import com.itGroup.mesaAyuda.modelo.CategoriaTicket;
import com.itGroup.mesaAyuda.modelo.Cliente;
import com.itGroup.mesaAyuda.modelo.EstadoTicket;
import com.itGroup.mesaAyuda.modelo.UrgenciaTicket;
import com.itGroup.mesaAyuda.modelo.Usuario;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-17T13:44:40", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Integer> idTicket;
    public static volatile SingularAttribute<Ticket, EstadoTicket> idEstado;
    public static volatile SingularAttribute<Ticket, Date> fechaRegTicket;
    public static volatile SingularAttribute<Ticket, Cliente> idCliente;
    public static volatile SingularAttribute<Ticket, Usuario> idUsuario;
    public static volatile SingularAttribute<Ticket, UrgenciaTicket> idUrgencia;
    public static volatile SingularAttribute<Ticket, CategoriaTicket> idCategoria;
    public static volatile SingularAttribute<Ticket, String> numeroTicket;
    public static volatile SingularAttribute<Ticket, String> observacion;

}