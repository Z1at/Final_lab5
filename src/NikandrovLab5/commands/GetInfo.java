package NikandrovLab5.commands;

import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.TextFormatting;

public class GetInfo {
    public void getInfo(Collection collection, String initTime) {
        System.out.println(TextFormatting.getGreenText("Information about collection:"));
        System.out.println(TextFormatting.getBlueText("Type of collection: " + "LinkedHashMap" + "\n" +
                "Type of collection items: " + "Cities" + "\n" +
                "Initialization date: " + initTime + "\n" +
                "Number of items in the collection: " + collection.collection.size()));
        System.out.println();
    }
}
