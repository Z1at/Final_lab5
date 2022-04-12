package NikandrovLab5.commands;

import NikandrovLab5.data.Government;
import NikandrovLab5.data.Human;
import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.TextFormatting;

import java.util.ArrayList;

/**
 * A class for overriding an operation to the desired thread
 */
public class Operations {
    public ArrayList<String> paths = new ArrayList<>();

    //0 - ok, 1 - exit, 2 - same path again, 3 - error in file
    public int run(String[] command, Collection collection, Operations operations, String environmentVariable) {
        ExecuteScript executeScript = new ExecuteScript();
        if (command[0].equals("help") & command.length == 1) {
            Help.create(Help.vocabulary.size());
            Help.help();
        } else if (command[0].equals("info") & command.length == 1) {
            GetInfo getInfo = new GetInfo();
            getInfo.getInfo(collection, collection.initTime);
        } else if (command[0].equals("show") & command.length == 1) {
            Show show = new Show();
            show.show(collection);
        } else if (command[0].equals("insert") & command.length == 2) {
            if (command[1].contains(",")) {
                System.out.println(TextFormatting.getRedText("There can be no commas in the key"));
            } else {
                InsertKey insert = new InsertKey();
                insert.insert(command[1], collection);
            }
        } else if (command[0].equals("update") & command.length == 2) {
            try {
                UpdateId updateId = new UpdateId();
                updateId.updateId(Integer.parseInt(command[1]), collection);
            } catch (NumberFormatException exception) {
                System.out.println(TextFormatting.getRedText("No such id"));
            }
        } else if (command[0].equals("remove_key") & command.length == 2) {
            RemoveKey removeKey = new RemoveKey();
            removeKey.removeKey(command[1], collection);
        } else if (command[0].equals("clear") & command.length == 1) {
            Clear clear = new Clear();
            clear.clear(collection);
        } else if (command[0].equals("save") & command.length == 1) {
            Save save = new Save();
            save.save(environmentVariable, collection);
        } else if (command[0].equals("execute_script") & command.length == 2) {
            executeScript = new ExecuteScript();
            int result = executeScript.checkingTheCycle(command[1], operations);
            if (result == 2) {
                return 2;
            } else {
                int verdict = executeScript.executeScript(command[1], collection, operations, environmentVariable);
                if (verdict == 2) {
                    return 2;
                }
                operations.paths.remove(operations.paths.size() - 1);
            }
            if (operations.paths.size() == 0) {
                System.out.println(TextFormatting.getGreenText("All commands were executed"));
                System.out.println();
            }
        } else if (command[0].equals("remove_greater") & command.length == 2) {
            RemoveGreater removeGreater = new RemoveGreater();
            removeGreater.removeGreater(collection, command[1]);
        } else if (command[0].equals("remove_lower") & command.length == 2) {
            RemoveLower removeLower = new RemoveLower();
            removeLower.removeLower(collection, command[1]);
        } else if (command[0].equals("remove_greater_key") & command.length == 2) {
            RemoveGreaterKey removeGreaterKey = new RemoveGreaterKey();
            removeGreaterKey.removeGreaterKey(command[1], collection);
        } else if (command[0].equals("remove_any_by_governor") & command.length == 3) {
            try {
                RemoveAnyByGovernor removeAnyByGovernor = new RemoveAnyByGovernor();
                removeAnyByGovernor.removeAnyByGovernor(new Human(command[1], Double.parseDouble(command[2])), collection);
            } catch (NumberFormatException exception) {
                System.out.println(TextFormatting.getRedText("Wrong arguments, enter again:"));
            }
        } else if (command[0].equals("count_less_than_government") & command.length == 2) {
            if (!Government.isPresent(command[1].toUpperCase())) {
                System.out.println(TextFormatting.getRedText("There is no such element"));
            } else {
                CountLessThanGovernment countLessThanGovernment = new CountLessThanGovernment();
                countLessThanGovernment.countLessThanGovernment(Government.valueOf(command[1].toUpperCase()), collection);
            }
        } else if (command[0].equals("count_greater_than_government") & command.length == 2) {
            if (!Government.isPresent(command[1].toUpperCase())) {
                System.out.println(TextFormatting.getRedText("There is no such element"));
            } else {
                CountGreaterThanGovernment countGreaterThanGovernment = new CountGreaterThanGovernment();
                countGreaterThanGovernment.countGreaterThanGovernment(Government.valueOf(command[1].toUpperCase()), collection);
            }
        } else if (command[0].equals("exit") & command.length == 1) {
            return 1;
        } else {
            if (paths.size() > 0) {
                System.out.println(TextFormatting.getRedText("While executing commands from a file, " +
                        "an error occurred in a file with a path: " + paths.get(paths.size() - 1)));
                System.out.println();
                paths.clear();
                return 3;
            }
            System.out.println(TextFormatting.getRedText("An unknown command was entered"));
            System.out.println(TextFormatting.getGreenText("Enter again: "));
            System.out.println();
        }
        return 0;
    }
}
