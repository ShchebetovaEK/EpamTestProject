package by.tms.device.entity;

public class Phone extends Device{
    private final int sim;

    public Phone(String name, double weight, long price, int sim) {
        super(name, weight, price);
        this.sim = sim;
    }

    public int getSim() {
        return sim;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "sim=" + sim +
                '}';
    }

    @Override
    public DeviceType getType() {
        return DeviceType.phone;
    }
}
