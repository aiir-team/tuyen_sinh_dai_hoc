package com.project.tuyensinhdaihoc.data_access_layer.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "universal_point", schema = "tsdh", catalog = "")
public class UniversalPoint {
    private int id;
    private String blockName;
    private int less1;
    private int less2;
    private int less3;
    private int less4;
    private int less5;
    private int less6;
    private int less7;
    private int less8;
    private int less9;
    private int less10;
    private int less11;
    private int less12;
    private int less13;
    private int less14;
    private int less15;
    private int less16;
    private int less17;
    private int less18;
    private int less19;
    private int less20;
    private int less21;
    private int less22;
    private int less23;
    private int less24;
    private int less25;
    private int less26;
    private int less27;
    private int less28;
    private int less29;
    private int less30;
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
    @Column(name = "block_name", nullable = false, length = 64)
    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    @Basic
    @Column(name = "less1", nullable = false)
    public int getLess1() {
        return less1;
    }

    public void setLess1(int less1) {
        this.less1 = less1;
    }

    @Basic
    @Column(name = "less2", nullable = false)
    public int getLess2() {
        return less2;
    }

    public void setLess2(int less2) {
        this.less2 = less2;
    }

    @Basic
    @Column(name = "less3", nullable = false)
    public int getLess3() {
        return less3;
    }

    public void setLess3(int less3) {
        this.less3 = less3;
    }

    @Basic
    @Column(name = "less4", nullable = false)
    public int getLess4() {
        return less4;
    }

    public void setLess4(int less4) {
        this.less4 = less4;
    }

    @Basic
    @Column(name = "less5", nullable = false)
    public int getLess5() {
        return less5;
    }

    public void setLess5(int less5) {
        this.less5 = less5;
    }

    @Basic
    @Column(name = "less6", nullable = false)
    public int getLess6() {
        return less6;
    }

    public void setLess6(int less6) {
        this.less6 = less6;
    }

    @Basic
    @Column(name = "less7", nullable = false)
    public int getLess7() {
        return less7;
    }

    public void setLess7(int less7) {
        this.less7 = less7;
    }

    @Basic
    @Column(name = "less8", nullable = false)
    public int getLess8() {
        return less8;
    }

    public void setLess8(int less8) {
        this.less8 = less8;
    }

    @Basic
    @Column(name = "less9", nullable = false)
    public int getLess9() {
        return less9;
    }

    public void setLess9(int less9) {
        this.less9 = less9;
    }

    @Basic
    @Column(name = "less10", nullable = false)
    public int getLess10() {
        return less10;
    }

    public void setLess10(int less10) {
        this.less10 = less10;
    }

    @Basic
    @Column(name = "less11", nullable = false)
    public int getLess11() {
        return less11;
    }

    public void setLess11(int less11) {
        this.less11 = less11;
    }

    @Basic
    @Column(name = "less12", nullable = false)
    public int getLess12() {
        return less12;
    }

    public void setLess12(int less12) {
        this.less12 = less12;
    }

    @Basic
    @Column(name = "less13", nullable = false)
    public int getLess13() {
        return less13;
    }

    public void setLess13(int less13) {
        this.less13 = less13;
    }

    @Basic
    @Column(name = "less14", nullable = false)
    public int getLess14() {
        return less14;
    }

    public void setLess14(int less14) {
        this.less14 = less14;
    }

    @Basic
    @Column(name = "less15", nullable = false)
    public int getLess15() {
        return less15;
    }

    public void setLess15(int less15) {
        this.less15 = less15;
    }

    @Basic
    @Column(name = "less16", nullable = false)
    public int getLess16() {
        return less16;
    }

    public void setLess16(int less16) {
        this.less16 = less16;
    }

    @Basic
    @Column(name = "less17", nullable = false)
    public int getLess17() {
        return less17;
    }

    public void setLess17(int less17) {
        this.less17 = less17;
    }

    @Basic
    @Column(name = "less18", nullable = false)
    public int getLess18() {
        return less18;
    }

    public void setLess18(int less18) {
        this.less18 = less18;
    }

    @Basic
    @Column(name = "less19", nullable = false)
    public int getLess19() {
        return less19;
    }

    public void setLess19(int less19) {
        this.less19 = less19;
    }

    @Basic
    @Column(name = "less20", nullable = false)
    public int getLess20() {
        return less20;
    }

    public void setLess20(int less20) {
        this.less20 = less20;
    }

    @Basic
    @Column(name = "less21", nullable = false)
    public int getLess21() {
        return less21;
    }

    public void setLess21(int less21) {
        this.less21 = less21;
    }

    @Basic
    @Column(name = "less22", nullable = false)
    public int getLess22() {
        return less22;
    }

    public void setLess22(int less22) {
        this.less22 = less22;
    }

    @Basic
    @Column(name = "less23", nullable = false)
    public int getLess23() {
        return less23;
    }

    public void setLess23(int less23) {
        this.less23 = less23;
    }

    @Basic
    @Column(name = "less24", nullable = false)
    public int getLess24() {
        return less24;
    }

    public void setLess24(int less24) {
        this.less24 = less24;
    }

    @Basic
    @Column(name = "less25", nullable = false)
    public int getLess25() {
        return less25;
    }

    public void setLess25(int less25) {
        this.less25 = less25;
    }

    @Basic
    @Column(name = "less26", nullable = false)
    public int getLess26() {
        return less26;
    }

    public void setLess26(int less26) {
        this.less26 = less26;
    }

    @Basic
    @Column(name = "less27", nullable = false)
    public int getLess27() {
        return less27;
    }

    public void setLess27(int less27) {
        this.less27 = less27;
    }

    @Basic
    @Column(name = "less28", nullable = false)
    public int getLess28() {
        return less28;
    }

    public void setLess28(int less28) {
        this.less28 = less28;
    }

    @Basic
    @Column(name = "less29", nullable = false)
    public int getLess29() {
        return less29;
    }

    public void setLess29(int less29) {
        this.less29 = less29;
    }

    @Basic
    @Column(name = "less30", nullable = false)
    public int getLess30() {
        return less30;
    }

    public void setLess30(int less30) {
        this.less30 = less30;
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

        UniversalPoint that = (UniversalPoint) o;

        if (id != that.id) return false;
        if (less1 != that.less1) return false;
        if (less2 != that.less2) return false;
        if (less3 != that.less3) return false;
        if (less4 != that.less4) return false;
        if (less5 != that.less5) return false;
        if (less6 != that.less6) return false;
        if (less7 != that.less7) return false;
        if (less8 != that.less8) return false;
        if (less9 != that.less9) return false;
        if (less10 != that.less10) return false;
        if (less11 != that.less11) return false;
        if (less12 != that.less12) return false;
        if (less13 != that.less13) return false;
        if (less14 != that.less14) return false;
        if (less15 != that.less15) return false;
        if (less16 != that.less16) return false;
        if (less17 != that.less17) return false;
        if (less18 != that.less18) return false;
        if (less19 != that.less19) return false;
        if (less20 != that.less20) return false;
        if (less21 != that.less21) return false;
        if (less22 != that.less22) return false;
        if (less23 != that.less23) return false;
        if (less24 != that.less24) return false;
        if (less25 != that.less25) return false;
        if (less26 != that.less26) return false;
        if (less27 != that.less27) return false;
        if (less28 != that.less28) return false;
        if (less29 != that.less29) return false;
        if (less30 != that.less30) return false;
        if (blockName != null ? !blockName.equals(that.blockName) : that.blockName != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (blockName != null ? blockName.hashCode() : 0);
        result = 31 * result + less1;
        result = 31 * result + less2;
        result = 31 * result + less3;
        result = 31 * result + less4;
        result = 31 * result + less5;
        result = 31 * result + less6;
        result = 31 * result + less7;
        result = 31 * result + less8;
        result = 31 * result + less9;
        result = 31 * result + less10;
        result = 31 * result + less11;
        result = 31 * result + less12;
        result = 31 * result + less13;
        result = 31 * result + less14;
        result = 31 * result + less15;
        result = 31 * result + less16;
        result = 31 * result + less17;
        result = 31 * result + less18;
        result = 31 * result + less19;
        result = 31 * result + less20;
        result = 31 * result + less21;
        result = 31 * result + less22;
        result = 31 * result + less23;
        result = 31 * result + less24;
        result = 31 * result + less25;
        result = 31 * result + less26;
        result = 31 * result + less27;
        result = 31 * result + less28;
        result = 31 * result + less29;
        result = 31 * result + less30;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
