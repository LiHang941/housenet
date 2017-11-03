package xyz.lihang.housenet.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 2017/11/2.
 */
@Entity
@Table(name = "street", schema = "dbo", catalog = "housenet")
public class StreetEntity {
    private int id;
    private String name;
    private Integer districtId;
    private Collection<HouseEntity> housesById;
    private DistrictEntity districtByDistrictId;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "district_id")
    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StreetEntity that = (StreetEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (districtId != null ? !districtId.equals(that.districtId) : that.districtId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (districtId != null ? districtId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "streetByStreetId")
    public Collection<HouseEntity> getHousesById() {
        return housesById;
    }

    public void setHousesById(Collection<HouseEntity> housesById) {
        this.housesById = housesById;
    }

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id" ,insertable = false, updatable = false)
    public DistrictEntity getDistrictByDistrictId() {
        return districtByDistrictId;
    }

    public void setDistrictByDistrictId(DistrictEntity districtByDistrictId) {
        this.districtByDistrictId = districtByDistrictId;
    }
}
