package com.supi.mh.entity.pojo;

import java.io.Serializable;

public class OrganizationHospital implements Serializable {
    private Integer hospitalId;

    private String hospitalName;

    private String hospitalPhone;

    private String hospitalAddressCountry;

    private String hospitalAddressProvince;

    private String hospitalAddressCity;

    private String hospitalAddressDistrict;

    private String hospitalAddressStreet;

    private String hospitalAddressMore;

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalPhone() {
        return hospitalPhone;
    }

    public void setHospitalPhone(String hospitalPhone) {
        this.hospitalPhone = hospitalPhone;
    }

    public String getHospitalAddressCountry() {
        return hospitalAddressCountry;
    }

    public void setHospitalAddressCountry(String hospitalAddressCountry) {
        this.hospitalAddressCountry = hospitalAddressCountry;
    }

    public String getHospitalAddressProvince() {
        return hospitalAddressProvince;
    }

    public void setHospitalAddressProvince(String hospitalAddressProvince) {
        this.hospitalAddressProvince = hospitalAddressProvince;
    }

    public String getHospitalAddressCity() {
        return hospitalAddressCity;
    }

    public void setHospitalAddressCity(String hospitalAddressCity) {
        this.hospitalAddressCity = hospitalAddressCity;
    }

    public String getHospitalAddressDistrict() {
        return hospitalAddressDistrict;
    }

    public void setHospitalAddressDistrict(String hospitalAddressDistrict) {
        this.hospitalAddressDistrict = hospitalAddressDistrict;
    }

    public String getHospitalAddressStreet() {
        return hospitalAddressStreet;
    }

    public void setHospitalAddressStreet(String hospitalAddressStreet) {
        this.hospitalAddressStreet = hospitalAddressStreet;
    }

    public String getHospitalAddressMore() {
        return hospitalAddressMore;
    }

    public void setHospitalAddressMore(String hospitalAddressMore) {
        this.hospitalAddressMore = hospitalAddressMore;
    }
}