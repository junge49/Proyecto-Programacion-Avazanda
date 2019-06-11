/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joel_
 */
@Entity
@Table(name = "empleadoal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoAL.findAll", query = "SELECT e FROM EmpleadoAL e"),
    @NamedQuery(name = "EmpleadoAL.findByIdEmpleadoAL", query = "SELECT e FROM EmpleadoAL e WHERE e.idEmpleadoAL = :idEmpleadoAL"),
    @NamedQuery(name = "EmpleadoAL.findByNombre", query = "SELECT e FROM EmpleadoAL e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EmpleadoAL.findByAPaterno", query = "SELECT e FROM EmpleadoAL e WHERE e.aPaterno = :aPaterno"),
    @NamedQuery(name = "EmpleadoAL.findByAMaterno", query = "SELECT e FROM EmpleadoAL e WHERE e.aMaterno = :aMaterno"),
    @NamedQuery(name = "EmpleadoAL.findByDireccion", query = "SELECT e FROM EmpleadoAL e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "EmpleadoAL.findByTelefono", query = "SELECT e FROM EmpleadoAL e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "EmpleadoAL.findByFechaNac", query = "SELECT e FROM EmpleadoAL e WHERE e.fechaNac = :fechaNac"),
    @NamedQuery(name = "EmpleadoAL.findByGenero", query = "SELECT e FROM EmpleadoAL e WHERE e.genero = :genero"),
    @NamedQuery(name = "EmpleadoAL.findBySueldo", query = "SELECT e FROM EmpleadoAL e WHERE e.sueldo = :sueldo")})
public class EmpleadoAL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpleadoAL")
    private Integer idEmpleadoAL;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APaterno")
    private String aPaterno;
    @Basic(optional = false)
    @Column(name = "AMaterno")
    private String aMaterno;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "Telefono")
    private int telefono;
    @Basic(optional = false)
    @Column(name = "FechaNac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Basic(optional = false)
    @Column(name = "Genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "Sueldo")
    private double sueldo;

    public EmpleadoAL() {
    }

    public EmpleadoAL(Integer idEmpleadoAL) {
        this.idEmpleadoAL = idEmpleadoAL;
    }

    public EmpleadoAL(Integer idEmpleadoAL, String nombre, String aPaterno, String aMaterno, String direccion, int telefono, Date fechaNac, String genero, double sueldo) {
        this.idEmpleadoAL = idEmpleadoAL;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
        this.genero = genero;
        this.sueldo = sueldo;
    }

    public Integer getIdEmpleadoAL() {
        return idEmpleadoAL;
    }

    public void setIdEmpleadoAL(Integer idEmpleadoAL) {
        this.idEmpleadoAL = idEmpleadoAL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAPaterno() {
        return aPaterno;
    }

    public void setAPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getAMaterno() {
        return aMaterno;
    }

    public void setAMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleadoAL != null ? idEmpleadoAL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoAL)) {
            return false;
        }
        EmpleadoAL other = (EmpleadoAL) object;
        if ((this.idEmpleadoAL == null && other.idEmpleadoAL != null) || (this.idEmpleadoAL != null && !this.idEmpleadoAL.equals(other.idEmpleadoAL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EmpleadoAL[ idEmpleadoAL=" + idEmpleadoAL + " ]";
    }
    
}
