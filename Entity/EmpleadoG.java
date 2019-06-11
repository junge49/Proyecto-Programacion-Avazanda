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
@Table(name = "empleadog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoG.findAll", query = "SELECT e FROM EmpleadoG e"),
    @NamedQuery(name = "EmpleadoG.findByIdEmpleadoG", query = "SELECT e FROM EmpleadoG e WHERE e.idEmpleadoG = :idEmpleadoG"),
    @NamedQuery(name = "EmpleadoG.findByNombre", query = "SELECT e FROM EmpleadoG e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EmpleadoG.findByAPaterno", query = "SELECT e FROM EmpleadoG e WHERE e.aPaterno = :aPaterno"),
    @NamedQuery(name = "EmpleadoG.findByAMaterno", query = "SELECT e FROM EmpleadoG e WHERE e.aMaterno = :aMaterno"),
    @NamedQuery(name = "EmpleadoG.findByTelefono", query = "SELECT e FROM EmpleadoG e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "EmpleadoG.findByDireccion", query = "SELECT e FROM EmpleadoG e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "EmpleadoG.findByFechaNac", query = "SELECT e FROM EmpleadoG e WHERE e.fechaNac = :fechaNac"),
    @NamedQuery(name = "EmpleadoG.findByGenero", query = "SELECT e FROM EmpleadoG e WHERE e.genero = :genero"),
    @NamedQuery(name = "EmpleadoG.findBySueldo", query = "SELECT e FROM EmpleadoG e WHERE e.sueldo = :sueldo")})
public class EmpleadoG implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmpleadoG")
    private Integer idEmpleadoG;
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
    @Column(name = "Telefono")
    private int telefono;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
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

    public EmpleadoG() {
    }

    public EmpleadoG(Integer idEmpleadoG) {
        this.idEmpleadoG = idEmpleadoG;
    }

    public EmpleadoG(Integer idEmpleadoG, String nombre, String aPaterno, String aMaterno, int telefono, String direccion, Date fechaNac, String genero, double sueldo) {
        this.idEmpleadoG = idEmpleadoG;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNac = fechaNac;
        this.genero = genero;
        this.sueldo = sueldo;
    }

    public Integer getIdEmpleadoG() {
        return idEmpleadoG;
    }

    public void setIdEmpleadoG(Integer idEmpleadoG) {
        this.idEmpleadoG = idEmpleadoG;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        hash += (idEmpleadoG != null ? idEmpleadoG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoG)) {
            return false;
        }
        EmpleadoG other = (EmpleadoG) object;
        if ((this.idEmpleadoG == null && other.idEmpleadoG != null) || (this.idEmpleadoG != null && !this.idEmpleadoG.equals(other.idEmpleadoG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EmpleadoG[ idEmpleadoG=" + idEmpleadoG + " ]";
    }
    
}
