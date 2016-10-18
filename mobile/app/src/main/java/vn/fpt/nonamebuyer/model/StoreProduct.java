package vn.fpt.nonamebuyer.model;

import java.math.BigDecimal;

public class StoreProduct {

    private Long id;
    private String tensanpham;
    private String nhomhang;
    private String mavach;
    private BigDecimal gianiemyet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getNhomhang() {
        return nhomhang;
    }

    public void setNhomhang(String nhomhang) {
        this.nhomhang = nhomhang;
    }

    public String getMavach() {
        return mavach;
    }

    public void setMavach(String mavach) {
        this.mavach = mavach;
    }

    public BigDecimal getGianiemyet() {
        return gianiemyet;
    }

    public void setGianiemyet(BigDecimal gianiemyet) {
        this.gianiemyet = gianiemyet;
    }
}
