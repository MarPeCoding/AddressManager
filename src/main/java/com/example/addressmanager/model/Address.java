package com.example.addressmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
public class Address {

    // Attribute for primary key of database
    @Id
    @GeneratedValue
    private long id;

    // Further attributes of model class
    private String streetAndNumber;
    private String postcode;
    private String city;

    // Parameterized constructor
    public Address(String streetAndNumber, String postcode, String city){
       this.streetAndNumber = streetAndNumber;
       this.postcode = postcode;
       this.city = city;
    }
}
