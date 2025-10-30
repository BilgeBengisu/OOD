/*
 * Create a PredictionInvoker class to manage and execute tasks in the correct order. This class will:
 * Allow commands (representing each task) to be added to a list using addCommand().
 * Execute all commands in sequence using executeCommands().
 * The PredictionInvoker class provides flexibility to track, add, or remove individual steps without changing the overall workflow.
*/

public class PredictionInvoker {
    private List<Command> commands;

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        for ( Command command : commands ) {
            command.execute();
        } 
    }
}