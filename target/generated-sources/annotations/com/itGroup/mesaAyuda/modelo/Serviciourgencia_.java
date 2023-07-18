package com.itGroup.mesaAyuda.modelo;

import com.itGroup.mesaAyuda.modelo.AreaCliente;
import com.itGroup.mesaAyuda.modelo.CategoriaTicket;
import com.itGroup.mesaAyuda.modelo.UrgenciaTicket;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-17T13:44:40", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Serviciourgencia.class)
public class Serviciourgencia_ { 

    public static volatile SingularAttribute<Serviciourgencia, AreaCliente> idArea;
    public static volatile SingularAttribute<Serviciourgencia, Integer> idServicioUrgencia;
    public static volatile SingularAttribute<Serviciourgencia, CategoriaTicket> idCategoriaTicket;
    public static volatile SingularAttribute<Serviciourgencia, UrgenciaTicket> idUrgenciaTicket;

}