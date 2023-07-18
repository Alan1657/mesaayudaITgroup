package com.itGroup.mesaAyuda.modelo;

import com.itGroup.mesaAyuda.modelo.Servicioderivacion;
import com.itGroup.mesaAyuda.modelo.Serviciourgencia;
import com.itGroup.mesaAyuda.modelo.Ticket;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-17T13:44:40", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(UrgenciaTicket.class)
public class UrgenciaTicket_ { 

    public static volatile ListAttribute<UrgenciaTicket, Ticket> ticketList;
    public static volatile ListAttribute<UrgenciaTicket, Servicioderivacion> servicioderivacionList;
    public static volatile ListAttribute<UrgenciaTicket, Serviciourgencia> serviciourgenciaList;
    public static volatile SingularAttribute<UrgenciaTicket, Integer> idUrgencia;
    public static volatile SingularAttribute<UrgenciaTicket, String> urgencia;

}