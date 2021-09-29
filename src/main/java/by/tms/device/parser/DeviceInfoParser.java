package by.tms.device.parser;

import by.tms.device.entity.*;
import org.w3c.dom.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceInfoParser extends AbstractParser<Device> {

    public DeviceInfoParser(String fileName) {
        super(fileName);
    }

    protected List<Device> collectInformation(Document document) {
        NodeList elements = document.getElementsByTagName("device");
        List<Device> deviceList = new ArrayList<>();
        for (int i = 0; i < elements.getLength(); i++) {

            Element element = (Element) elements.item(i);
            NamedNodeMap attributes = elements.item(i).getAttributes();
            String name = attributes.getNamedItem("name").getNodeValue();
            String weight = element.getElementsByTagName("weight").item(0).getTextContent().trim();
            String price = element.getElementsByTagName("price").item(0).getTextContent().trim();
            String type = element.getElementsByTagName("type").item(0).getTextContent().trim();

            switch(DeviceType.valueOf(type)) {
                case phone:
                    String sim = element.getElementsByTagName("sim").item(0).getTextContent().trim();
                    deviceList.add(new Phone(name, Double.parseDouble(weight), Long.parseLong(price), Integer.parseInt(sim)));
                    break;
                case laptop:
                    String touchScreen = element.getElementsByTagName("touchScreen").item(0).getTextContent().trim();
                    ;
                    deviceList.add(new Laptop(name, Double.parseDouble(weight), Long.parseLong(price), Boolean.parseBoolean(touchScreen)));
                    break;
                case reader:
                    String button = element.getElementsByTagName("button").item(0).getTextContent().trim();
                    deviceList.add(new Reader(name, Double.parseDouble(weight), Long.parseLong(price), Integer.parseInt(button)));
                    break;
                case tablet:
                    String stilus = element.getElementsByTagName("stilus").item(0).getTextContent().trim();
                    deviceList.add(new Tablet(name, Double.parseDouble(weight), Long.parseLong(price), Boolean.parseBoolean(stilus)));
                    break;
            }
        }
        return deviceList;
    }
}


