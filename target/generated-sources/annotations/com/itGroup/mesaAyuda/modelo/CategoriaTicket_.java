package com.itGroup.mesaAyuda.modelo;

import com.itGroup.mesaAyuda.modelo.Servicioderivacion;
import com.itGroup.mesaAyuda.modelo.Serviciourgencia;
import com.itGroup.mesaAyuda.modelo.Ticket;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-17T13:44:40", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(CategoriaTicket.class)
public class CategoriaTicket_ { 

    public static volatile ListAttribute<CategoriaTicket, Ticket> ticketList;
    public static volatile ListAttribute<CategoriaTicket, Servicioderivacion> servicioderivacionList;
    public static volatile ListAttribute<CategoriaTicket, Serviciourgencia> serviciourgenciaList;
    public static volatile SingularAttribute<CategoriaTicket, String> nombreCat;
    public static volatile SingularAttribute<CategoriaTicket, Integer> idCategoria;

}