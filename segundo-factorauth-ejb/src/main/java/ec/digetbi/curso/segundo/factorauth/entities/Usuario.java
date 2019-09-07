/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.digetbi.curso.segundo.factorauth.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilson Castro
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUser", query = "SELECT u FROM Usuario u WHERE u.idUser = :idUser and :")
    , @NamedQuery(name = "Usuario.findByNameUser", query = "SELECT u FROM Usuario u WHERE u.nameUser = :nameUser")
    , @NamedQuery(name = "Usuario.findByNicknameUser", query = "SELECT u FROM Usuario u WHERE u.nicknameUser = :nicknameUser")
    , @NamedQuery(name = "Usuario.findByEmailUser", query = "SELECT u FROM Usuario u WHERE u.emailUser = :emailUser")
    , @NamedQuery(name = "Usuario.findByPassUser", query = "SELECT u FROM Usuario u WHERE u.passUser = :passUser")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private Integer idUser;
    @Size(max = 50)
    @Column(name = "name_user")
    private String nameUser;
    @Size(max = 50)
    @Column(name = "nickname_user")
    private String nicknameUser;
    @Size(max = 50)
    @Column(name = "email_user")
    private String emailUser;
    @Size(max = 50)
    @Column(name = "pass_user")
    private String passUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<GeneratorCode> generatorCodeList;

    public Usuario() {
    }

    public Usuario(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNicknameUser() {
        return nicknameUser;
    }

    public void setNicknameUser(String nicknameUser) {
        this.nicknameUser = nicknameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    @XmlTransient
    public List<GeneratorCode> getGeneratorCodeList() {
        return generatorCodeList;
    }

    public void setGeneratorCodeList(List<GeneratorCode> generatorCodeList) {
        this.generatorCodeList = generatorCodeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.digetbi.curso.segundo.factorauth.entities.Usuario[ idUser=" + idUser + " ]";
    }
    
}
