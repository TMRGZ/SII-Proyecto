/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SII.entidades;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author MiguelRuiz
 */
@Entity
@Table(name = "SOCIO", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"USUARIO_NOMBRE_USUARIO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s")
    , @NamedQuery(name = "Socio.findByNumero", query = "SELECT s FROM Socio s WHERE s.numero = :numero")
    , @NamedQuery(name = "Socio.findByNombre", query = "SELECT s FROM Socio s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Socio.findByApellidos", query = "SELECT s FROM Socio s WHERE s.apellidos = :apellidos")
    , @NamedQuery(name = "Socio.findByEstado", query = "SELECT s FROM Socio s WHERE s.estado = :estado")
    , @NamedQuery(name = "Socio.findByNif", query = "SELECT s FROM Socio s WHERE s.nif = :nif")
    , @NamedQuery(name = "Socio.findByDireccion", query = "SELECT s FROM Socio s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Socio.findByPoblacion", query = "SELECT s FROM Socio s WHERE s.poblacion = :poblacion")
    , @NamedQuery(name = "Socio.findByCodigoPostal", query = "SELECT s FROM Socio s WHERE s.codigoPostal = :codigoPostal")
    , @NamedQuery(name = "Socio.findByProvincia", query = "SELECT s FROM Socio s WHERE s.provincia = :provincia")
    , @NamedQuery(name = "Socio.findByTelefono", query = "SELECT s FROM Socio s WHERE s.telefono = :telefono")
    , @NamedQuery(name = "Socio.findByTelefonoMovil", query = "SELECT s FROM Socio s WHERE s.telefonoMovil = :telefonoMovil")
    , @NamedQuery(name = "Socio.findByCorreoElectronico", query = "SELECT s FROM Socio s WHERE s.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "Socio.findByAgente", query = "SELECT s FROM Socio s WHERE s.agente = :agente")
    , @NamedQuery(name = "Socio.findByRelacion", query = "SELECT s FROM Socio s WHERE s.relacion = :relacion")
    , @NamedQuery(name = "Socio.findByCertificado", query = "SELECT s FROM Socio s WHERE s.certificado = :certificado")
    , @NamedQuery(name = "Socio.findBySector", query = "SELECT s FROM Socio s WHERE s.sector = :sector")
    , @NamedQuery(name = "Socio.findByFechaAlta", query = "SELECT s FROM Socio s WHERE s.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "Socio.findByFechaBaja", query = "SELECT s FROM Socio s WHERE s.fechaBaja = :fechaBaja")
    , @NamedQuery(name = "Socio.findByObservaciones", query = "SELECT s FROM Socio s WHERE s.observaciones = :observaciones")})
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO", nullable = false, precision = 0, scale = -127)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 30)
    private String nombre;
    @Column(name = "APELLIDOS", length = 30)
    private String apellidos;
    @Column(name = "ESTADO", length = 30)
    private String estado;
    @Basic(optional = false)
    @Column(name = "NIF", nullable = false, length = 30)
    private String nif;
    @Basic(optional = false)
    @Column(name = "DIRECCION", nullable = false, length = 40)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "POBLACION", nullable = false, length = 40)
    private String poblacion;
    @Basic(optional = false)
    @Column(name = "CODIGO_POSTAL", nullable = false)
    private String codigoPostal;
    @Basic(optional = false)
    @Column(name = "PROVINCIA", nullable = false, length = 30)
    private String provincia;
    @Basic(optional = false)
    @Column(name = "TELEFONO", nullable = false)
    private String telefono;
    @Column(name = "TELEFONO_MOVIL")
    private String telefonoMovil;
    @Basic(optional = false)
    @Column(name = "CORREO_ELECTRONICO", nullable = false, length = 40)
    private String correoElectronico;
    @Column(name = "AGENTE", length = 40)
    private String agente;
    @Column(name = "RELACION", length = 40)
    private String relacion;
    @Column(name = "CERTIFICADO", length = 40)
    private String certificado;
    @Column(name = "SECTOR", length = 40)
    private String sector;
    @Column(name = "FECHA_ALTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "FECHA_BAJA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;
    @Column(name = "OBSERVACIONES", length = 80)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socioNumero")
    private Set<Becado> becadoSet;
    @JoinColumn(name = "USUARIO_NOMBRE_USUARIO", referencedColumnName = "NOMBRE_USUARIO", nullable = false)
    @OneToOne(optional = false)
    private Usuario usuarioNombreUsuario;

    public Socio() {
    }

    public Socio(Long numero) {
        this.numero = numero;
    }

    public Socio(Long numero, String nombre, String nif, String direccion, String poblacion, String codigoPostal, String provincia, String telefono, String correoElectronico) {
        this.numero = numero;
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Set<Becado> getBecadoSet() {
        return becadoSet;
    }

    public void setBecadoSet(Set<Becado> becadoSet) {
        this.becadoSet = becadoSet;
    }

    public Usuario getUsuarioNombreUsuario() {
        return usuarioNombreUsuario;
    }

    public void setUsuarioNombreUsuario(Usuario usuarioNombreUsuario) {
        this.usuarioNombreUsuario = usuarioNombreUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socio)) {
            return false;
        }
        Socio other = (Socio) object;
        return (this.numero != null || other.numero == null) && (this.numero == null || this.numero.equals(other.numero));
    }

    @Override
    public String toString() {
        return "javaapplication2.Socio[ numero=" + numero + " ]";
    }
    
}
