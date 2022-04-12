package NikandrovLab5.commands;

import NikandrovLab5.data.City;
import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.TextFormatting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Save {
    public void save(String path, Collection collection) {
        try {
            FileOutputStream file = new FileOutputStream(path + ".csv");
            OutputStreamWriter writer = new OutputStreamWriter(file);
            writer.write("key" + "," + "id" + "," + "name" + "," + "coordinates" + "," + "creation date" + "," +
                    "area" + "," + "population" + "," + "meters above sea level" + "," + "climate" + "," +
                    "government" + "," + "standard of living" + "," + "governor(name. height. birthday)" + "\n");
            for (String key : collection.collection.keySet()) {
                City city = collection.collection.get(key);
                writer.write(key + ',' + city.getId() + "," + city.getName() + "," + "(" + city.getCoordinates().getX()
                        + "; " + city.getCoordinates().getY() + ")" + "," +
                        city.getCreationDate() + "," + city.getArea() + "," + city.getPopulation() + "," +
                        city.getMetersAboveSeaLevel() + "," + city.getClimate() + "," + city.getGovernment() + "," +
                        city.getStandardOfLiving() + "," + city.getGovernor().getName() + ". " +
                        city.getGovernor().getHeight() + ". " + city.getGovernor().getBirthday() + "\n");
            }

            writer.close();
            System.out.println(TextFormatting.getGreenText("The file was saved successfully"));
        } catch (IOException exception) {
            System.out.println(TextFormatting.getRedText("If you have a file open with the path you specified, " +
                    "then close it and repeat the command"));
        }
        System.out.println();
    }
}
