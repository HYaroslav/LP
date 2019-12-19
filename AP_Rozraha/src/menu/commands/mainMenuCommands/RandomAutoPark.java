package menu.commands.mainMenuCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class RandomAutoPark implements Command{
	MenuReceiver m;
	
	public RandomAutoPark(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.createNewRandomAutoPark(); }

	public void undo() { m.homeMenu(); }
}
