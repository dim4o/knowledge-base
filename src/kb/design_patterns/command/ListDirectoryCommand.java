package kb.design_patterns.command;

import java.io.File;

/**
 * Represents a concrete command.
 * 
 * @author dimcho.nedev
 */
public class ListDirectoryCommand implements Executable {
    private File file;

    public ListDirectoryCommand(File file) {
        this.file = file;
    }

    @Override
    public void execute() {
        String[] names = file.list();
        for (String name : names)
            System.out.println(name);
    }

}
