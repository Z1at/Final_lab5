package NikandrovLab5.commands;

import NikandrovLab5.data.*;
import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.FieldReceiver;
import NikandrovLab5.utility.TextFormatting;

import java.util.Scanner;

public class UpdateId {
    public void updateId(int id, Collection collection) {
        String copyKey = "";
        for (String key : collection.collection.keySet()) {
            if (collection.collection.get(key).getId() == id) {
                copyKey = key;
                break;
            }
        }
        if (copyKey.equals("")) {
            System.out.println(TextFormatting.getRedText("There is no such id"));
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println(TextFormatting.getGreenText("Enter the name of the field you want to change, " +
                    "Or type 'complete' if you want to complete the operations"));
            while (true) {
                String[] string = scanner.nextLine().trim().split(" ");
                StringBuilder concatenation = new StringBuilder();
                for (String s : string) {
                    concatenation.append(s);
                }
                boolean f = false;
                switch (concatenation.toString()) {
                    case "name": {
                        String name = FieldReceiver.getName();
                        collection.collection.get(copyKey).setName(name);
                        break;
                    }
                    case "coordinates": {
                        Coordinates coordinates = FieldReceiver.getCoordinates();
                        collection.collection.get(copyKey).setCoordinates(coordinates);
                        break;
                    }
                    case "area": {
                        double area = FieldReceiver.getArea();
                        collection.collection.get(copyKey).setArea(area);
                        break;
                    }
                    case "population": {
                        Long population = FieldReceiver.getPopulation();
                        collection.collection.get(copyKey).setPopulation(population);
                        break;
                    }
                    case "metersabvovesealevel": {
                        Integer metersAboveSeaLevel = FieldReceiver.getMetersAboveSeaLevel();
                        collection.collection.get(copyKey).setMetersAboveSeaLevel(metersAboveSeaLevel);
                        break;
                    }
                    case "climate": {
                        Climate climate = FieldReceiver.getClimate();
                        collection.collection.get(copyKey).setClimate(climate);
                        break;
                    }
                    case "government": {
                        Government government = FieldReceiver.getGovernment();
                        collection.collection.get(copyKey).setGovernment(government);
                        break;
                    }
                    case "standardofliving": {
                        StandardOfLiving standardOfLiving = FieldReceiver.getStandardOfLiving();
                        collection.collection.get(copyKey).setStandardOfLiving(standardOfLiving);
                        break;
                    }
                    case "governor": {
                        Human governor = FieldReceiver.getGovernor();
                        collection.collection.get(copyKey).setGovernor(governor);
                        break;
                    }
                    case "complete": {
                        System.out.println(TextFormatting.getGreenText("You have exited the method of adding elements"));
                        System.out.println();
                        return;
                    }
                    default:
                        f = true;
                }
                if (f) {
                    System.out.println(TextFormatting.getRedText("There is no such field, enter again:"));
                } else {
                    System.out.println(TextFormatting.getGreenText("Element replaced"));
                }
                System.out.println(TextFormatting.getGreenText("Enter the name of the field you want to change, " +
                        "Or type 'complete' if you want to complete the operations"));
            }
        }
        System.out.println();
    }
}
