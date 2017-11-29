package com.project.tuyensinhdaihoc.data_access_layer.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Combination {
    private int id;
    private String code;
    private int idSub1;
    private int idSub2;
    private int idSub3;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 256)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "id_sub1", nullable = false)
    public int getIdSub1() {
        return idSub1;
    }

    public void setIdSub1(int idSub1) {
        this.idSub1 = idSub1;
    }

    @Basic
    @Column(name = "id_sub2", nullable = false)
    public int getIdSub2() {
        return idSub2;
    }

    public void setIdSub2(int idSub2) {
        this.idSub2 = idSub2;
    }

    @Basic
    @Column(name = "id_sub3", nullable = false)
    public int getIdSub3() {
        return idSub3;
    }

    public void setIdSub3(int idSub3) {
        this.idSub3 = idSub3;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at", nullable = false)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Combination that = (Combination) o;

        if (id != that.id) return false;
        if (idSub1 != that.idSub1) return false;
        if (idSub2 != that.idSub2) return false;
        if (idSub3 != that.idSub3) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + idSub1;
        result = 31 * result + idSub2;
        result = 31 * result + idSub3;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
