package by.tms.device.parser;

import by.tms.device.entity.*;
import org.w3c.dom.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeInfoParser extends AbstractParser<Employee> {


    public EmployeeInfoParser(String fileName) {
        super(fileName);

    }

    protected List<Employee> collectInformation(Document document) {
        NodeList elements = document.getElementsByTagName("employee");
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < elements.getLength(); i++) {

            Element element = (Element) elements.item(i);
            String firstName = element.getElementsByTagName("firstName").item(0).getTextContent().trim();
            String lastName = element.getElementsByTagName("lastName").item(0).getTextContent().trim();
            List<String> equipments = new ArrayList<>();
            NodeList equipmentElements = element.getElementsByTagName("equipment").item(0).getChildNodes();
            for (int j = 0; j < equipmentElements.getLength(); j++) {
                Node equipmentElement = equipmentElements.item(j);
                if(equipmentElement instanceof Element){
                equipments.add(equipmentElement.getTextContent().trim());}
            }
            employeeList.add(new Employee(firstName, lastName, equipments));
        }
        return employeeList;
    }
}



