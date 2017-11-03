package xyz.lihang.housenet.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/2.
 */
@Entity
@Table(name = "house", schema = "dbo", catalog = "housenet")
public class HouseEntity {
    private int id;
    private Integer userId;
    private Integer typeId;
    private Integer streetId;
    private String title;
    private String description; //详细信息
    private Integer price;
    private Date pubdate;
    private Integer floorage;
    private String contact;

    private UsersEntity usersByUserId;
    private TypeEntity typeByTypeId;
    private StreetEntity streetByStreetId;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "type_id")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "pubdate")
    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    @Basic
    @Column(name = "floorage")
    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }

    @Basic
    @Column(name = "contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "street_id")
    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseEntity that = (HouseEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (pubdate != null ? !pubdate.equals(that.pubdate) : that.pubdate != null) return false;
        if (floorage != null ? !floorage.equals(that.floorage) : that.floorage != null) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        if (streetId != null ? !streetId.equals(that.streetId) : that.streetId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (pubdate != null ? pubdate.hashCode() : 0);
        result = 31 * result + (floorage != null ? floorage.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (streetId != null ? streetId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id" ,insertable = false, updatable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id" ,insertable = false, updatable = false)
    public TypeEntity getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(TypeEntity typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id" ,insertable = false, updatable = false)
    public StreetEntity getStreetByStreetId() {
        return streetByStreetId;
    }

    public void setStreetByStreetId(StreetEntity streetByStreetId) {
        this.streetByStreetId = streetByStreetId;
    }
}
