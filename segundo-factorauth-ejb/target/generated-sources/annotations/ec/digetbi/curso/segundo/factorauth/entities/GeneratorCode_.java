package ec.digetbi.curso.segundo.factorauth.entities;

import ec.digetbi.curso.segundo.factorauth.entities.Message;
import ec.digetbi.curso.segundo.factorauth.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2019-09-15T22:14:24")
@StaticMetamodel(GeneratorCode.class)
public class GeneratorCode_ { 

    public static volatile SingularAttribute<GeneratorCode, Usuario> idUser;
    public static volatile ListAttribute<GeneratorCode, Message> messageList;
    public static volatile SingularAttribute<GeneratorCode, Integer> idCode;
    public static volatile SingularAttribute<GeneratorCode, Date> dateStartCode;
    public static volatile SingularAttribute<GeneratorCode, String> valueCode;
    public static volatile SingularAttribute<GeneratorCode, Date> dateEndCode;

}