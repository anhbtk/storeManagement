package com.store.Store.models;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int Number;
    private String Street;
    private String Postcode;

    public Address() {
    }

    public Address( int number, String street, String postcode) {

        Number = number;
        Street = street;
        Postcode = postcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", Number=" + Number +
                ", Street='" + Street + '\'' +
                ", Postcode='" + Postcode + '\'' +
                '}';
    }
}
