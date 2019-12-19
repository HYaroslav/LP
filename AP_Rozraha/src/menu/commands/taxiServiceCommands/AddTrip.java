package menu.commands.taxiServiceCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class AddTrip implements Command{
	MenuReceiver m;
	
	public AddTrip(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.addTrip(); }
	
	public void undo() { m.taxiServices(); }
}
