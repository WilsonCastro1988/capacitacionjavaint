package ec.digetbi.curso.segundo.factorauth.entities;

import ec.digetbi.curso.segundo.factorauth.entities.GeneratorCode;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2019-09-14T11:23:59")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Integer> idUser;
    public static volatile SingularAttribute<Usuario, String> nicknameUser;
    public static volatile SingularAttribute<Usuario, String> nameUser;
    public static volatile SingularAttribute<Usuario, String> emailUser;
    public static volatile SingularAttribute<Usuario, String> passUser;
    public static volatile ListAttribute<Usuario, GeneratorCode> generatorCodeList;

}