import java.util.ArrayList;

public class Undo {

	private static Undo instance;
	private ArrayList<String> commands = new ArrayList<String>();
	
	private Undo() {
	
	}
	
	public static Undo getInstance() {
		if (instance == null) {
			synchronized(Undo.class) {
				if(instance == null) {
					 instance = new Undo();
				}
			}
         }
		return instance;
	}
	
	public String addCommand(String command) {
		commands.add(command); 
	 return "The command " + command + " has been created.\n";
	}

	/**
	 * @return the commands
	 */
	public ArrayList<String> getCommands() {
		return  commands;
	}
	
	public String removeCommand(String command) {
		int foundIndex = -1;
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).equalsIgnoreCase(command)) {
                foundIndex = i;
                break; 
            }
        }

        if (foundIndex != -1) {
            commands.remove(foundIndex);
            return "Command deleted: " + command;
        } else {
            return "Command not found.";
        }
    }
	
	
	public int getCommandSize() {
		return commands.size();
		
	}
}
