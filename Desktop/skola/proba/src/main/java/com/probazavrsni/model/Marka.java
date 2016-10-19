/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.probazavrsni.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dusan Savkovic
 */
@Entity
@Table(name = "marka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marka.findAll", query = "SELECT m FROM Marka m"),
    @NamedQuery(name = "Marka.findById", query = "SELECT m FROM Marka m WHERE m.id = :id"),
    @NamedQuery(name = "Marka.findByIme", query = "SELECT m FROM Marka m WHERE m.ime = :ime"),
    @NamedQuery(name = "Marka.findByOpis", query = "SELECT m FROM Marka m WHERE m.opis = :opis")})
public class Marka implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 1024)
    @Column(name = "opis")
    private String opis;

    public Marka() {
    }

    public Marka(Integer id) {
        this.id = id;
    }

    public Marka(Integer id, String ime, String opis) {
        this.id = id;
        this.ime = ime;
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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
        if (!(object instanceof Marka)) {
            return false;
        }
        Marka other = (Marka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.probazavrsni.model.Marka[ id=" + id + " ]";
    }
    
}
