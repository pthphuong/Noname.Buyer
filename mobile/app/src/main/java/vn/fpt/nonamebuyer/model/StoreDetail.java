package vn.fpt.nonamebuyer.model;

import java.math.BigDecimal;
import java.util.Date;

public class StoreDetail {

    private Long id;
    private String giaban_currency;
    private String mavachriengshop;
    private BigDecimal giaban;
    private Date thoigiantao;
    private Date thoigiancapnhat;
    private Long tensanpham_id;
    private Long tenshop_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGiaban_currency() {
        return giaban_currency;
    }

    public void setGiaban_currency(String giaban_currency) {
        this.giaban_currency = giaban_currency;
    }

    public String getMavachriengshop() {
        return mavachriengshop;
    }

    public void setMavachriengshop(String mavachriengshop) {
        this.mavachriengshop = mavachriengshop;
    }

    public BigDecimal getGiaban() {
        return giaban;
    }

    public void setGiaban(BigDecimal giaban) {
        this.giaban = giaban;
    }

    public Date getThoigiantao() {
        return thoigiantao;
    }

    public void setThoigiantao(Date thoigiantao) {
        this.thoigiantao = thoigiantao;
    }

    public Date getThoigiancapnhat() {
        return thoigiancapnhat;
    }

    public void setThoigiancapnhat(Date thoigiancapnhat) {
        this.thoigiancapnhat = thoigiancapnhat;
    }

    public Long getTensanpham_id() {
        return tensanpham_id;
    }

    public void setTensanpham_id(Long tensanpham_id) {
        this.tensanpham_id = tensanpham_id;
    }

    public Long getTenshop_id() {
        return tenshop_id;
    }

    public void setTenshop_id(Long tenshop_id) {
        this.tenshop_id = tenshop_id;
    }
}
