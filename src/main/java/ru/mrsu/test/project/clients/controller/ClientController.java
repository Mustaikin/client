package ru.mrsu.test.project.clients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mrsu.test.project.clients.data.Client;
import ru.mrsu.test.project.clients.service.ClientService;

import java.util.List;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("internal/client")
    public List<Client> getClients() {
        return clientService.getClient();
    }
    @PostMapping("/internal/client/setDataBase")
    public void setClientDataBase() {
        clientService.setClient();
    }
}
