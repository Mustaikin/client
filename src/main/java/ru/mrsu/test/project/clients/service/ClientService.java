package ru.mrsu.test.project.clients.service;

import org.springframework.stereotype.Service;
import ru.mrsu.test.project.clients.data.Client;
import java.util.List;

public interface ClientService {
    public List<Client> getClient();
}
