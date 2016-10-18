package vn.fpt.nonamebuyer.model;

import java.util.Date;

public class StoreInfo {

    private Long id;
    private String tenshop;
    private String tenchushop;
    private String phone;
    private String email;
    private String address;
    private String geolocation;

    private Date thoigiantao;
    private Date thoigiancapnhat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenshop() {
        return tenshop;
    }

    public void setTenshop(String tenshop) {
        this.tenshop = tenshop;
    }

    public String getTenchushop() {
        return tenchushop;
    }

    public void setTenchushop(String tenchushop) {
        this.tenchushop = tenchushop;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
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
}
