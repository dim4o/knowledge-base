package kb.design_patterns.command;

/**
 * Represents the Invoker object. Can implement an interface.
 * 
 * @author dimcho.nedev
 */
public class Invoker {
    private Executable command;
    public void setCommand(Executable command) {
        this.command = command;
    };
    
    public void printDirectoryFiles() {
        command.execute();
    }
    
}
