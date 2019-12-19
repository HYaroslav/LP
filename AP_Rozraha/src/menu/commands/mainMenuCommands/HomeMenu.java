package menu.commands.mainMenuCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class HomeMenu implements Command{
	MenuReceiver m;
	
	public HomeMenu(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.homeMenu(); }
	
	public void undo() { System.exit(0); }
}
