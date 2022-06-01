package command;
import java.util.ArrayList;
import java.util.Collection;


public class Log {

	private Collection<ICommand> commands = new ArrayList<>();
	private Collection<ICommand> undolist = new ArrayList<>();

	public void undo(){	
		if (commands.size()>0){
		ICommand commandObject = (ICommand)((ArrayList<?>) commands).get(commands.size()-1);
		commands.remove(commandObject);
		commandObject.undo();
		undolist.add(commandObject);
		}
	}
	public void redo(){
		if (undolist.size()>0){
		ICommand commandObject = (ICommand)((ArrayList<?>)undolist).get(undolist.size()-1);
		commandObject.execute();
		undolist.remove(commandObject);
		commands.add(commandObject);
		}
	}



	public void addCommand(ICommand commandObject){
		commands.add(commandObject);
	}

}
