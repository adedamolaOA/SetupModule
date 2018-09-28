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
@Table(name = "Property_Item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyItem.findAll", query = "SELECT p FROM PropertyItem p")
    , @NamedQuery(name = "PropertyItem.findByItemId", query = "SELECT p FROM PropertyItem p WHERE p.itemId = :itemId")
    , @NamedQuery(name = "PropertyItem.findByHotelId", query = "SELECT p FROM PropertyItem p WHERE p.hotelId = :hotelId")
    , @NamedQuery(name = "PropertyItem.findByArea", query = "SELECT p FROM PropertyItem p WHERE p.area = :area")
    , @NamedQuery(name = "PropertyItem.findByItemName", query = "SELECT p FROM PropertyItem p WHERE p.itemName = :itemName")
    , @NamedQuery(name = "PropertyItem.findByDateCreated", query = "SELECT p FROM PropertyItem p WHERE p.dateCreated = :dateCreated")
    , @NamedQuery(name = "PropertyItem.findByCreatedBy", query = "SELECT p FROM PropertyItem p WHERE p.createdBy = :createdBy")
    , @NamedQuery(name = "PropertyItem.findByDateUpdated", query = "SELECT p FROM PropertyItem p WHERE p.dateUpdated = :dateUpdated")
    , @NamedQuery(name = "PropertyItem.findByUpdatedBy", query = "SELECT p FROM PropertyItem p WHERE p.updatedBy = :updatedBy")
    , @NamedQuery(name = "PropertyItem.findByReplicationStatus", query = "SELECT p FROM PropertyItem p WHERE p.replicationStatus = :replicationStatus")})
public class PropertyItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Item_Id")
    private Integer itemId;
    @Column(name = "Hotel_Id")
    private String hotelId;
    @Column(name = "area")
    private String area;
    @Column(name = "item_name")
    private String itemName;
    @Lob
    @Column(name = "item_desc")
    private String itemDesc;
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

    public PropertyItem() {
    }

    public PropertyItem(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
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
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PropertyItem)) {
            return false;
        }
        PropertyItem other = (PropertyItem) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ontrac.entities.PropertyItem[ itemId=" + itemId + " ]";
    }
    
}
