package by.tms.device.writer;

import by.tms.device.entity.DeviceType;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

public class WeightPriceXmlWriter {
    private final String fileName;

    public WeightPriceXmlWriter(String fileName) {
        this.fileName = fileName;
    }

    public void write(Map<DeviceType, Double> weightMap, Map<DeviceType, Long> priceMap) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            bufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            bufferedWriter.newLine();
            bufferedWriter.write("<list>");
            bufferedWriter.newLine();
            for (DeviceType type : DeviceType.values()) {
                bufferedWriter.write("<deviceType name = \"" + type + "\">");
                bufferedWriter.newLine();
                bufferedWriter.write("<weight> " + weightMap.getOrDefault(type, 0.) + "</weight> ");
                bufferedWriter.newLine();
                bufferedWriter.write("<price>" + priceMap.getOrDefault(type, 0L) + "</price>");
                bufferedWriter.newLine();
                bufferedWriter.write("</deviceType>");
                bufferedWriter.newLine();
            }
            bufferedWriter.write("</list>");



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
