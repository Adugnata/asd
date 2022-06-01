public class RemoteControl {
    Command slot;
    public void setCommand(Command command){
        slot = command;
    }
    public  void buttonWasPressed(){
        slot.execute();
    }
}
