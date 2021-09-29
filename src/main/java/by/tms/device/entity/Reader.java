package by.tms.device.entity;

public class Reader extends Device{
 private final int button;


    public Reader(String name, double weight, long price, int button) {
        super(name, weight, price);
        this.button = button;
    }

    public int getButton() {
        return button;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "button=" + button +
                '}';
    }

    @Override
    public DeviceType getType() {
        return DeviceType.reader;
    }
}
