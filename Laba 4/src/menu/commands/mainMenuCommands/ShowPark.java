package menu.commands.mainMenuCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class ShowPark implements Command{
	MenuReceiver m;
	
	public ShowPark(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.showPark(); }

	public void undo() { m.homeMenu(); }
}
