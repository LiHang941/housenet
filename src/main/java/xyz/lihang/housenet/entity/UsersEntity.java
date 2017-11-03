package xyz.lihang.housenet.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 2017/11/2.
 */
@Entity
@Table(name = "users", schema = "dbo", catalog = "housenet")
public class UsersEntity {
    private int id;
    private String name;
    private String password;
    private String telephone;
    private String username;
    private String isadmin;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "isadmin")
    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (isadmin != null ? !isadmin.equals(that.isadmin) : that.isadmin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (isadmin != null ? isadmin.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<HouseEntity> getHousesById() {
        return housesById;
    }

    public void setHousesById(Collection<HouseEntity> housesById) {
        this.housesById = housesById;
    }
}
