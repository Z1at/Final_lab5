import NikandrovLab5.commands.Operations;
import NikandrovLab5.data.City;
import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.TextFormatting;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(TextFormatting.getYellowText("Good morning, Alexander Sergeevich, this is my first time, " +
                "do not judge strictly"));
        System.out.println();
        String environmentVariable = System.getenv("JAVA_HOME");
        Collection collection = new Collection();
        Scanner scanner = new Scanner(System.in);
        Operations operations = new Operations();
        String[] command;
        if (environmentVariable != null) {
            String[] temporary = new String[2];
            temporary[0] = "execute_script";
            temporary[1] = environmentVariable;
            operations.run(temporary, collection, operations, environmentVariable);
            System.out.println(TextFormatting.getYellowText("All operations from the environment variable have been performed"));
            System.out.println();
        } else {
            System.out.println(TextFormatting.getYellowText("The environment variable was not found"));
            System.out.println();
        }
        System.out.println(TextFormatting.getYellowText("I'll do whatever you want, Boss"));
        System.out.println();
        try {
            do {
                command = scanner.nextLine().toLowerCase().trim().split(" ");
                TreeMap<String, City> tree = new TreeMap<>(collection.collection);
                for (String key : tree.keySet()) {
                    collection.collection.put(key, tree.get(key));
                }
            } while (operations.run(command, collection, operations, environmentVariable) != 1);
            System.out.println(TextFormatting.getYellowText("The program is over, I hope you enjoyed it"));
            scanner.close();
        } catch (Exception exception) {
            System.out.println(TextFormatting.getYellowText("The program is over, I hope you enjoyed it"));
        }
    }
}

