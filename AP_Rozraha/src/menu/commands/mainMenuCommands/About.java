package menu.commands.mainMenuCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class About implements Command{
	MenuReceiver m;
	
	public About(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.about(); }

	public void undo() { m.homeMenu(); }
}
