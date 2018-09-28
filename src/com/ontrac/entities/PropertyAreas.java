/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ontrac.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adedamola
 */
@Entity
@Table(name = "Property_Areas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyAreas.findAll", query = "SELECT p FROM PropertyAreas p")
    , @NamedQuery(name = "PropertyAreas.findByAreaid", query = "SELECT p FROM PropertyAreas p WHERE p.areaid = :areaid")
    , @NamedQuery(name = "PropertyAreas.findByHotelId", query = "SELECT p FROM PropertyAreas p WHERE p.hotelId = :hotelId")
    , @NamedQuery(name = "PropertyAreas.findByAreaname", query = "SELECT p FROM PropertyAreas p WHERE p.areaname = :areaname")
    , @NamedQuery(name = "PropertyAreas.findByDateCreated", query = "SELECT p FROM PropertyAreas p WHERE p.dateCreated = :dateCreated")
    , @NamedQuery(name = "PropertyAreas.findByCreatedBy", query = "SELECT p FROM PropertyAreas p WHERE p.createdBy = :createdBy")
    , @NamedQuery(name = "PropertyAreas.findByDateUpdated", query = "SELECT p FROM PropertyAreas p WHERE p.dateUpdated = :dateUpdated")
    , @NamedQuery(name = "PropertyAreas.findByUpdatedBy", query = "SELECT p FROM PropertyAreas p WHERE p.updatedBy = :updatedBy")
    , @NamedQuery(name = "PropertyAreas.findByReplicationStatus", query = "SELECT p FROM PropertyAreas p WHERE p.replicationStatus = :replicationStatus")})
public class PropertyAreas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Area_id")
    private Integer areaid;
    @Column(name = "Hotel_Id")
    private String hotelId;
    @Column(name = "Area_name")
    private String areaname;
    @Lob
    @Column(name = "Area_desc")
    private String areadesc;
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "date_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "replication_status")
    private Boolean replicationStatus;

    public PropertyAreas() {
    }

    public PropertyAreas(Integer areaid) {
        this.areaid = areaid;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getAreadesc() {
        return areadesc;
    }

    public void setAreadesc(String areadesc) {
        this.areadesc = areadesc;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Boolean getReplicationStatus() {
        return replicationStatus;
    }

    public void setReplicationStatus(Boolean replicationStatus) {
        this.replicationStatus = replicationStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaid != null ? areaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PropertyAreas)) {
            return false;
        }
        PropertyAreas other = (PropertyAreas) object;
        if ((this.areaid == null && other.areaid != null) || (this.areaid != null && !this.areaid.equals(other.areaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ontrac.entities.PropertyAreas[ areaid=" + areaid + " ]";
    }
    
}
