package ru.mrsu.test.project.clients.service.impl;

import org.springframework.stereotype.Service;
import ru.mrsu.test.project.clients.data.Address;
import ru.mrsu.test.project.clients.service.AddressService;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Service
public class AddressesServiceImpl implements AddressService {
    @Override
    public List<Address> getAddresses() {
        List<Address> ListAddress = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;

        try {
            parser = factory.createXMLStreamReader(new FileInputStream("C:\\Users\\maksi\\OneDrive\\Рабочий стол\\clients\\src\\main\\resources\\address.xml"));
        } catch (FileNotFoundException e) {
            System.out.println("Check File Path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }

        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT && parser.getLocalName().equals("address")) {
                    Address address = new Address();
                    address.setID(Integer.parseInt(parser.getAttributeValue(null, "id")));
                    address.setCity(parser.getAttributeValue(null, "city"));
                    address.setStreet(parser.getAttributeValue(null, "street"));
                    address.setHouse(Integer.parseInt(parser.getAttributeValue(null, "house")));
                    address.setFloor(Integer.parseInt(parser.getAttributeValue(null, "floor")));
                    address.setFlatNumber(Integer.parseInt(parser.getAttributeValue(null, "flatNumber")));
                    ListAddress.add(address);
                }
            }
        } catch (XMLStreamException e) {
            System.out.println("Error Parsing");
        }
        return ListAddress;
    }

}
