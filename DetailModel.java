package com.training.mvvmretro.model;

public class DetailModel {

     String id;
     String name;
     String website;
     String phone;
     Address address;
     Company company;


    public DetailModel(String id, String name, String website, String phone, Address address, Company company) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.phone = phone;
        this.address = address;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}
