package kb.design_patterns.command;

import java.io.File;

public class ClientApp {
    public static void main(String[] args) {
        // Here the File object is the Receiver
        File file = new File(".");

        // Represents a concrete command
        ListDirectoryCommand cmd = new ListDirectoryCommand(file);

        // Invoker object instance
        Invoker inv = new Invoker();
        
        // Set a command
        inv.setCommand(cmd);

        inv.printDirectoryFiles();

    }

}
