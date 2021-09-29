package by.tms.device.service;

import by.tms.device.entity.Device;
import by.tms.device.entity.DeviceType;
import by.tms.device.entity.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceCalculation {
    public Map<DeviceType, Long> calculate(List<Employee> employees, List<Device> devices) {
        Map<String, Device> deviceMap = new HashMap<>();
        for (Device device : devices) {
            deviceMap.put(device.getName(), device);
        }
        Map<DeviceType, Long> result = new HashMap<>();
        for (Employee employee : employees) {
            for (String deviceName : employee.getDevices()) {
                Device device = deviceMap.get(deviceName);
                result.put(device.getType(), device.getPrice() + result.getOrDefault(device.getType(), 0L));
            }
        }
        return result;


    }
}
