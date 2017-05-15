/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 09123471980
 */
@Entity
@Table(name = "PASSAGEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passagem.findAll", query = "SELECT p FROM Passagem p"),
    @NamedQuery(name = "Passagem.findById", query = "SELECT p FROM Passagem p WHERE p.id = :id"),
    @NamedQuery(name = "Passagem.findByHorario", query = "SELECT p FROM Passagem p WHERE p.horario = :horario"),
    @NamedQuery(name = "Passagem.findByValor", query = "SELECT p FROM Passagem p WHERE p.valor = :valor"),
    @NamedQuery(name = "Passagem.findByIdviagem", query = "SELECT p FROM Passagem p WHERE p.idviagem = :idviagem"),
    @NamedQuery(name = "Passagem.findByAssento", query = "SELECT p FROM Passagem p WHERE p.assento = :assento")})
public class Passagem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "HORARIO")
    @Temporal(TemporalType.DATE)
    private Date horario;
    @Column(name = "VALOR")
    private Double valor;
    @Column(name = "IDVIAGEM")
    private Integer idviagem;
    @Size(max = 3)
    @Column(name = "ASSENTO")
    private String assento;

    public Passagem() {
    }

    public Passagem(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getIdviagem() {
        return idviagem;
    }

    public void setIdviagem(Integer idviagem) {
        this.idviagem = idviagem;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passagem)) {
            return false;
        }
        Passagem other = (Passagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Passagem[ id=" + id + " ]";
    }
    
}
