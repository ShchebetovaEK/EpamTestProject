package by.tms.device.entity;

public abstract class Device {
    private final String name;
    private final double weight;
    private final long price;

    public Device(String name, double weight, long price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public long getPrice() {
        return price;
    }

    public abstract DeviceType getType();
}
