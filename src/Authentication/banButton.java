package Authentication;

public class banButton {
	
	Command theCommand;
	
	public banButton(Command newCommand){
		
		theCommand = newCommand;
	}
	
	public void press(){
		theCommand.execute();
	}
	
	public void pressUndo(){
		theCommand.undo();
	}
}
