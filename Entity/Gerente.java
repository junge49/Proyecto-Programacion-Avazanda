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
@Table(name = "gerente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerente.findAll", query = "SELECT g FROM Gerente g"),
    @NamedQuery(name = "Gerente.findByIdGerente", query = "SELECT g FROM Gerente g WHERE g.idGerente = :idGerente"),
    @NamedQuery(name = "Gerente.findByNombre", query = "SELECT g FROM Gerente g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Gerente.findByAPaterno", query = "SELECT g FROM Gerente g WHERE g.aPaterno = :aPaterno"),
    @NamedQuery(name = "Gerente.findByAMaterno", query = "SELECT g FROM Gerente g WHERE g.aMaterno = :aMaterno"),
    @NamedQuery(name = "Gerente.findByContrase\u00f1a", query = "SELECT g FROM Gerente g WHERE g.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Gerente.findByTelefono", query = "SELECT g FROM Gerente g WHERE g.telefono = :telefono"),
    @NamedQuery(name = "Gerente.findByDireccion", query = "SELECT g FROM Gerente g WHERE g.direccion = :direccion"),
    @NamedQuery(name = "Gerente.findByFechaNac", query = "SELECT g FROM Gerente g WHERE g.fechaNac = :fechaNac"),
    @NamedQuery(name = "Gerente.findByGenero", query = "SELECT g FROM Gerente g WHERE g.genero = :genero"),
    @NamedQuery(name = "Gerente.findBySueldo", query = "SELECT g FROM Gerente g WHERE g.sueldo = :sueldo")})
public class Gerente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idGerente")
    private Integer idGerente;
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
    @Column(name = "Contrase\u00f1a")
    private String contraseña;
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

    public Gerente() {
    }

    public Gerente(Integer idGerente) {
        this.idGerente = idGerente;
    }

    public Gerente(Integer idGerente, String nombre, String aPaterno, String aMaterno, String contraseña, int telefono, String direccion, Date fechaNac, String genero, double sueldo) {
        this.idGerente = idGerente;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNac = fechaNac;
        this.genero = genero;
        this.sueldo = sueldo;
    }

    public Integer getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Integer idGerente) {
        this.idGerente = idGerente;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
        hash += (idGerente != null ? idGerente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerente)) {
            return false;
        }
        Gerente other = (Gerente) object;
        if ((this.idGerente == null && other.idGerente != null) || (this.idGerente != null && !this.idGerente.equals(other.idGerente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Gerente[ idGerente=" + idGerente + " ]";
    }
    
}
