package menu;

import java.util.ArrayList;

import menu.commands.Command;

public class MenuInvoker{
	ArrayList<Command> history;
	Command command;
	
	public MenuInvoker() {
		history = new ArrayList<Command>();
	}
	
	public void run(Command cmd) {
		command = cmd;
		history.add(cmd);
		command.execute();
	}
	
	public void undo() {
		command.undo();
		history.remove(history.size() - 1);
		command = history.get(history.size() - 1);
	}
	
}
