/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "Passagem.findByValor", query = "SELECT p FROM Passagem p WHERE p.valor = :valor"),
    @NamedQuery(name = "Passagem.findByHorario", query = "SELECT p FROM Passagem p WHERE p.horario = :horario"),
    @NamedQuery(name = "Passagem.findByAssentosDisponiveis", query = "SELECT p FROM Passagem p WHERE p.assentosDisponiveis = :assentosDisponiveis")})
public class Passagem implements Serializable {

    @OneToMany(mappedBy = "idPassagem")
    private List<Reserva> reservaList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "VALOR")
    private Integer valor;
    @Column(name = "HORARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    @Column(name = "ASSENTOS_DISPONIVEIS")
    private Integer assentosDisponiveis;
    @JoinColumn(name = "ID_VIAGEM", referencedColumnName = "ID")
    @ManyToOne
    private Viagem idViagem;

    public Passagem() {
    }

    public Passagem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Integer getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void setAssentosDisponiveis(Integer assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public Viagem getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(Viagem idViagem) {
        this.idViagem = idViagem;
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

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }
    
}
