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
@Table(name = "autos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autos.findAll", query = "SELECT a FROM Autos a"),
    @NamedQuery(name = "Autos.findByIdAutos", query = "SELECT a FROM Autos a WHERE a.idAutos = :idAutos"),
    @NamedQuery(name = "Autos.findByIdEspacio", query = "SELECT a FROM Autos a WHERE a.idEspacio = :idEspacio"),
    @NamedQuery(name = "Autos.findByModelo", query = "SELECT a FROM Autos a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "Autos.findByMarca", query = "SELECT a FROM Autos a WHERE a.marca = :marca"),
    @NamedQuery(name = "Autos.findByPlaca", query = "SELECT a FROM Autos a WHERE a.placa = :placa"),
    @NamedQuery(name = "Autos.findByColor", query = "SELECT a FROM Autos a WHERE a.color = :color"),
    @NamedQuery(name = "Autos.findByEntrada", query = "SELECT a FROM Autos a WHERE a.entrada = :entrada"),
    @NamedQuery(name = "Autos.findByLavado", query = "SELECT a FROM Autos a WHERE a.lavado = :lavado"),
    @NamedQuery(name = "Autos.findByIdEmpleadoG", query = "SELECT a FROM Autos a WHERE a.idEmpleadoG = :idEmpleadoG"),
    @NamedQuery(name = "Autos.findBySalida", query = "SELECT a FROM Autos a WHERE a.salida = :salida"),
    @NamedQuery(name = "Autos.findByPago", query = "SELECT a FROM Autos a WHERE a.pago = :pago")})
public class Autos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAutos")
    private Integer idAutos;
    @Basic(optional = false)
    @Column(name = "idEspacio")
    private int idEspacio;
    @Basic(optional = false)
    @Column(name = "Modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "Marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "Placa")
    private String placa;
    @Basic(optional = false)
    @Column(name = "Color")
    private String color;
    @Basic(optional = false)
    @Column(name = "Entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrada;
    @Basic(optional = false)
    @Column(name = "Lavado")
    private int lavado;
    @Basic(optional = false)
    @Column(name = "idEmpleadoG")
    private int idEmpleadoG;
    @Column(name = "Salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date salida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Pago")
    private Double pago;

    public Autos() {
    }

    public Autos(Integer idAutos) {
        this.idAutos = idAutos;
    }

    public Autos(Integer idAutos, int idEspacio, String modelo, String marca, String placa, String color, Date entrada, int lavado, int idEmpleadoG) {
        this.idAutos = idAutos;
        this.idEspacio = idEspacio;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.color = color;
        this.entrada = entrada;
        this.lavado = lavado;
        this.idEmpleadoG = idEmpleadoG;
    }

    public Integer getIdAutos() {
        return idAutos;
    }

    public void setIdAutos(Integer idAutos) {
        this.idAutos = idAutos;
    }

    public int getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(int idEspacio) {
        this.idEspacio = idEspacio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public int getLavado() {
        return lavado;
    }

    public void setLavado(int lavado) {
        this.lavado = lavado;
    }

    public int getIdEmpleadoG() {
        return idEmpleadoG;
    }

    public void setIdEmpleadoG(int idEmpleadoG) {
        this.idEmpleadoG = idEmpleadoG;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public Double getPago() {
        return pago;
    }

    public void setPago(Double pago) {
        this.pago = pago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutos != null ? idAutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autos)) {
            return false;
        }
        Autos other = (Autos) object;
        if ((this.idAutos == null && other.idAutos != null) || (this.idAutos != null && !this.idAutos.equals(other.idAutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Autos[ idAutos=" + idAutos + " ]";
    }
    
}
