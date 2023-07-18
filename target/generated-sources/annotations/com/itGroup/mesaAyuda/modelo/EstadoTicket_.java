package com.itGroup.mesaAyuda.modelo;

import com.itGroup.mesaAyuda.modelo.Ticket;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-17T13:44:40", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(EstadoTicket.class)
public class EstadoTicket_ { 

    public static volatile SingularAttribute<EstadoTicket, String> estado;
    public static volatile SingularAttribute<EstadoTicket, Integer> idEstado;
    public static volatile ListAttribute<EstadoTicket, Ticket> ticketList;

}