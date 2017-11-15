package com.itechart.domain;


import java.util.Date;

public class UserEntity {

    private String firtstname;
    private String lastname;
    private String middlename;
    private Date birthday;
    private String email;
    private String city;
    private String street;
    private String house;
    private int apartment;
    private Enum role;
    private String login;
    private String password;
    private String passport;

    public UserEntity() {
    }

    public UserEntity(String firtstname, String lastname, String middlename, Date birthday, String email, String city, String street, String house, int apartment, Enum role, String login, String password, String passport) {
        this.firtstname = firtstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthday = birthday;
        this.email = email;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.role = role;
        this.login = login;
        this.password = password;
        this.passport = passport;
    }

    public String getFirtstname() {
        return firtstname;
    }

    public void setFirtstname(String firtstname) {
        this.firtstname = firtstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public Enum getRole() {
        return role;
    }

    public void setRole(Enum role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (apartment != that.apartment) return false;
        if (firtstname != null ? !firtstname.equals(that.firtstname) : that.firtstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (house != null ? !house.equals(that.house) : that.house != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        return passport != null ? passport.equals(that.passport) : that.passport == null;
    }

    @Override
    public int hashCode() {
        int result = firtstname != null ? firtstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        result = 31 * result + apartment;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
            "firtstname='" + firtstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", middlename='" + middlename + '\'' +
            ", birthday=" + birthday +
            ", email='" + email + '\'' +
            ", city='" + city + '\'' +
            ", street='" + street + '\'' +
            ", house='" + house + '\'' +
            ", apartment=" + apartment +
            ", role=" + role +
            ", login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", passport='" + passport + '\'' +
            '}';
    }
}
