package by.tms.device.entity;

import java.util.List;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final List <String> devices;

    public Employee(String firstName, String lastName, List<String> devices) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.devices = devices;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getDevices() {
        return devices;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", devices=" + devices +
                '}';
    }
}
