package ru.mrsu.test.project.clients.data;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private int ID;
    private String city;
    private String street;
    private int house;
    private int floor;
    private int flatNumber;
}
