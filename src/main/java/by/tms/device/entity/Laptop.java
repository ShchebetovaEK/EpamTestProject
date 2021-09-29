package by.tms.device.entity;

public class Laptop  extends  Device{
    private final boolean touchScreen;

    public Laptop(String name, double weight, long price, boolean touchScreen) {
        super(name, weight, price);
        this.touchScreen = touchScreen;
    }

    public boolean isTouchScreen() {
        return touchScreen;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "touchScreen=" + touchScreen +
                '}';
    }

    @Override
    public DeviceType getType() {
        return DeviceType.laptop;
    }
}
