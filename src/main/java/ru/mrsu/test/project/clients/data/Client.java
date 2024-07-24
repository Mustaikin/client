package ru.mrsu.test.project.clients.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PERSONNELNUMBER")
    private String personnelNumber;
    @Column(name = "ADDRESSID")
    private int addressId;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", personnelNumber='" + personnelNumber + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
