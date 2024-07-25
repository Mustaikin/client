package ru.mrsu.test.project.clients.data;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @Column(name = "ID")
    private int ID;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSE")
    private int house;
    @Column(name = "FLOOR")
    private int floor;
    @Column(name = "FLATNUMBER")
    private int flatNumber;
}
