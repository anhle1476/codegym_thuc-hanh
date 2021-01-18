package com.example.hien_thi_danh_sach_khach_hang;

public class Person {
    private String name;
    private String dob;
    private String address;
    private String img;

    public Person(String name, String dob, String address) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.img = "https://robohash.org/" + name.replaceAll("\\s+", "-") + "?size=50x50";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
