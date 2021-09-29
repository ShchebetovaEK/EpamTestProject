package by.tms.device.entity;

public class Tablet  extends Device{
    private final boolean stilus;


    public Tablet(String name, double weight, long price, boolean stilus) {
        super(name, weight, price);
        this.stilus = stilus;
    }

    public boolean isStilus() {
        return stilus;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "stilus=" + stilus +
                '}';
    }

    @Override
    public DeviceType getType() {
        return DeviceType.tablet;
    }
}
