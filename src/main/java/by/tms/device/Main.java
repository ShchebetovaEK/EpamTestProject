package by.tms.device;


import by.tms.device.entity.Device;
import by.tms.device.entity.DeviceType;
import by.tms.device.entity.Employee;
import by.tms.device.parser.DeviceInfoParser;
import by.tms.device.parser.EmployeeInfoParser;
import by.tms.device.service.PriceCalculation;
import by.tms.device.service.WeightCalculation;
import by.tms.device.writer.WeightPriceXmlWriter;

import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        DeviceInfoParser deviceInfoParser = new DeviceInfoParser("DeviceInfo.xml");
        List<Device> devices = deviceInfoParser.parse();
        EmployeeInfoParser employeeInfoParser = new EmployeeInfoParser("EmployeeInfo.xml");
        List<Employee> employees = employeeInfoParser.parse();
        PriceCalculation priceCalculation = new PriceCalculation();
        Map<DeviceType, Long> pricees = priceCalculation.calculate(employees, devices);
        WeightCalculation weightCalculation = new WeightCalculation();
        Map<DeviceType, Double> weights = weightCalculation.calculate(employees, devices);
        WeightPriceXmlWriter weightPriceXmlWriter = new WeightPriceXmlWriter("D:\\Result.xml");
        weightPriceXmlWriter.write(weights, pricees);


    }
}
