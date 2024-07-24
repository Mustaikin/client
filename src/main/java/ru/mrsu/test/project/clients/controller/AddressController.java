package ru.mrsu.test.project.clients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mrsu.test.project.clients.data.Address;
import ru.mrsu.test.project.clients.service.AddressService;

import java.util.List;

@RestController
public class AddressController {
    private final AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping("internal/address")
    public List<Address> getAddresses(){
        return addressService.getAddresses();
    }
}
