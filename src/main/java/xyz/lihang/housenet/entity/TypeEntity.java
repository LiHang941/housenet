package xyz.lihang.housenet.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 2017/11/2.
 */
@Entity
@Table(name = "type", schema = "dbo", catalog = "housenet")
public class TypeEntity {
    private int id;
    private String name;
    private int money;

    private Collection<HouseEntity> housesById;

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
    @Column(name = "money")
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeEntity that = (TypeEntity) o;

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

    @OneToMany(mappedBy = "typeByTypeId")
    public Collection<HouseEntity> getHousesById() {
        return housesById;
    }

    public void setHousesById(Collection<HouseEntity> housesById) {
        this.housesById = housesById;
    }
}
