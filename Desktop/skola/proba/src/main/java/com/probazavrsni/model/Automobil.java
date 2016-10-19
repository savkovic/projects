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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dusan Savkovic
 */
@Entity
@Table(name = "automobili")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Automobil.findAll", query = "SELECT a FROM Automobil a"),
    @NamedQuery(name = "Automobil.findById", query = "SELECT a FROM Automobil a WHERE a.id = :id"),
    @NamedQuery(name = "Automobil.findByMarka", query = "SELECT a FROM Automobil a WHERE a.marka = :marka"),
    @NamedQuery(name = "Automobil.findByCena", query = "SELECT a FROM Automobil a WHERE a.cena = :cena"),
    @NamedQuery(name = "Automobil.findByModel", query = "SELECT a FROM Automobil a WHERE a.model = :model"),
    @NamedQuery(name = "Automobil.findByOpis", query = "SELECT a FROM Automobil a WHERE a.opis = :opis"),
    @NamedQuery(name = "Automobil.findBySlika", query = "SELECT a FROM Automobil a WHERE a.slika = :slika")})
public class Automobil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "marka")
    private Integer marka;
    @Column(name = "cena")
    private Integer cena;
    @Size(max = 256)
    @Column(name = "model")
    private String model;
    @Size(max = 1024)
    @Column(name = "opis")
    private String opis;
    @Size(max = 1024)
    @Column(name = "slika")
    private String slika;

    public Automobil() {
    }

    public Automobil(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMarka() {
        return marka;
    }

    public void setMarka(Integer marka) {
        this.marka = marka;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
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
        if (!(object instanceof Automobil)) {
            return false;
        }
        Automobil other = (Automobil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.probazavrsni.model.Automobil[ id=" + id + " ]";
    }
    
}
