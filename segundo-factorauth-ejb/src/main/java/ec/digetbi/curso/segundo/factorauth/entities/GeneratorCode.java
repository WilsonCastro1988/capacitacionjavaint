/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.digetbi.curso.segundo.factorauth.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Wilson Castro
 */
@Entity
@Table(name = "generator_code")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneratorCode.findAll", query = "SELECT g FROM GeneratorCode g")
    , @NamedQuery(name = "GeneratorCode.findByIdCode", query = "SELECT g FROM GeneratorCode g WHERE g.idCode = :idCode")
    , @NamedQuery(name = "GeneratorCode.findByValueCode", query = "SELECT g FROM GeneratorCode g WHERE g.valueCode = :valueCode")
    , @NamedQuery(name = "GeneratorCode.findByDateStartCode", query = "SELECT g FROM GeneratorCode g WHERE g.dateStartCode = :dateStartCode")
    , @NamedQuery(name = "GeneratorCode.findByDateEndCode", query = "SELECT g FROM GeneratorCode g WHERE g.dateEndCode = :dateEndCode")})
public class GeneratorCode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_code")
    private Integer idCode;
    @Size(max = 5)
    @Column(name = "value_code")
    private String valueCode;
    @Column(name = "date_start_code")
    @Temporal(TemporalType.DATE)
    private Date dateStartCode;
    @Column(name = "date_end_code")
    @Temporal(TemporalType.DATE)
    private Date dateEndCode;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private Usuario idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCode")
    private List<Message> messageList;

    public GeneratorCode() {
    }

    public GeneratorCode(Integer idCode) {
        this.idCode = idCode;
    }

    public Integer getIdCode() {
        return idCode;
    }

    public void setIdCode(Integer idCode) {
        this.idCode = idCode;
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    public Date getDateStartCode() {
        return dateStartCode;
    }

    public void setDateStartCode(Date dateStartCode) {
        this.dateStartCode = dateStartCode;
    }

    public Date getDateEndCode() {
        return dateEndCode;
    }

    public void setDateEndCode(Date dateEndCode) {
        this.dateEndCode = dateEndCode;
    }

    public Usuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Usuario idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCode != null ? idCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneratorCode)) {
            return false;
        }
        GeneratorCode other = (GeneratorCode) object;
        if ((this.idCode == null && other.idCode != null) || (this.idCode != null && !this.idCode.equals(other.idCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.digetbi.curso.segundo.factorauth.entities.GeneratorCode[ idCode=" + idCode + " ]";
    }
    
}
