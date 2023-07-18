package com.itGroup.mesaAyuda.modelo;

import com.itGroup.mesaAyuda.modelo.EstadoUsu;
import com.itGroup.mesaAyuda.modelo.Ticket;
import com.itGroup.mesaAyuda.modelo.TipoUsuario;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-17T13:44:40", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, Ticket> ticketList;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, EstadoUsu> idEstadoUsu;
    public static volatile SingularAttribute<Usuario, String> apellidoUsu;
    public static volatile SingularAttribute<Usuario, Date> fechaRegUsu;
    public static volatile SingularAttribute<Usuario, String> telefonoUsu;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> dNIusu;
    public static volatile SingularAttribute<Usuario, String> correoUsu;
    public static volatile SingularAttribute<Usuario, String> usuario;
    public static volatile ListAttribute<Usuario, TipoUsuario> tipoUsuarioList;
    public static volatile SingularAttribute<Usuario, String> nombreUsu;

}