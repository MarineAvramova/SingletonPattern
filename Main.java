import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner enter = new Scanner(System.in);
	
	public static void main(String[] args) {
		int option = 0;
		String response = "";
		String command = "";
		String commandToDelete ="";
		
		Undo undo = Undo.getInstance();
		
		while (option != 4) {
			System.out.println("Menu of commands:\n" + "1. Add command.\n" +
		                                            "2. See of all commands.\n" +
		                                            "3. Delete command.\n" +
		                                            "4. Exit.\n");
			option = enter.nextInt();
			enter.nextLine();
			switch(option) {
			case 1:
				System.out.println("Enter a command:");
				command = enter.nextLine();
				response = undo.addCommand(command);
				break;
			case 2: 
				List<String> commands = undo.getCommands();
                if (commands.isEmpty()) {
                    System.out.println("No commands to display.");
                } else {
                    System.out.println("List of commands:");
                    for (String Listcommand : commands) {
                        System.out.println(Listcommand);
                    }
                }
                response = "";
                break;
			case 3:
				System.out.println("Enter a command to delete:");
                commandToDelete = enter.nextLine();
                undo.removeCommand(commandToDelete);
                response = "Command deleted.";
				break;
			case 4: 
				System.out.println("Buy!");
			}
			System.out.println(response);
			
		}
	}

}
