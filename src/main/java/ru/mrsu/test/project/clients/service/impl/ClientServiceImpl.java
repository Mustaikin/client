package ru.mrsu.test.project.clients.service.impl;

import org.springframework.stereotype.Service;
import ru.mrsu.test.project.clients.data.Client;
import ru.mrsu.test.project.clients.jpa.ClientRepository;
import ru.mrsu.test.project.clients.service.ClientService;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public List<Client> getClient() {
        List<Client> listClient = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;
        try {
            parser = factory.createXMLStreamReader(new FileInputStream("C:\\Users\\maksi\\OneDrive\\Рабочий стол\\clients\\src\\main\\resources\\client.xml"));
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        }
        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT && parser.getLocalName().equals("client")) {
                    Client client = new Client();
                    client.setId(Integer.parseInt(parser.getAttributeValue(null, "id")));
                    client.setName(parser.getAttributeValue(null, "name"));
                    client.setPersonnelNumber(parser.getAttributeValue(null, "personnelNumber"));
                    client.setAddressId(Integer.parseInt(parser.getAttributeValue(null, "addressId")));
                    listClient.add(client);
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }

        return listClient;
    }

    @Override
    public void setClient() {
        clientRepository.saveAll(getClient());
    }
}
