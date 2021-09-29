package by.tms.device.service;

import by.tms.device.entity.Device;
import by.tms.device.entity.DeviceType;
import by.tms.device.entity.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightCalculation {
    public Map<DeviceType, Double> calculate(List<Employee> employees, List<Device> devices) {
        Map<String, Device> deviceMap = new HashMap<>();
        for (Device device : devices) {
            deviceMap.put(device.getName(), device);
        }
        Map<DeviceType, Double> result = new HashMap<>();
        for (Employee employee : employees) {
            for (String deviceName : employee.getDevices()) {
                Device device = deviceMap.get(deviceName);
                result.put(device.getType(), device.getWeight() + result.getOrDefault(device.getType(), 0.));
            }
        }
        return result;


    }
}
