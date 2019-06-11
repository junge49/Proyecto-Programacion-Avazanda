/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joel_
 */
@Entity
@Table(name = "espaciosest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspaciosEst.findAll", query = "SELECT e FROM EspaciosEst e"),
    @NamedQuery(name = "EspaciosEst.findByIdEspaciosEst", query = "SELECT e FROM EspaciosEst e WHERE e.idEspaciosEst = :idEspaciosEst"),
    @NamedQuery(name = "EspaciosEst.findByOcupado", query = "SELECT e FROM EspaciosEst e WHERE e.ocupado = :ocupado")})
public class EspaciosEst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEspaciosEst")
    private Integer idEspaciosEst;
    @Basic(optional = false)
    @Column(name = "Ocupado")
    private int ocupado;

    public EspaciosEst() {
    }

    public EspaciosEst(Integer idEspaciosEst) {
        this.idEspaciosEst = idEspaciosEst;
    }

    public EspaciosEst(Integer idEspaciosEst, int ocupado) {
        this.idEspaciosEst = idEspaciosEst;
        this.ocupado = ocupado;
    }

    public Integer getIdEspaciosEst() {
        return idEspaciosEst;
    }

    public void setIdEspaciosEst(Integer idEspaciosEst) {
        this.idEspaciosEst = idEspaciosEst;
    }

    public int getOcupado() {
        return ocupado;
    }

    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspaciosEst != null ? idEspaciosEst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspaciosEst)) {
            return false;
        }
        EspaciosEst other = (EspaciosEst) object;
        if ((this.idEspaciosEst == null && other.idEspaciosEst != null) || (this.idEspaciosEst != null && !this.idEspaciosEst.equals(other.idEspaciosEst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EspaciosEst[ idEspaciosEst=" + idEspaciosEst + " ]";
    }
    
}
