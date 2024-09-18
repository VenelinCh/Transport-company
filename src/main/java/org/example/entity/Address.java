package org.example.entity;

public class Address extends BaseEntity{
    public String country;
    public String city;
    public String district;
    public String other;

    public Address() {
    }

    public Address(String country, String city, String district, String other) {
        this.country = country;
        this.city = city;
        this.district = district;
        this.other = other;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
