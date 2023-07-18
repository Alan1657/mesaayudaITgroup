package com.itGroup.mesaAyuda.modelo;

import com.itGroup.mesaAyuda.modelo.CategoriaTicket;
import com.itGroup.mesaAyuda.modelo.TipoUsuario;
import com.itGroup.mesaAyuda.modelo.UrgenciaTicket;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-17T13:44:40", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Servicioderivacion.class)
public class Servicioderivacion_ { 

    public static volatile SingularAttribute<Servicioderivacion, TipoUsuario> idTipoUsuario;
    public static volatile SingularAttribute<Servicioderivacion, CategoriaTicket> idCategoriaTicket;
    public static volatile SingularAttribute<Servicioderivacion, UrgenciaTicket> idUrgenciaTicket;
    public static volatile SingularAttribute<Servicioderivacion, Integer> id;

}