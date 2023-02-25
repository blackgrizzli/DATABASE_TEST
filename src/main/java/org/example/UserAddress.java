package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
class UserAddress
{
    @Column(name="user_address_country")
    public String country;

    public UserAddress(String country, String city, String street, String home) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.home = home;
    }

    @Column(name="user_address_city")
    public String city;
    @Column(name="user_address_street")
    public String street;
    @Column(name="user_address_home")
    public String home;

    public UserAddress() {

    }
}
