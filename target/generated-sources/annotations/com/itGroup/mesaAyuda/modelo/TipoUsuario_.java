package com.itGroup.mesaAyuda.modelo;

import com.itGroup.mesaAyuda.modelo.Servicioderivacion;
import com.itGroup.mesaAyuda.modelo.Usuario;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-17T13:44:40", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(TipoUsuario.class)
public class TipoUsuario_ { 

    public static volatile SingularAttribute<TipoUsuario, Integer> idTipoUs;
    public static volatile SingularAttribute<TipoUsuario, String> tipo;
    public static volatile ListAttribute<TipoUsuario, Usuario> usuarioList;
    public static volatile ListAttribute<TipoUsuario, Servicioderivacion> servicioderivacionList;

}