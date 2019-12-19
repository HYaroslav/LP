package menu.commands.mainMenuCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class LoadAutoPark implements Command{
	MenuReceiver m;
	
	public LoadAutoPark(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.loadAutoPark();; }

	public void undo() { m.homeMenu(); }
}
