package com.itGroup.mesaAyuda.modelo;

import com.itGroup.mesaAyuda.modelo.AreaCliente;
import com.itGroup.mesaAyuda.modelo.Ticket;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-17T13:44:40", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile ListAttribute<Cliente, Ticket> ticketList;
    public static volatile SingularAttribute<Cliente, String> dNIcli;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, AreaCliente> idArea;
    public static volatile SingularAttribute<Cliente, String> nombreCli;
    public static volatile SingularAttribute<Cliente, String> correo;
    public static volatile SingularAttribute<Cliente, String> apellidoCli;
    public static volatile SingularAttribute<Cliente, Date> fechaRegCli;
    public static volatile SingularAttribute<Cliente, String> telefono;

}