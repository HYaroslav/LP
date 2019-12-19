package menu.commands.mainMenuCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class SaveAutoPark implements Command{
	MenuReceiver m;
	
	public SaveAutoPark(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.saveAutoPark();; }

	public void undo() { m.homeMenu(); }
}
