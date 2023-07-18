package com.itGroup.mesaAyuda.modelo;

import com.itGroup.mesaAyuda.modelo.Cliente;
import com.itGroup.mesaAyuda.modelo.Serviciourgencia;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-17T13:44:40", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(AreaCliente.class)
public class AreaCliente_ { 

    public static volatile ListAttribute<AreaCliente, Cliente> clienteList;
    public static volatile SingularAttribute<AreaCliente, String> nombreArea;
    public static volatile SingularAttribute<AreaCliente, Integer> idArea;
    public static volatile ListAttribute<AreaCliente, Serviciourgencia> serviciourgenciaList;

}