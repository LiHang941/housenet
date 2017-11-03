package xyz.lihang.housenet.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 2017/11/2.
 */
@Entity
@Table(name = "district", schema = "dbo", catalog = "housenet")
public class DistrictEntity {
    private int id;
    private String name;
    private Collection<StreetEntity> streetsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DistrictEntity that = (DistrictEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "districtByDistrictId")
    public Collection<StreetEntity> getStreetsById() {
        return streetsById;
    }

    public void setStreetsById(Collection<StreetEntity> streetsById) {
        this.streetsById = streetsById;
    }
}
